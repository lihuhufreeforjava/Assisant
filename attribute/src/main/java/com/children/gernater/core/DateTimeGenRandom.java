/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.gernater.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 随机时间
 *
 * @author wb-lcj442691
 * @version $Id: DateTimeGenRandom.java, v 0.1 2018年11月19日 15:16 wb-lcj442691 Exp $
 */
public class DateTimeGenRandom extends DateTimeGenAbstract {
    private String maxDate;
    private String minDate;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public DateTimeGenRandom(String maxDate, String minDate) {
        this.maxDate = maxDate;
        this.minDate = minDate;
    }

    @Override
    public Date gen() {
        try {
            Date start=simpleDateFormat.parse(maxDate);
            Date end=simpleDateFormat.parse(minDate);
            long randomeDate = random(start.getTime(), end.getTime());
            return new Date(randomeDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

}