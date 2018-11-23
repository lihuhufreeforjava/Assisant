/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;


import com.children.gernater.Strategy;

import java.lang.annotation.*;

/**
 *
 * @author wb-lcj442691
 * @version $Id: DateTimeDesc.java, v 0.1 2018年11月14日 9:24 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface DateTimeDesc {
    boolean canNull = false;
    String    maxDate();
    String    minDate();
    Strategy  strategy();
    /**
     * 日期样式
     * @return
     */
    String pattern() default "yyyy-MM-dd HH:mm";
    /**
     * 数据校验结果对应
     */
    IMessage target     =null;

}