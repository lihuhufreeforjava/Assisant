/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import com.children.annotation.DateTimeDesc;
import com.children.annotation.IntegerDesc;
import com.children.annotation.StringDesc;
import com.children.gernater.DataGenAttr;
import com.children.gernater.DataSource;
import com.children.gernater.Strategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wb-lcj442691
 * @version $Id: DataGenerateCore.java, v 0.1 2018年11月15日 17:09 wb-lcj442691 Exp $
 */

public class DataGenerateAssist<T> {
    private List<DataGenAttr> dataGenAttrList = new ArrayList<DataGenAttr>();



    /**
     * 1.获取对象每个字段生成策略 2.获取策略对应的数据生成器 3.生成数据注入字段 4.返回对象
     */
    public T injectData(T t) throws IllegalAccessException {
        Field[] fields = t.getClass().getDeclaredFields();
        dataGenAttrList.clear();
        /**
         * 获取对应字段生成器
         */
        for (Field f : fields) {
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                DataGenAttr attr = bindDataGenAttr(annotation, f, t);
                dataGenAttrList.add(attr);
            }
        }
        /**
         * 生成数据
         */
        for(DataGenAttr dataGenAttr:dataGenAttrList){
            Field temp=dataGenAttr.getField();
            temp.setAccessible(true);
            temp.set(t,dataGenAttr.getDataGen().gen());
        }
        return t;
    }

    public DataGenAttr bindDataGenAttr(Annotation annotation, Field field, T t) {
        DataGenAttr dataGenAttr = null;
        Strategy strategy = null;
        dataGenAttr = new DataGenAttr();
        dataGenAttr.setField(field);
        if (annotation.annotationType().equals(IntegerDesc.class)) {
            strategy = ((IntegerDesc) annotation).strategy();
        }
        if (annotation.annotationType().equals(StringDesc.class)) {
            strategy = ((StringDesc) annotation).strategy();
        }
        if (annotation.annotationType().equals(DateTimeDesc.class)) {
            strategy = ((DateTimeDesc) annotation).strategy();
        }
        DataGen dataGen = paserDataGen(strategy,annotation);
        dataGenAttr.setDataGen(dataGen);
        return dataGenAttr;
    }

    public DataGen paserDataGen(Strategy strategy,Annotation annotation) {
        switch (strategy) {
            //整形 枚举集合->枚举集合数据
            case Integer_Enum: {
                int [] array=((IntegerDesc) annotation).valueEnum();
                return new IntegerGenEnum(array);
            }
            //指定最大值最小值 >依次递增
            case Integer_Auto_Increment_No_Repeat: {
                int max=((IntegerDesc) annotation).maxValue();
                int min=((IntegerDesc) annotation).minValue();
                return new IntegerGenIncrementNoRepeat(max,min);
            }
            //指定最大值最小值》随机生成之间的数据
            case Integer_Auto_Increment_Repeat: {
                int max=((IntegerDesc) annotation).maxValue();
                int min=((IntegerDesc) annotation).minValue();
                return new IntegerGenRandomBetweenMaxAndMin(max,min);
            }
            //指定原数据》生成固定长度的数据
            case String_Fix_Length: {
                int fixLength=((StringDesc)annotation).fixLength();
                String source=((StringDesc)annotation).dataSource();
                return new StringGenFixLength(fixLength,source);
            }
            //指定原数据序列>生成固定元数据（可指定文本头 文本尾）
            case String_Fill_Fix_Length: {
                int fixLength=((StringDesc)annotation).fixLength();
                String []prifix=((StringDesc)annotation).prefix();
                String []suffix=((StringDesc)annotation).suffix();
                char []randomChar=((StringDesc)annotation).randomChar();
                return new StringGenFillFixLengthPrefixSuffix(prifix,suffix,fixLength,randomChar);
            }
            //指定原数据 》生成随机长度字符串
            case String_Random_Length: {
                int maxLen=((StringDesc)annotation).maxLength();
                int minLen=((StringDesc)annotation).minLength();
                int randomLen=((StringDesc)annotation).ranLength();
                String source=((StringDesc)annotation).dataSource();
                return new StringGenRandomLength(maxLen,minLen,randomLen,source);
            }
            //指定最大时间 最小时间》生成随机时间
            case Date_Random_Between: {
                String maxDate=((DateTimeDesc)annotation).maxDate();
                String minDate=((DateTimeDesc)annotation).minDate();
                return new DateTimeGenRandomBetweenMaxAndMin(maxDate,minDate);
            }
            default:
                return null;
        }

    }

}

