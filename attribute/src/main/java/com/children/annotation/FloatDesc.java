/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;

import com.children.gernater.Strategy;

import java.lang.annotation.*;

/**
 *
 * @author wb-lcj442691
 * @version $Id: DoubleDesc.java, v 0.1 2018年11月23日 18:48 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface FloatDesc {
    boolean  canNull() default  false;
    float  maxValue() default Float.MAX_VALUE;
    float  minValue()  default  Float.MIN_VALUE;
    float [] valueEnum() default {};
    /**
     * 数据校验
     */
    IMessage target  = null  ;
    /**
     * 数据生成
     */
    Strategy strategy() ;
}