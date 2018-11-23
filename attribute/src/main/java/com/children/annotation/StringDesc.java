/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;


import com.children.gernater.Strategy;

import java.lang.annotation.*;

/**
 * @author wb-lcj442691
 * @version $Id: StringDesc.java, v 0.1 2018年11月14日 9:18 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@Inherited
public @interface StringDesc {
    boolean  canNull() default   false;
    int  maxLength()  default Integer.MAX_VALUE;
    int  minLength() default  Integer.MIN_VALUE;
    int  fixLength() default  0;
    int  ranLength() default 0;
    char [] randomChar() default {};
    String dataSource() default "";
    /**
     * 指定前缀后缀
     * @return
     */
    String[] prefix() default {};
    String[]  suffix() default {};
    /**数据校验
     */
    String   pattern() default "" ;
    /**
     * 数据校验结果对应
     */
    IMessage target= null;
    /**
     * 数据生成器
     */
    Strategy strategy() ;

}