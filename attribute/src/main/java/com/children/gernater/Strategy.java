/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater;

import java.util.Date;

/**
 * @author wb-lcj442691
 * @version $Id: Strategy.java, v 0.1 2018年11月15日 17:07 wb-lcj442691 Exp $
 */
public enum Strategy {
    Integer_Enum(Integer.class,"枚举值，可以指定数据值为枚举或者自动为0123456789"),
    Integer_Auto_Increment_No_Repeat(Integer.class, "自动递增不可重复"),
    Integer_Auto_Increment_Repeat(Integer.class, "自动随机可重复"),
    String_Fix_Length(String.class, "定长字符串"),
    String_Fill_Fix_Length(String.class,"定长字符串，填充类型-电话号码，区号"),
    String_Random_Length(String.class, "不定长随机字符串"),
    Date_Random_Between(Date.class,"在时间段内的随机时间"),
    ;
    private Class c;
    private String desc;
    Strategy(Class c,String desc){
        this.c=c;
        this.desc=desc;
    }

}