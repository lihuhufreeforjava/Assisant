/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

/**
 *
 * @author wb-lcj442691
 * @version $Id: StringGenerate.java, v 0.1 2018年11月16日 15:05 wb-lcj442691 Exp $
 */
public abstract class StringGenAbstract implements  DataGen<String> {
 public  boolean canNull=true;
 public String []prifix=null;
 public String []suffix=null;
 public Integer maxLength=Integer.MAX_VALUE;
 public Integer minLength=0;

}