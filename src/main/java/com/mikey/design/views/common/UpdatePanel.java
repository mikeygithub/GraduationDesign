package com.mikey.design.views.common;

import com.mikey.design.entity.Student;
import com.mikey.design.utils.ThreadLoaclUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title: 更新个人信息
 * @Description: 更新个人信息面板
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class UpdatePanel extends JPanel {
    public UpdatePanel() throws HeadlessException {

        //获取当前登入用户信息
//        Student student = (Student) ThreadLoaclUtil.get();
//        System.out.println("Login Student Message======>>>>>>>"+student.getStudentName());

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("修改个人信息");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.名字
        JPanel username=new JPanel();
        JLabel nameJlabel=new JLabel("用户名：");
        JTextField nameJtextField=new JTextField("请输入学号或者工号");
        username.add(nameJlabel);
        username.add(nameJtextField);
        //2.性别
        JPanel sex=new JPanel();
        JLabel sexJlabel=new JLabel("性别：");
        JComboBox teacherboBox=new JComboBox();//下拉框
        teacherboBox.addItem("男");
        teacherboBox.addItem("女");
        sex.add(sexJlabel);
        sex.add(teacherboBox);

        //3.联系电话
        JPanel phone=new JPanel();
        JLabel phoneJlabel=new JLabel("联系方式：");
        JTextField phoneJtextField=new JTextField("请输入电话号码或邮箱");
        phone.add(phoneJlabel);
        phone.add(phoneJtextField);


        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认更改");
        JButton reselt=new JButton("取消更改");
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(username);
        mainJpanel.add(sex);
        mainJpanel.add(phone);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
    }
}
