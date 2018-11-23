/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;

import java.lang.annotation.*;

/**
 * 注解组合别名232
 * @author wb-lcj442691
 * @version $Id: AliasFor.java, v 0.1 2018年11月14日 9:00 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
@Inherited
public @interface AliasFor {
    /**
     * 组合那个class
     */
    Class targetClass = null;
    /**
     * 组合那个属性
     */
    String attribute =null;


}