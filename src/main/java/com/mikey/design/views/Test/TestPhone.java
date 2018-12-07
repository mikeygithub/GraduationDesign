package com.mikey.design.views.Test;

import java.util.regex.Pattern;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/7 14:29
 * @Version 1.0
 */

public class TestPhone {
    public static final String REGEX_MOBILE ="^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
    public static final String Name="^[\u4E00-\u9FA5]{2,4}$";
    public static void main(String[] args){
        String userPhone="18276297824";
       System.out.println(Pattern.matches(REGEX_MOBILE,userPhone));
       String pwd="123456aaVV";
       System.out.println(Pattern.matches(REGEX_PASSWORD,pwd));
        String name="麦3奇";
        System.out.println(Pattern.matches(Name,name));
    }
}
