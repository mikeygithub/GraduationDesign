package com.mikey.design.controller;

import com.mikey.design.views.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 7:38
 * @Version 1.0
 */
@Component
public class StudentController {
    @Autowired
    private Login login;
    public static void showLoginView(){
//        login.shows();
    }
}
