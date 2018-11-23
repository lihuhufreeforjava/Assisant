/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

/**
 *
 * @author wb-lcj442691
 * @version $Id: IntegerGenerator.java, v 0.1 2018年11月16日 15:02 wb-lcj442691 Exp $
 */
public abstract  class IntegerGenAbstract implements  DataGen<Integer> {
    public  Integer min=Integer.MIN_VALUE;
    public Integer max=Integer.MAX_VALUE;
    public Boolean canNull=false;

}