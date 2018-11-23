/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;


/**
 * 是否为空
 * @author wb-lcj442691
 * @version $Id: NullAble.java, v 0.1 2018年11月14日 8:54 wb-lcj442691 Exp $
 */
public @interface Nullble {
    Boolean  isNullAble =false;
    /**
     * 数据校验结果对应
     */
    IMessage target     =null;


}