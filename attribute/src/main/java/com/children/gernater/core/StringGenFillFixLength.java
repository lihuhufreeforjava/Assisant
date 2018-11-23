/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.util.Random;

/**
 * @author wb-lcj442691
 * @version $Id: StringGenFixLengthRan.java, v 0.1 2018年11月19日 16:41 wb-lcj442691 Exp $
 */
public class StringGenFillFixLength extends StringGenAbstract {
    private char[] arr;

    public StringGenFillFixLength(int maxLength, char[] arr) {
        this.arr = arr;
        super.maxLength = maxLength;
    }

    public StringGenFillFixLength(String[] prefix, int maxLength, char[] arr) {
        this.arr = arr;
        super.maxLength = maxLength;
        super.prifix = prefix;
    }
    public StringGenFillFixLength(String[] prefix, String[] suffix,int maxLength, char[] arr) {
        this.arr = arr;
        super.maxLength = maxLength;
        super.prifix = prefix;
        super.suffix=suffix;
    }

    @Override
    public String gen() {
        StringBuilder sb = new StringBuilder();
        /**
         * 没有前缀后缀
         */
        int genLen=0;
        if (prifix .length== 0 && suffix .length== 0) {
            genLen= maxLength;
        } else if (prifix .length!= 0 && suffix .length== 0) {
            int index = new Random().nextInt(prifix.length);
            String prifixStart = prifix[index];
            sb = new StringBuilder(prifixStart);
            genLen= maxLength - prifix.length;

        } else if (prifix .length!= 0 && suffix .length!= 0) {
            int index = new Random().nextInt(prifix.length);
            String prifixStart = prifix[index];
            sb = new StringBuilder(prifixStart);
            genLen= maxLength - suffix.length-prifix.length;
        }
        Random random = new Random();
        while (genLen-->0) {
            sb.append(arr[random.nextInt(arr.length)]);
        }
        return sb.toString();

    }


    }