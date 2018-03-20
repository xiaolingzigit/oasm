package com.hd.jy.oasm.annotation;

import java.lang.annotation.*;
/**
 * 
 * @author quite
 *自定义注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	//要操作的类型：如add、delete、update、select类型
    public String operationType() default "";
    //具体的操作类型：如添加用户  
    public String operationName() default "";
}
