package com.children; /**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */


import com.children.annotation.DateTimeDesc;
import com.children.annotation.IntegerDesc;
import com.children.annotation.StringDesc;
import com.children.gernater.DataSource;
import com.children.gernater.Strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wb-lcj442691
 * @version $Id: HumanInfo.java, v 0.1 2018年11月12日 11:26 wb-lcj442691 Exp $
 */
public class HumanInfo {

    @StringDesc(fixLength = 10,canNull = false,strategy = Strategy.String_Fix_Length,maxLength = 20,minLength = 5,prefix = {"赵","钱","孙","李","周","吴","证","王","往","汪","因","银","虎","胡","锚","土","田","商","家","刘","往","的","方","若","山","地方","上","东方","浩","好","的","到","电费","高"})
    private String name;
    @IntegerDesc(maxValue=100,minValue = 0,canNull =false,strategy=Strategy.Integer_Auto_Increment_Repeat)
    private Integer age;
    @IntegerDesc(valueEnum = {1, 2}, strategy = Strategy.Integer_Enum)
    private Integer sex;
    @StringDesc(dataSource = DataSource.article,prefix = {"177","158","133"},strategy = Strategy.String_Fill_Fix_Length,maxLength = 11,fixLength = 11,randomChar = {'1','2','3','4','5','6','7','8','9','0'})
    private String  phone;
    @DateTimeDesc(maxDate = "2018-11-11",minDate = "1990-11-05",strategy = Strategy.Date_Random_Between)
    private Date   birthday;

    public HumanInfo() {}

    @Override
    public String toString() {
        return "HumanInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", birthday=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthday) +
                '}';
    }
}