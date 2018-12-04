package com.mikey.design.views.common;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title: 更新密码
 * @Description: 更新个人登入密码
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class UpPwdPanel extends JPanel {
    public UpPwdPanel() throws HeadlessException {

        //获取当前登入用户信息
//        Student student = (Student) ThreadLoaclUtil.get();
//        System.out.println("Login Student Message======>>>>>>>"+student.getStudentName());

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("修改登入密码");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.原登入密码
        JPanel oldPwdJpanel=new JPanel();
        JLabel oldPwdJlabel=new JLabel("原登入密码：");
        JTextField oldPwdTextField=new JTextField("请输入原登入密码");
        oldPwdJpanel.add(oldPwdJlabel);
        oldPwdJpanel.add(oldPwdTextField);

        //2.新登入密码
        JPanel newPwdJpanel=new JPanel();
        JLabel newPwdJlabel=new JLabel("新登入密码：");
        JTextField newPwdJtextField=new JTextField("请输入新登入密码");
        newPwdJpanel.add(newPwdJlabel);
        newPwdJpanel.add(newPwdJtextField);

        //3.重复新登入密码
        JPanel reNewPwdJpanel=new JPanel();
        JLabel reNewPwdJlabel=new JLabel("新登入密码：");
        JTextField reNewPwdJtextField=new JTextField("请再次输入新密码");
        reNewPwdJpanel.add(reNewPwdJlabel);
        reNewPwdJpanel.add(reNewPwdJtextField);



        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认更改");
        JButton reselt=new JButton("取消更改");
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(oldPwdJpanel);
        mainJpanel.add(newPwdJpanel);
        mainJpanel.add(reNewPwdJpanel);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
    }
}
