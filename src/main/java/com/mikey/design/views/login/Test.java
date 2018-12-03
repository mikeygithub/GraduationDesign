package com.mikey.design.views.login;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/3 8:24
 * @Version 1.0
 */
import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

public class Test extends JFrame{

    private static final long serialVersionUID = 1L;

    public Test(){

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //设置顶部提示文字和主窗体的宽，高，x值，y值
        setTitle("登录窗体");
        setBounds(300, 200, 300, 150);
        Container cp=getContentPane();	//添加一个cp容器
        cp.setLayout(null);	//设置添加的cp容器为流布局管理器

        //设置左侧用户名文字
        JLabel jl=new JLabel("用户名：");
        jl.setBounds(10, 10, 200, 18);
        final JTextField name=new JTextField();	//用户名框
        name.setBounds(80, 10, 150, 18);	//设置用户名框的宽，高，x值，y值

        //设置左侧密码文字
        JLabel jl2=new JLabel("密码：");
        jl2.setBounds(10, 50, 200, 18);
        final JPasswordField password=new JPasswordField();	//密码框：为加密的***
        password.setBounds(80, 50, 150, 18);	//设置密码框的宽，高，x值，y值

        //将jl、name、jl2、password添加到容器cp中
        cp.add(jl);
        cp.add(name);
        cp.add(jl2);
        cp.add(password);

        //确定按钮
        JButton jb=new JButton("确定");	//添加一个确定按钮
        jb.addActionListener(new ActionListener(){		//为确定按钮添加监听事件

            public void actionPerformed(ActionEvent arg0) {

                if(name.getText().trim().length()==0||new String(password.getPassword()).trim().length()==0){
                    JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
                    return;
                }
                if(name.getText().trim().equals("lzp")&&new String(password.getPassword()).trim().equals("123456")){
                    JOptionPane.showMessageDialog(null, "登录成功");
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
            }
        });
        jb.setBounds(80, 80, 60, 18);	//设置确定按钮的宽，高，x值，y值
        cp.add(jb);	//将确定按钮添加到cp容器中

        //重置按钮
        final JButton button = new JButton();
        button.setText("重置");
        button.addActionListener(new ActionListener(){		//为重置按钮添加监听事件
            //同时清空name、password的数据
            public void actionPerformed(ActionEvent arg0) {
                // TODO 自动生成方法存根
                name.setText("");
                password.setText("");
            }
        });
        button.setBounds(150, 80, 60, 18);	//设置重置按钮的宽，高，x值，y值
        getContentPane().add(button);
    }

    //main方法入口
    public static void main(String[] args) {
        new Test();	//调用three()

    }

}