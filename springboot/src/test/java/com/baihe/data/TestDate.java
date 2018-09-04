package com.baihe.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/21.
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {

        // long -->yyyy-MM-dd
        long l= 26090704155621L;
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date(l));

        System.out.println(format);
        // yyyy-MM-dd --> long
        Date parse = simpleDateFormat.parse(format);
        long time = parse.getTime();

        System.out.println(time);


    }
}
