package com.mikey.design.views.admin;

import com.mikey.design.listerner.common.LoginOut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title:
 * @Description:
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
        JButton menuChild5 = new JButton("退出登入");
        Menu.add(menuChild1);
        Menu.add(menuChild2);
        Menu.add(menuChild3);
        Menu.add(menuChild4);
        Menu.add(menuChild5);

        Menu.setVisible(true);
        JPanel title=new JPanel();
        JPanel main=new JPanel();
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
        /*******************************************************************************/
        /**
         * 中间布局
         */
        JPanel center=new JPanel();
        center.setVisible(true);
        CardLayout cardLayout=new CardLayout(10,10);
        center.setLayout(cardLayout);

        JPanel wispPanel=new JPanel();//志愿
        wispPanel.setBackground(Color.yellow);
        JPanel teacherPanel=new JPanel();//教师
        teacherPanel.setBackground(Color.blue);
        JPanel titlePanel=new JPanel();//课设题目
        titlePanel.setBackground(Color.red);
        JPanel updatePanel=new JPanel();//更新个人信息
        updatePanel.setBackground(Color.black);

        menuChild1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"wispPanel");
                System.out.println("wispPanel");
            }
        });
        menuChild2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"teacherPanel");
                System.out.println("teacherPanel");
            }
        });
        menuChild3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"titlePanel");
                System.out.println("titlePanel");
            }
        });
        menuChild4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(center,"updatePanel");
                System.out.println("updatePanel");
            }
        });
        menuChild5.addActionListener(new LoginOut(login,this));

        center.add(wispPanel,"wispPanel");
        center.add(teacherPanel,"teacherPanel");
        center.add(titlePanel,"titlePanel");
        center.add(updatePanel,"updatePanel");

        this.add(center, BorderLayout.CENTER);  //布局的中间


        /****
         *
         */
        this.add(menuBar, BorderLayout.NORTH);  //布局的北边
        this.add(Menu, BorderLayout.WEST);   //布局的西边
//        this.add(jButton4, BorderLayout.EAST);   //布局的东边
//        this.add(jButton5, BorderLayout.SOUTH);  //布局的南边

        //设置窗体属性
        this.setTitle("毕业设计选题系统");
        this.setSize(700, 500);
        this.setLocation(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        AdminMainView testBorderLayout = new AdminMainView(null);

    }
}