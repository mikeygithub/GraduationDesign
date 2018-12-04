package com.mikey.design.views.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title: 更新密码
 * @Description: 更新个人登入密码
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:14
 * @Version 1.0
 */
public class AddTitlePanel extends JPanel {
    public AddTitlePanel() throws HeadlessException {

        //获取当前登入用户信息
//        Student student = (Student) ThreadLoaclUtil.get();
//        System.out.println("Login Student Message======>>>>>>>"+student.getStudentName());

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("添加毕业设计题目");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //添加毕业设计题目
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.毕业设计题目
        JPanel titleNameJpanel=new JPanel();
        JLabel titleNameJlabel=new JLabel("毕业设计题目：");
        JTextField titleNameTextField=new JTextField("请输入毕业设计题目");
        titleNameJpanel.add(titleNameJlabel);
        titleNameJpanel.add(titleNameTextField);

        //2.毕业设计人数
        JPanel titleNumJpanel=new JPanel();
        JLabel titleNumJlabel=new JLabel("毕业设计人数：");
        JTextField titleNumJtextField=new JTextField("请输入毕业设计人数");
        titleNumJpanel.add(titleNumJlabel);
        titleNumJpanel.add(titleNumJtextField);

        //3.毕业设计要求
        JPanel titleRequireJpanel=new JPanel();
        JLabel titleRequireJlabel=new JLabel("毕业设计要求：");
        JTextArea titleRequireJtextArea=new JTextArea("请输入毕业设计要求",5,15);
        titleRequireJpanel.add(titleRequireJlabel);
        titleRequireJpanel.add(titleRequireJtextArea);



        //提交按钮
        JPanel submits=new JPanel();
        JButton sunmit=new JButton("确认添加");
        JButton reselt=new JButton("点击重置");
        reselt.addActionListener(new AbstractAction() {//添加监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                titleNameTextField.setText("请输入毕业设计题目");
                titleNumJtextField.setText("请输入毕业设计人数");
                titleRequireJtextArea.setText("请输入毕业设计要求");
            }
        });
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(titleNameJpanel);
        mainJpanel.add(titleNumJpanel);
        mainJpanel.add(titleRequireJpanel);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
    }
}
