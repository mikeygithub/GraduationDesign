package com.mikey.design.views.admin;

import com.mikey.design.utils.MyTableCellRenderer;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * @author Mikey
 * @Title: 学生填报志愿情况
 * @Description:  查看哪些学生是否已经填报志愿
 * @Email:1625017540@qq.com
 * @date 2018/12/4 23:30
 * @Version 1.0
 */
public class StudentWishStateJpanel extends JPanel {
    public StudentWishStateJpanel() {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        /**
         * banner
         */
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.GRAY);
        JLabel title=new JLabel("学生填报志愿信息列表");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);
        /**
         * 教师列表
         */
        JPanel teach=new JPanel(new BorderLayout());
        teach.setBackground(Color.red);
        //表头（列名）
        Object[] columnNames = {"姓名", "性别", "联系方式","是否已填报志愿"};
        //表格所有行数据
        Object[][] rowData = {
                {"Joe_01", 80, 70,"否"},
                {"张三", 80, 80 ,"是"},
                {"John", 70, 80,"是"},
                {"Sue", 70, 70,"是"},
                {"Joe_03", 80, 70,"否"},
                {"Jane", 80, 70,"是"},
                {"Joe_02", 80, 70,"否"},
                {"Joe_01", 80, 70,"是"},
                {"Joe_02", 80, 70,"是"},
                {"Joe_05", 80, 21066,"否"},
                {"Joe_03", 80, 70,"是"},
                {"Joe_04", 80, 70,"是"},
                {"Joe_04", 80, 70,"否"},
                {"Joe_05", 80, 70,"是"},
                {"张三", 80, 80,"是"},
                {"John", 70, 80,"是"},
                {"Sue", 70, 70,"是"},
                {"Jane", 80, 70,"是"},
                {"Joe_05", 80, 21066,"否"},
                {"Joe_04", 80,210,"否"},
        };
        //表格
        JTable table=new JTable(rowData,columnNames);

        table.setEnabled(false);

        MyTableCellRenderer renderer=new MyTableCellRenderer();

        for (int i=0;i<columnNames.length;i++){
            TableColumn tableColumn=table.getColumn(columnNames[i]);
            tableColumn.setCellRenderer(renderer);
        }

        teach.add(table.getTableHeader(),BorderLayout.NORTH);
        teach.add(table,BorderLayout.CENTER);

        add(teach,BorderLayout.CENTER);


        //分页按钮
        JButton firstPage=new JButton("首页");
        JButton upPage=new JButton("上一页");
        JButton nextPage=new JButton("下一页");
        JButton endPage=new JButton("末页");

        JPanel page=new JPanel();
        page.add(firstPage);
        page.add(upPage);
        page.add(nextPage);
        page.add(endPage);
        add(page,BorderLayout.SOUTH);


//         public void actionPerformed(ActionEvent e) {
//         				if(e.getActionCommand().equals("首页")){
//         					showTable(1);
//                                        }
//
//         	            if(e.getActionCommand().equals("上一页")){
//         	            	if(getCurrentPage()<=1){
//         	            		setCurrentPage(2);
//                            }
//         	            	showTable(getCurrentPage()-1);
//                        }
//
//         	            if(e.getActionCommand().equals("下一页")){
//         	            	if(getCurrentPage()<getLastPage()){
//         	            		showTable(getCurrentPage()+1);
//                            }else{
//         	            		showTable(getLastPage());
//                            }
//                        }
//
//         	            if(e.getActionCommand().equals("末页")){
//         	            	showTable(getLastPage());
//                        }			}
//         		}
    }
}
