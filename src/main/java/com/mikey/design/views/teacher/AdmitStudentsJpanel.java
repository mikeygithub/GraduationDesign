package com.mikey.design.views.teacher;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Teacher;
import com.mikey.design.listerner.teacher.AdmitStudentButtonListener;
import com.mikey.design.service.DesignService;
import com.mikey.design.utils.MyTableCellRenderer;
import com.mikey.design.views.renderer.AdmitStudentButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * @author Mikey
 * @Title: 录取报名学生
 * @Description: 录取志愿填报了当前老师的学生
 * @Email:1625017540@qq.com
 * @date 2018/12/4 20:28
 * @Version 1.0
 */
public class AdmitStudentsJpanel  extends JPanel {

    //service接口
    private DesignService designService;
    //当前页
    private int currentPage=1;
    //每页显示条数
    private int pageSize=20;
    //表头（列名）
    private Object[] columnNames = {"姓名", "性别", "题目","志愿类型","联系方式", "操作"};
    //列表内容
    private Object[][] rowData=new Object[20][6];
    //分页
    private PageInfo pageData;

    private Teacher selfTeacher;


    public AdmitStudentsJpanel() throws HeadlessException {

        //获取当前登入用户信息
//        Student student = (Teacher) ThreadLoaclUtil.get();

        //边缘布局
        setLayout(new BorderLayout());
        //banner
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.LIGHT_GRAY);
        JLabel title=new JLabel("录取报名学生");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);

        //列表开始

        JPanel students=new JPanel(new BorderLayout());
        students.setBackground(Color.red);

        //表格所有行数据
        Object[][] rowData = {
                {"张三", 80, 80,  80,80, 24},
                {"John", 70, 80, 80, 90, 240},
                {"Sue", 70, 70, 70, 80, 210},
                {"Jane", 80, 70, 60, 80, 210},
                {"Joe_01", 80, 70, 60,80,210},
                {"Joe_02", 80, 70, 60,80,210},
                {"Joe_03", 80, 70, 60,80,210},
                {"Joe_04", 80, 70, 60,80,210},
                {"Joe_05", 80, 70, 60,80,210},
                {"张三", 80, 80, 80,  80,24},
                {"John", 70, 80, 90,  80,240},
                {"Sue", 70, 70, 70,  80,210},
                {"Jane", 80, 70, 60, 80, 210},
                {"Joe_01", 80, 70, 60, 80, 210},
                {"Joe_02", 80, 70, 60, 80, 210},
                {"Joe_03", 80, 70, 60, 80, 210},
                {"Joe_04", 80, 70, 60, 80, 210},
                {"Joe_05", 80, 70, 60, 80, 21066},
                {"Joe_04", 80, 70, 60,  80,210},
                {"Joe_05", 80, 70, 60,  80,21066}
        };
        //表格
        JTable table=new AdmitStudentTable(rowData,columnNames);

//        table.setEnabled(false);

        MyTableCellRenderer renderer=new MyTableCellRenderer();

        for (int i=0;i<columnNames.length;i++){
            TableColumn tableColumn=table.getColumn(columnNames[i]);
            tableColumn.setCellRenderer(renderer);
        }
        table.getColumnModel().getColumn(5).setCellEditor(
                new AdmitStudentButtonListener());

        table.getColumnModel().getColumn(5).setCellRenderer(
                new AdmitStudentButtonRenderer());

        students.add(table.getTableHeader(),BorderLayout.NORTH);
        students.add(table,BorderLayout.CENTER);

        add(students,BorderLayout.CENTER);
        //列表结束



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
        setVisible(true);
    }
}
