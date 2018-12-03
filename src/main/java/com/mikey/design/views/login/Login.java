package com.mikey.design.views.login;

import com.mikey.design.listerner.LoginListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 8:22
 * @Version 1.0
 */
@Component
public class Login extends JFrame {

    public void shows(){
        JPanel login=new JPanel();
        this.add(login, BorderLayout.CENTER);
        this.setBounds(500,500,700,500);
        this.setTitle("毕业设计选题系统");
        this.setLocationRelativeTo(null);
        /**
         * banner
         */
        JPanel titleJpanel=new JPanel();//生成一个新的版面
        JLabel title=new JLabel("欢迎登陆毕业设计选题系统");
        title.setFont(new Font("华文彩云",Font.BOLD, 20));
        titleJpanel.add(title);


        login.setLayout(new GridLayout(7,1));//网格布局
        JLabel nameJlabel=new JLabel("用户名：");
//        nameJlabel.setBounds(10,10,300,18);
        JTextField nameJtextField=new JTextField("请输入学号或者工号");
//        nameJtextField.setBounds(310, 10, 300, 18);
        JPanel userNameJpanel=new JPanel();
        userNameJpanel.add(nameJlabel);
        userNameJpanel.add(nameJtextField);



        JLabel pwdJlabel=new JLabel("密  码：");
//        pwdJlabel.setBounds(10, 50, 300, 18);
        JPasswordField pwdJtextField=new JPasswordField("请输入用密码");
//        pwdJtextField.setBounds(250, 50, 350, 18);
        JPanel pwdJpanel=new JPanel();
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
        loginbtn.addActionListener(new LoginListener(nameJtextField,pwdJtextField,group));
        JButton reset=new JButton("重置");
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
