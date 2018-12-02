package com.mikey.design.views.admin;

import javax.swing.*;
import java.awt.*;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/30 19:37
 * @Version 1.0
 */
public class AdminMainView extends JFrame {  //0.继承JFrame
    //1. 定义组件
    JButton jButton, jButton2,jButton3,jButton4,jButton5;

    public AdminMainView() {
        //2. 创建组件
        jButton = new JButton("中间");
        jButton2 = new JButton("北边");
        jButton4 = new JButton("东边");
        jButton5 = new JButton("南边");

        JPanel Menu=new JPanel();
        Menu.setLayout(new GridLayout(10,1,3,3));
        jButton3 = new JButton("");
        JButton menuChild1 = new JButton("填报志愿");
        JButton menuChild2 = new JButton("浏览教师");
        JButton menuChild3 = new JButton("浏览题目");
        JButton menuChild4 = new JButton("修改信息");
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

        //3. 添加各个组件
        /*******************************************************************************/
        /**
         * 中间布局
         */
        JPanel center=new JPanel();
        center.setVisible(true);
        CardLayout cardLayout=new CardLayout(10,10);
        center.setLayout(cardLayout);
        center.setBackground(Color.red);

        JPanel wispPanel=new JPanel();
        JPanel teacherPanel=new JPanel();
        JPanel titlePanel=new JPanel();
        JPanel updatePanel=new JPanel();

        center.add(wispPanel);
        center.add(teacherPanel);
        center.add(titlePanel);
        center.add(updatePanel);

        this.add(center, BorderLayout.CENTER);  //布局的中间


        /****
         *
         */
        this.add(menuBar, BorderLayout.NORTH);  //布局的北边
        this.add(Menu, BorderLayout.WEST);   //布局的西边
//        this.add(jButton4, BorderLayout.EAST);   //布局的东边
//        this.add(jButton5, BorderLayout.SOUTH);  //布局的南边

        //4. 设置窗体属性
        this.setTitle("毕业设计选题系统");
        this.setSize(700, 500);
        this.setLocation(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        AdminMainView testBorderLayout = new AdminMainView();

    }
}