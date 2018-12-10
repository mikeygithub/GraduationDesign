package com.mikey.design.views.common;

import com.mikey.design.entity.Admin;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.utils.ThreadLocalUtil;

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
    //登入用户
    public String LOGINUSERNAME="";

    public WelcomeJpanel() {

        //获取当前登入用户信息
        Object loginUser = ThreadLocalUtil.get();

        //判断角色类型
        if(loginUser instanceof Student){//学生
            LOGINUSERNAME=((Student) loginUser).getStudentName();
        }else if (loginUser instanceof Teacher){//教师
            LOGINUSERNAME=((Teacher) loginUser).getTeacherName();
        }else if (loginUser instanceof Admin){//管理员
            LOGINUSERNAME=((Admin) loginUser).getAdminName();
        }

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
//        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("欢迎登入毕业设计选题系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //个人信息
        JPanel mainJpanel=new JPanel();

        JPanel userMessageJpanel=new JPanel();
        JLabel usernameJlable=new JLabel("欢迎用户："+LOGINUSERNAME);
        userMessageJpanel.add(usernameJlable);
        mainJpanel.add(userMessageJpanel);


        add(mainJpanel,BorderLayout.CENTER);
    }
}
