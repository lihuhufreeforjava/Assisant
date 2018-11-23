/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.util.Random;

/**
 *  随机长度  字符串
 * @author wb-lcj442691
 * @version $Id: StringGenRandom.java, v 0.1 2018年11月19日 10:17 wb-lcj442691 Exp $
 */
public class StringGenRandomLength  extends  StringGenAbstract{
    private  String textSource=null;
    public Integer randomLength=null;

    public StringGenRandomLength(int maxlen,int minlen,Integer randomLength,String source){
        super.canNull=false;
        super.maxLength=maxlen;
        super.minLength=minlen;
        this.randomLength=randomLength;
        if(randomLength==null||randomLength==0){
            this.randomLength=maxlen;
        }
        this.textSource=source;
    }
    @Override
    public String gen() {
        Random random=new Random();
        int start=random.nextInt(maxLength);
        int length=random.nextInt(randomLength);
        int end=maxLength;
        if((start+length)<maxLength){
            end=start+length;
        }
        return textSource.substring(start,end);
    }
    public StringGenRandomLength setTextSource(String source){
        this.textSource=source;
        return  this;
    }

}