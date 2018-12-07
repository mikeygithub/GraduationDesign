package com.mikey.design.utils;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 20:11
 * @Version 1.0
 */
public class ThreadLocallUtil {
    public static ThreadLocal<Object> threadLocal=new ThreadLocal<Object>();

    /**
     * 添加登入用户到本地线程
     * @param object
     */
    public static void set(Object object){
        threadLocal.set(object);
    }

    /**
     * 获取登入用户数据
     * @return
     */
    public static Object get(){
        Object obj = threadLocal.get();
        if (obj==null){
            threadLocal.set(new String("本地线程无数据"));
            System.out.println("本地线程无数据");
        }
        return obj;
    }

    /**
     * 清除登入用户数据
     */
    public static void remove(){
        threadLocal.remove();
    }
}
