/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater;

/**
 *  数据清除
 * @author wb-lcj442691
 * @version $Id: DataSourceClean.java, v 0.1 2018年11月19日 15:08 wb-lcj442691 Exp $
 */
public class DataSourceClean {
    /**
     * 去掉标点符号
     * @param text
     * @return
     */
    public static String cleanPunctuation(String text){
        return text.replaceAll( "[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "")
                .replaceAll( "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "");

    }
}