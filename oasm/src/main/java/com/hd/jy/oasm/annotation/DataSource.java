package com.hd.jy.oasm.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author quite
 *定义DataSource注解，每次调用不同的数据库加上注解
 */
 @Target({ ElementType.TYPE, ElementType.METHOD })
 @Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
   String value();
}
