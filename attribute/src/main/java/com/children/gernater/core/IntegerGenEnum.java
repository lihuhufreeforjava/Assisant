/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.util.Random;

/**
 *
 * @author wb-lcj442691
 * @version $Id: IntegerGenEnum.java, v 0.1 2018年11月19日 14:33 wb-lcj442691 Exp $
 */
public class IntegerGenEnum extends  IntegerGenAbstract {
    private int []enums=new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int length=10;

    public IntegerGenEnum(){}
    public IntegerGenEnum(int []arr){
        this.enums=arr;
        this.length=arr.length;
    }

    @Override
    public Integer gen() {
        Random random=new Random();
        int index= random.nextInt(length);
        return enums[index];
    }
}