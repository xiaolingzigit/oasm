package com.hd.jy.oasm.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author quite
 *����DataSourceע�⣬ÿ�ε��ò�ͬ�����ݿ����ע��
 */
 @Target({ ElementType.TYPE, ElementType.METHOD })
 @Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
   String value();
}
