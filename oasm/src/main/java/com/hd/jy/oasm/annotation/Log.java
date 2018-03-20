package com.hd.jy.oasm.annotation;

import java.lang.annotation.*;
/**
 * 
 * @author quite
 *�Զ���ע��
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	//Ҫ���������ͣ���add��delete��update��select����
    public String operationType() default "";
    //����Ĳ������ͣ�������û�  
    public String operationName() default "";
}
