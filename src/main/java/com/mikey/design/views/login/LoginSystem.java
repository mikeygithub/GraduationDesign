package com.mikey.design.views.login;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 8:19
 * @Version 1.0
 */
public class LoginSystem {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("系统登录界面");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setSize(400,400);
        f.setLocation(200,200);
        Container con=f.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));

        JPanel pan1=new JPanel();//生成一个新的版面
        JLabel title=new JLabel("欢迎登陆本系统");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);
//最上面的登陆文字
        JPanel pan2=new JPanel();//生成一个新的版面
        JLabel name=new JLabel("用户名");
        pan2.add(name);
        TextField tf_name=new TextField(20);
        tf_name.setText("请在此处输入用户名");
        pan2.add(tf_name);
        con.add(pan2);
//用户名及其文本框放置在第二个版面上
        JPanel pan3=new JPanel();//生成一个新的版面
        JLabel pass = new JLabel("密码");
        pan3.add(pass);
        JPasswordField password=new JPasswordField(15);
        password.setEchoChar('*');
        pan3.add(password);
        con.add(pan3);
//密码及其密码域放在第三个版面上
        JPanel pan4 = new JPanel();
        JButton b_log=new JButton("登陆");
        pan4.add(b_log);
        JButton b_exit=new JButton("退出");
        pan4.add(b_exit);
        con.add(pan4);
//登陆和退出这两个按钮放在第四个版面上
        JPanel pan5 = new JPanel();
        con.add(pan5);
        JPanel pan6 = new JPanel();
        con.add(pan6);
        JPanel pan7 = new JPanel();
        con.add(pan7);
        f.setVisible(true);
//空白版面
    }

}
