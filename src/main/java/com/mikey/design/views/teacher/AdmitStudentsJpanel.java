package com.mikey.design.views.teacher;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Design;
import com.mikey.design.entity.Student;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.listerner.teacher.AdmitStudentButtonListener;
import com.mikey.design.service.DesignService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.service.TitleOfStudentService;
import com.mikey.design.utils.MyTableCellRenderer;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocalUtil;
import com.mikey.design.views.renderer.AdmitStudentButtonRenderer;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

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
    //service接口
    private StudentService studentService;
    //service接口
    private TeacherService teacherService;
    //service接口
    private TitleOfStudentService titleOfStudentService;
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
    //当前登入教师
    private Teacher selfTeacher;
    //当前教师的毕设题目列表
    private List<Design>  designList;
    //填报当前教师的毕设题目学生列表
    private List<Student>  studentList;
    //当前教师的毕设题目列表
    private List<TitleOfStudent>  titleOfStudentList;

    public void getData(){
        designService = (DesignService) SpringUtil.getBean("designServiceImpl");
        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService=(TeacherService) SpringUtil.getBean("teacherServiceImpl");
        titleOfStudentService = (TitleOfStudentService) SpringUtil.getBean("titleOfStudentServiceImpl");

        pageData=teacherService.getWillAdmitStudentMes(selfTeacher.getTeacherId(),currentPage,pageSize);//通过教师id获取志愿填报情况

        System.out.println("Message="+pageData.getList());

        titleOfStudentList=pageData.getList();
        System.out.println("MESSAGE------->>>>>>>"+titleOfStudentList.size());

    }

    public AdmitStudentsJpanel() throws HeadlessException {

        //获取当前登入用户信息
        selfTeacher = (Teacher) ThreadLocalUtil.get();

        getData();
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

        //默认表格数据
        rowData[0][0]="暂无";rowData[0][1]="暂无";rowData[0][2]="暂无";rowData[0][3]="暂无";rowData[0][4]="暂无";rowData[0][5]="暂无";
        //表格
        JTable table=new AdmitStudentTable(rowData,columnNames);

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
