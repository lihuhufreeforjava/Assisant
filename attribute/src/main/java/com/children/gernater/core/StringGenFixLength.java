/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;


import java.util.Random;

/**
 *  固定长度  字符串
 * @author wb-lcj442691
 * @version $Id: StringGenFixLength.java, v 0.1 2018年11月19日 10:20 wb-lcj442691 Exp $
 */
public class StringGenFixLength extends  StringGenAbstract {
  private  String textSource=null;
    public Integer fixLength=null;

  public StringGenFixLength(Integer fixLength,String source){
      this.fixLength=fixLength;
      this.textSource=source;
  }

    @Override
    public String gen() {
        Random random=new Random();
        int start=random.nextInt(textSource.length()-fixLength);
        return   textSource.substring(start,start+fixLength);
    }
    public StringGenFixLength setTextSource(String source){
      this.textSource=source;
      return  this;
    }
}