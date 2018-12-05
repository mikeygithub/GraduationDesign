package com.mikey.design.views.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 23:32
 * @Version 1.0
 */
public class AddStudentJpanel extends JPanel {
    public AddStudentJpanel() {
        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("添加学生信息");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //更改个人信息
        JPanel mainJpanel=new JPanel();
        mainJpanel.setLayout(new GridLayout(6,1));
        //1.名字
        JPanel username=new JPanel();
        JLabel nameJlabel=new JLabel("学生性名：");
        JTextField nameJtextField=new JTextField("请输入学生性名");
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
        JButton sunmit=new JButton("确认添加");
        sunmit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //添加学生
                JOptionPane.showMessageDialog(null, "添加成功/学号为：10005154");
            }
        });
        JButton reselt=new JButton("重置输入");
        reselt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameJtextField.setText("请输入学生性名");
                phoneJtextField.setText("请输入电话号码或邮箱");
            }
        });
        submits.add(sunmit);
        submits.add(reselt);


        mainJpanel.add(username);
        mainJpanel.add(sex);
        mainJpanel.add(phone);
        mainJpanel.add(submits);
        add(mainJpanel,BorderLayout.CENTER);
    }
}
