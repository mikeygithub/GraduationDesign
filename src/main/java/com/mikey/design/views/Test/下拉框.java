package com.mikey.design.views.Test;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 12:25
 * @Version 1.0
 */
        import java.awt.FlowLayout;

        import javax.swing.JComboBox;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;
        import javax.swing.border.EmptyBorder;

public class 下拉框 extends JFrame{
    public 下拉框(){
        this.setTitle("下拉列表框使用");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,250,100);
        JPanel contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        this.setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        JLabel label=new JLabel("证件类型:");
        contentPane.add(label);
        JComboBox comboBox=new JComboBox();
        comboBox.addItem("身份证");
        comboBox.addItem("驾驶证");
        comboBox.addItem("军官证");
        contentPane.add(comboBox);
        this.setVisible(true);
    }
    public static void main(String[]args){
        下拉框 example=new 下拉框();
    }
}