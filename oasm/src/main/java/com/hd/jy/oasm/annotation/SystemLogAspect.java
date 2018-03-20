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
    //����service��insert���������־
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
	//ǰ��֪ͨ����ס��Ҫȱʧ()
	@Before("anyMethod()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("*******************************************��ִ��ǰ��֪ͨ��***********************************************************");
		//�������log4j��info�������϶��ᱣ�浽���ݿ���
		if(logg.isInfoEnabled()){  
			logg.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			logg.info("***********************************************��ǰ��֪ͨ"+joinPoint+"��***************************************************");
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
			String targetName = joinPoint.getTarget().getClass().getName(); //Ŀ������
			//�����ķ���
			String methodName = joinPoint.getSignature().getName();
			Object[] argument = joinPoint.getArgs();
			if(!(argument.length<0)){ //�жϲ�����
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
			//*************************����̨���**************************
			System.out.println("***************************��Controller����֪ͨ��ʼ��**************************");
			System.out.println("***************************�����󷽷���"+(joinPoint.getTarget().getClass().getName())+"."+(joinPoint.getSignature().getName()+"()"+"."+operationType)+"********************************");
			System.out.println("***************************����������:"+operationName+"��**************************************************************************");
			System.out.println("***************************������ip:"+ipdz+"��*************************************************************************************");
			System.out.println("***************************���������:"+params+"��*************************************************************************************");
			//*******************���ݿ���־***************
			if(null!=username&&""!=username){
				log.setId(UUID.randomUUID().toString());
				log.setDescription(operationName); //��������
				log.setMethod(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()"+"."+operationType); //����������ע��
				log.setLogType(0); //��������
				log.setRequireIP(ipdz); //������ip
				log.setExceptionCode(null); //�쳣����
				log.setExceptionDetail(null); //�쳣����
				log.setParams(CryptographyUtil.enBase64(params.trim())); //���ܺ�Ĳ���
				log.setCreateBy(username); //����Ա
				log.setCreateDate(sdf.format(new Date()));
				//���ô洢����
				int i = systemLogService.insertLog(log);
				if(i>0){
					logg.info("��־�������ݿ⡾"+i+"�����ɹ���");
				}else
				{
					System.out.println("��־�洢���ݿ�ʧ�ܣ�");
				}
			}else{
				logg.info("������־���ʧ�ܣ�ԭ�򣺲���ԱΪ��"+username+"��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logg.error("=========����֪ͨ�쳣���쳣��Ϣ����δע�����淽������־�������洢��=========");  
//			logg.error("�쳣��Ϣ:{}"+e.getMessage(),e);  
		}
	}
	//******************���ú��÷���֪ͨ*****************************
	@AfterReturning("anyMethod()")
	public void afterReturn(JoinPoint joinPoint){
		if(logg.isInfoEnabled()){
			logg.info("**************************��Return����֪ͨ:"+joinPoint+"��****************************************************");
		}
	}
	
	//��ȡ���ʵ������ĵ�ַ
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
