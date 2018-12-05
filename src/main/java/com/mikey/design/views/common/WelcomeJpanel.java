package com.mikey.design.views.common;

import com.mikey.design.utils.ThreadLoaclUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title:  欢迎页面
 * @Description: 显示登入用户名信息、登入成功后默认页面
 * @Email:1625017540@qq.com
 * @date 2018/12/4 23:38
 * @Version 1.0
 */
public class WelcomeJpanel extends JPanel {

    public WelcomeJpanel() {

        //获取当前登入用户信息
//        Student student = (Student) ThreadLoaclUtil.get();
//        System.out.println("Login Student Message======>>>>>>>"+student.getStudentName());


        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("欢迎登入毕业设计选题系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();

        JPanel userMessageJpanel=new JPanel();
//        JLabel usernameJtable=new JLabel("欢迎用户："+student.getStudentName());
        JLabel usernameJlable=new JLabel("欢迎用户：");
        userMessageJpanel.add(usernameJlable);
        mainJpanel.add(userMessageJpanel);


        add(mainJpanel,BorderLayout.CENTER);
    }
}
