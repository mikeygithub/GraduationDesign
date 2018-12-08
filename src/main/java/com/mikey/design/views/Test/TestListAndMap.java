package com.mikey.design.views.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/8 17:16
 * @Version 1.0
 */
public class TestListAndMap {
    public static void main(String[] args){

        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println("length="+list.size());
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println("length="+list.size());
    }
}
