/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 随机生成 不重复
 * @author wb-lcj442691
 * @version $Id: IntegerFirstGen.java, v 0.1 2018年11月19日 9:24 wb-lcj442691 Exp $
 */
public class IntegerGenAINR extends  IntegerGenAbstract{
    private AtomicInteger min=null;
    public IntegerGenAINR(int max,int paramMin){
        super.max=max;
        this.min=new AtomicInteger(paramMin);
    }
    @Override
    public Integer gen() {
        if(min.intValue()<super.max){
           return  min.getAndIncrement();
        }
        return  super.max;
    }
}