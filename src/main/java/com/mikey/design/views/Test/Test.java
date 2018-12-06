package com.mikey.design.views.Test;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/6 22:52
 * @Version 1.0
 */

import javax.swing.*;
        import java.awt.event.*;
        import java.awt.*;
        import javax.swing.table.*;

public class Test extends JFrame implements ActionListener
{

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private DefaultTableModel model;
    private JTable table;
    private JProgressBar bar;
    private JScrollPane scrollpane;
    private JPanel panel;

    public Test()
    {
        button1=new JButton("演示1");
        button2=new JButton("演示2");
        button3=new JButton("清空");
        panel=new JPanel();
        bar=new JProgressBar(0,100);
        String[] colnames={"1","2","3","4","5","6"};
        model=new DefaultTableModel(colnames,100);
        table=new JTable(model);
        scrollpane=new JScrollPane(table);
        panel.setLayout(new FlowLayout());
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(bar);
        this.setLayout(new GridLayout(2,1));
        this.setSize(500,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(scrollpane);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent e)
    {
        String command=e.getActionCommand();
        if(command.equals("演示1"))
        {
            ShowModel show=new ShowModel(true);
            Thread thread=new Thread(show);
            thread.start();
        }
        else if(command.equals("演示2"))
        {
            ShowModel show=new ShowModel(false);
            Thread thread=new Thread(show);
            thread.start();
        }
        else
        {
            String[] colnames={"1","2","3","4","5","6"};
            model=new DefaultTableModel(colnames,100);
            table.setModel(model);
        }
    }

    private class ShowModel implements Runnable
    {

        private boolean type;//当type为true时，则说明是“演示1”的线程，false则相反

        public ShowModel(boolean type)
        {
            this.type=type;
        }

        public void run()
        {

            if(type)//这个就是让线程睡眠，并且设置JTable的值
            {
                try{

                    for(int i=0;i<100;i++)
                    {
                        Test.this.table.setValueAt(String.valueOf(i),i,0);
                        Test.this.table.setValueAt(String.valueOf(i),i,1);
                        Thread.sleep(100);
                    }

                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else//这个就是进度条的演示
            {
                try{
                    Test.this.table.setVisible(false);
                    for(int i=0;i<100;i++)
                    {
                        Test.this.table.setValueAt(String.valueOf(i),i,0);
                        Test.this.table.setValueAt(String.valueOf(i),i,1);
                        Test.this.bar.setValue(i+1);
                        Test.this.bar.setString(String.valueOf(i+1)+"%");
                        Thread.sleep(40);
                        if(i==99)
                        {
                            Test.this.table.setVisible(true);
                            JOptionPane.showMessageDialog(Test.this,"OK");
                            Test.this.bar.setValue(0);
                        }

                    }

                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Test test=new Test();
        test.setVisible(true);
    }

}