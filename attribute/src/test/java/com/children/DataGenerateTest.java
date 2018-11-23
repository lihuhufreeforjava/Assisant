/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children;

import com.children.gernater.core.DataGenerateAssist;

/**
 *
 * @author wb-lcj442691
 * @version $Id: DataGenerateTest.java, v 0.1 2018年11月19日 10:42 wb-lcj442691 Exp $
 */
public class DataGenerateTest {
    public static void main(String[] args) throws IllegalAccessException {

        DataGenerateAssist<HumanInfo> dataGenerateAssist=new DataGenerateAssist<HumanInfo>();
        HumanInfo humanInfo=null;
        for (int i=0;i<100;i++){
            humanInfo=new HumanInfo();
            dataGenerateAssist.injectData(humanInfo);
            System.out.println(humanInfo);
        }

    }

}