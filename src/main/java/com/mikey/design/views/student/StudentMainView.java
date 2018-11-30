package com.mikey.design.views.student;

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
public class StudentMainView extends JFrame {  //0.继承JFrame
    //1. 定义组件
    JButton jButton, jButton2,jButton3,jButton4,jButton5;

    public StudentMainView() {
        //2. 创建组件
        jButton = new JButton("中间");
        jButton2 = new JButton("北边");
        jButton3 = new JButton("西边");
        jButton4 = new JButton("东边");
        jButton5 = new JButton("南边");

        JPanel Menu=new JPanel();
        Menu.setLayout(new GridLayout(10,1,3,3));
        JButton jButton3_1 = new JButton("西边");
        JButton jButton4_1 = new JButton("东边");
        Menu.add(jButton3);
        Menu.add(jButton3_1);
        Menu.add(jButton4_1);
        Menu.setVisible(true);
        JPanel title=new JPanel();
        JPanel main=new JPanel();

        //3. 添加各个组件
        this.add(jButton, BorderLayout.CENTER);  //布局的中间
        this.add(jButton2, BorderLayout.NORTH);  //布局的北边
        this.add(Menu, BorderLayout.WEST);   //布局的西边
        this.add(jButton4, BorderLayout.EAST);   //布局的东边
        this.add(jButton5, BorderLayout.SOUTH);  //布局的南边

        //4. 设置窗体属性
        this.setTitle("演示边界布局管理器");
        this.setSize(500, 400);
        this.setLocation(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        StudentMainView testBorderLayout = new StudentMainView();

    }
}