package com.mikey.design.views.login;

import com.mikey.design.listerner.common.LoginListener;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 8:22
 * @Version 1.0
 */
public class Login extends JFrame {

    public Login(){
        JPanel login=new JPanel();
        this.add(login, BorderLayout.CENTER);
        this.setBounds(600,300,700,500);
        this.setTitle("毕业设计选题系统");
        this.setLocationRelativeTo(null);
        /**
         * banner
         */
        JPanel titleJpanel=new JPanel();
        JLabel title=new JLabel("欢迎登陆毕业设计选题系统");
        title.setFont(new Font("华文彩云",Font.BOLD, 25));
        titleJpanel.add(title);
        /**
         * logo
         */
        //TODO:待修复打成jar包后logo路径生效
        Toolkit took = Toolkit.getDefaultToolkit(); //设置窗口图标 //要用绝对路径
        Image image = took.getImage("src/main/resources/Images/logo.png");

        setIconImage(image);


        login.setLayout(new GridLayout(7,1));//网格布局
        JLabel nameJlabel=new JLabel("学号/工号:");
        JTextField nameJtextField=new JTextField(20);
        nameJtextField.setSize(220,20);//设置大小
        JPanel userNameJpanel=new JPanel();
       nameJtextField.setText("请输入学号或者工号");
        userNameJpanel.add(nameJlabel);
        userNameJpanel.add(nameJtextField);



        JLabel pwdJlabel=new JLabel("密  码：");
        JPasswordField pwdJtextField=new JPasswordField(19);
        JPanel pwdJpanel=new JPanel();
        pwdJtextField.setText("请输入用密码");
        pwdJpanel.add(pwdJlabel);
        pwdJpanel.add(pwdJtextField);

        /**
         * 单选框
         */
        JPanel select=new JPanel();

        CheckboxGroup group=new CheckboxGroup();
        select.add(new Checkbox("student",group,true));
        select.add(new Checkbox("teacher",group,false));
        select.add(new Checkbox("admin",group,false));




        /**
         * btn
         */
        JButton loginbtn=new JButton("登入");
        loginbtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        loginbtn.addActionListener(new LoginListener(nameJtextField,pwdJtextField,group,this));
        JButton reset=new JButton("重置");
        reset.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        JPanel btn=new JPanel();
        btn.add(loginbtn);
        btn.add(reset);
        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameJtextField.setText("");
                pwdJtextField.setText("");
            }
        });


        login.add(new JPanel());
        login.add(titleJpanel);
        login.add(userNameJpanel);
        login.add(pwdJpanel);
        login.add(select);
        login.add(btn);

        setResizable(false);//禁用最大化
        this.setVisible(true);
    }
}
