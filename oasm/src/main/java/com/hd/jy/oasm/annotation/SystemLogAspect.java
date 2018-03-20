package com.hd.jy.oasm.annotation;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hd.jy.oasm.services.SystemLogService;
import com.hd.jy.oasm.util.CryptographyUtil;
import com.hd.jy.oasm.util.domain.SystemLog;

/**
* @ClassName: SystemLogAspect 
* @author quite
 */
@Aspect
public class SystemLogAspect {
    //调用service的insert方法添加日志
	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private SystemLogService systemLogService;
	
	@Autowired(required=false)
	private HttpServletRequest request;
	
	@Autowired(required=false)  
	private HttpSession session;  

	
	private static final Logger logg = LoggerFactory.getLogger(SystemLogAspect.class);
	@Pointcut("execution(* com.*.*Controller.*(..))")
//	@Pointcut("@annotation(com.hd.jy.oasm.annotation.Log)") 
	public void anyMethod(){
	}
	//前置通知，记住不要缺失()
	@Before("anyMethod()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("*******************************************【执行前置通知】***********************************************************");
		//定义的是log4j的info级别以上都会保存到数据库中
		if(logg.isInfoEnabled()){  
			logg.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			logg.info("***********************************************【前置通知"+joinPoint+"】***************************************************");
			logg.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
	}
	@SuppressWarnings("static-access")
	@After("anyMethod()")
	public void doAfter(JoinPoint joinPoint){
		String username = (String)session.getAttribute("username");
		SystemLog log = new SystemLog();
		String params = "";
		try {
			
			String ipdz = getIP();
			String targetName = joinPoint.getTarget().getClass().getName(); //目标名字
			//操作的方法
			String methodName = joinPoint.getSignature().getName();
			Object[] argument = joinPoint.getArgs();
			if(!(argument.length<0)){ //判断参数是
				for (Object obj : argument) {
					params+=obj+"&&";
				}
			}else{
				params+="";
			}
			
			
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if(method.getName().equals(methodName)){
					Class<?>[] clazz = method.getParameterTypes();
					if(clazz.length==argument.length){
						operationType = method.getAnnotation(Log.class).operationType();
						operationName = method.getAnnotation(Log.class).operationName();
						break;
					}
				}
			}
			//*************************控制台输出**************************
			System.out.println("***************************【Controller后置通知开始】**************************");
			System.out.println("***************************【请求方法："+(joinPoint.getTarget().getClass().getName())+"."+(joinPoint.getSignature().getName()+"()"+"."+operationType)+"********************************");
			System.out.println("***************************【方法描述:"+operationName+"】**************************************************************************");
			System.out.println("***************************【请求ip:"+ipdz+"】*************************************************************************************");
			System.out.println("***************************【请求参数:"+params+"】*************************************************************************************");
			//*******************数据库日志***************
			if(null!=username&&""!=username){
				log.setId(UUID.randomUUID().toString());
				log.setDescription(operationName); //操作动作
				log.setMethod(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()"+"."+operationType); //操作方法加注释
				log.setLogType(0); //操作类型
				log.setRequireIP(ipdz); //操作的ip
				log.setExceptionCode(null); //异常代码
				log.setExceptionDetail(null); //异常类型
				log.setParams(CryptographyUtil.enBase64(params.trim())); //加密后的参数
				log.setCreateBy(username); //操作员
				log.setCreateDate(sdf.format(new Date()));
				//调用存储方法
				int i = systemLogService.insertLog(log);
				if(i>0){
					logg.info("日志保存数据库【"+i+"条】成功！");
				}else
				{
					System.out.println("日志存储数据库失败！");
				}
			}else{
				logg.info("操作日志入库失败，原因：操作员为【"+username+"】");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logg.error("=========后置通知异常，异常信息【暂未注解切面方法对日志进行入库存储】=========");  
//			logg.error("异常信息:{}"+e.getMessage(),e);  
		}
	}
	//******************配置后置返回通知*****************************
	@AfterReturning("anyMethod()")
	public void afterReturn(JoinPoint joinPoint){
		if(logg.isInfoEnabled()){
			logg.info("**************************【Return后置通知:"+joinPoint+"】****************************************************");
		}
	}
	
	//获取访问的主机的地址
	public  String getIP() {
        String ip = request.getHeader("x-forwarded-for");
        if (!checkIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!checkIP(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private static boolean checkIP(String ip) {
        if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
                || ip.split(".").length != 4) {
            return false;
        }
        return true;
    }
}
