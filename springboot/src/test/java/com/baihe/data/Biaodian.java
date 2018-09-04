package com.baihe.data;

import java.util.regex.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * Created by Administrator on 2018/8/22.
 */
public class Biaodian {
    public static void main(String[] args) {
        String testStr = " ";

        Pattern pattern = Pattern.compile("\\s{1}");
        Matcher matcher = pattern.matcher(testStr);
        boolean matches = matcher.matches();
        System.out.println(matches);


        boolean boo =testStr.matches("\\s{1}");
        System.out.println(boo);

        String pattern1="\\s{1}";
        String zifu="[\\u4e00-\\u9fa5]{5}";
        String mobile="0?(13|14|15|18|17)[0-9]{9}";
        boolean matches1 = Pattern.matches(mobile, "13231251251");
        System.out.println(matches1);
    }
}
