package com.mikey.design.views.admin;

import com.mikey.design.listerner.common.LoginOut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title: 管理员页面
 * @Description: 管理员操作面板
 * @Email:1625017540@qq.com
 * @date 2018/11/30 19:37
 * @Version 1.0
 */
public class AdminMainView extends JFrame {


    public AdminMainView() throws HeadlessException {
    }

    public AdminMainView(JFrame login) {
        //创建组件
        JPanel Menu=new JPanel();
        Menu.setLayout(new GridLayout(10,1,3,3));
        JButton menuChild1 = new JButton("浏览教师信息");
        JButton menuChild2 = new JButton("浏览学生信息");
        JButton menuChild3 = new JButton("志愿填报情况");
        JButton menuChild4 = new JButton("统计志愿填报");
        JButton menuChild5 = new JButton("添加教师信息");
        JButton menuChild6 = new JButton("添加学生信息");
        JButton menuChild7 = new JButton("退出登入");
        Menu.add(menuChild1);
        Menu.add(menuChild2);
        Menu.add(menuChild3);
        Menu.add(menuChild4);
        Menu.add(menuChild5);
        Menu.add(menuChild6);
        Menu.add(menuChild7);

        Menu.setVisible(true);
        /**
         * 菜单栏
         */
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        JMenu editMenu = new JMenu("编辑");
        JMenu viewMenu = new JMenu("视图");
        JMenu aboutMenu = new JMenu("关于");
        // 一级菜单添加到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);

        //添加各个组件
        JPanel center=new JPanel();
        center.setVisible(true);
        CardLayout cardLayout=new CardLayout(10,10);
        center.setLayout(cardLayout);

        JPanel lookTeacherJpanel=new LookTeacherJpanel();//浏览教师信息
        JPanel lookStudentPanel=new LookStudentJpanel();//浏览学生信息
        JPanel wishStatePanel=new JPanel();//志愿填报情况
        JPanel countWishPanel=new JPanel();//统计志愿填报、填报人数、未填报人数
        JPanel addStudentJpanel=new AddStudentJpanel();//课设题目
        JPanel addTeacherJpanel=new AddTeacherJpanel();//更新个人信息

        menuChild1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"lookTeacherJpanel");
            }
        });
        menuChild2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"lookStudentPanel");
            }
        });
        menuChild3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"wishStatePanel");
            }
        });
        menuChild4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"countWishPanel");
            }
        });
        menuChild5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"addStudentJpanel");
            }
        });
        menuChild6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"addTeacherJpanel");
            }
        });
        menuChild7.addActionListener(new LoginOut(login,this));

        center.add(lookTeacherJpanel,"lookTeacherJpanel");
        center.add(lookStudentPanel,"lookStudentPanel");
        center.add(wishStatePanel,"wishStatePanel");
        center.add(countWishPanel,"countWishPanel");
        center.add(addStudentJpanel,"addStudentJpanel");
        center.add(addTeacherJpanel,"addTeacherJpanel");

        this.add(center, BorderLayout.CENTER);  //中间
        this.add(menuBar, BorderLayout.NORTH);  //北边
        this.add(Menu, BorderLayout.WEST);   //西边

        //设置窗体属性
        this.setTitle("毕业设计选题系统");
        this.setSize(700, 500);
        this.setLocation(600, 300);
        this.setVisible(true);
        setResizable(false);//禁用最大化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        AdminMainView testBorderLayout = new AdminMainView(null);

    }
}