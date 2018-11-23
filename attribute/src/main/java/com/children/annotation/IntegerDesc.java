/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;


import com.children.gernater.Strategy;

import java.lang.annotation.*;

/**
 *
 * @author wb-lcj442691
 * @version $Id: IntegerAttr.java, v 0.1 2018年11月14日 8:56 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface IntegerDesc {
    int  maxValue() default Integer.MAX_VALUE;
    int  minValue()  default  Integer.MIN_VALUE;
    boolean  canNull() default  false;
    int [] valueEnum() default {};
    String   pattern()   default "";
    /**
     * 数据校验
     */
    IMessage target  = null  ;
    /**
     * 数据生成
     */
    Strategy  strategy() ;


}