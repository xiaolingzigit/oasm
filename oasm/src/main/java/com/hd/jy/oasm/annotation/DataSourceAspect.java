package com.hd.jy.oasm.annotation;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.hd.jy.oasm.util.DynamicDataSourceHolder;

public class DataSourceAspect {
  /***
   * ����Ŀ�귽������ȡ��@DataSourceָ��������Դ��ʶ�����õ��̴߳洢���Ա��л�����Դ
   * @author quite
   */
	public void intercept(JoinPoint point) throws Exception {
		        Class<?> target = point.getTarget().getClass();
		        MethodSignature signature = (MethodSignature) point.getSignature();
		        // Ĭ��ʹ��Ŀ�����͵�ע�⣬���û����ʹ����ʵ�ֽӿڵ�ע��
		        for (Class<?> clazz : target.getInterfaces()) {
		             resolveDataSource(clazz, signature.getMethod());
		         }
		        resolveDataSource(target, signature.getMethod());
		    }
		
		    /**
	     * ��ȡĿ����󷽷�ע�������ע���е�����Դ��ʶ
	     * 
		      * @param clazz
		      * @param method
		      */
		     private void resolveDataSource(Class<?> clazz, Method method) {
		       try {
		           Class<?>[] types = method.getParameterTypes();
		           // Ĭ��ʹ������ע��
		             if (clazz.isAnnotationPresent(DataSource.class)) {
		                 DataSource source = clazz.getAnnotation(DataSource.class);
		                DynamicDataSourceHolder.setDataSource(source.value());
		            }
		             // ����ע����Ը�������ע��
		           Method m = clazz.getMethod(method.getName(), types);
		            if (m != null && m.isAnnotationPresent(DataSource.class)) {
		                DataSource source = m.getAnnotation(DataSource.class);
		               DynamicDataSourceHolder.setDataSource(source.value());
		            }
		       } catch (Exception e) {
		           System.out.println(clazz + ":" + e.getMessage());
		        }
		  }
}
