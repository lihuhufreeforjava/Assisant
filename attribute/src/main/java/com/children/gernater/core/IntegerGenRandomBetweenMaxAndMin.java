/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.util.Random;

/**
 *
 * @author wb-lcj442691
 * @version $Id: IntegerGenAIR.java, v 0.1 2018年11月19日 9:26 wb-lcj442691 Exp $
 */
public class IntegerGenRandomBetweenMaxAndMin extends IntegerGenAbstract {

    public IntegerGenRandomBetweenMaxAndMin(int max,int min){
        super.max=max;
        super.min=min;
    }
    @Override
    public Integer gen() {
        Random random=new Random();
        return   random.nextInt(super.max-super.min)+min;
    }
}