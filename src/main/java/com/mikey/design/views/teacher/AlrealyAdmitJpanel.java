package com.mikey.design.views.teacher;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.service.TeacherService;
import com.mikey.design.utils.MyTableCellRenderer;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocalUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author Mikey
 * @Title:  已录取学生列表
 * @Description: 已录取学生列表面板
 * @Email:1625017540@qq.com
 * @date 2018/12/4 20:40
 * @Version 1.0
 */
public class AlrealyAdmitJpanel extends JPanel {
    //service接口
    private TeacherService teacherService;
    //当前页
    private int currentPage=1;
    //每页显示条数
    private int pageSize=20;
    //表头（列名）TODO:待添加剩余人数
    private Object[] columnNames = {"姓名", "性别", "题目", "联系方式"};
    //列表内容
    private Object[][] rowData=new Object[20][4];
    //分页
    private PageInfo pageData;

    private Teacher selfTeacher;

    public void getData(){

        selfTeacher= (Teacher) ThreadLocalUtil.get();//获取当前登入的教师信息

        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");

        //进行分页、每页显示20行信息
        pageData = teacherService.getAllAlreayAdmitStudent(selfTeacher.getTeacherId(),currentPage,pageSize);

        rowData[0][0]="暂无";rowData[0][1]="暂无";rowData[0][2]="暂无";rowData[0][3]="暂无";


        List<TitleOfStudent> designList=pageData.getList();//获取数据

        clearData(rowData);//清除数据

        if (designList.size()>0){
            int i=0;
            for(TitleOfStudent t:designList){//赋值
                rowData[i][0]=t.getStudent().getStudentName();
                rowData[i][1]=t.getStudent().getStudentSex()==0?'女':'男';
                rowData[i][2]=t.getDesign().getDesignTitle();
                rowData[i][3]=t.getStudent().getStudentPhone();
                i++;
            }
        }

    }

    private void clearData(Object[][] rowData) {
        for (int i=0;i<rowData.length;i++){
            for(int j=0;j<columnNames.length;j++){
                rowData[i][j]="";
            }
        }
    }

    public void showView() {
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        /**
         * banner
         */
        JPanel titleJpanel=new JPanel();
        titleJpanel.setBackground(Color.GRAY);
        JLabel title=new JLabel("已录取学生信息列表");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);
        /**
         * 毕业设计题目列表
         */
        JPanel student=new JPanel(new BorderLayout());

        student.setBackground(Color.red);

        //表格
        JTable table=new JTable(rowData,columnNames);

        table.setEnabled(false);//设置表格不可编辑

        MyTableCellRenderer renderer=new MyTableCellRenderer();//进行渲染

        if (rowData.length>0){//判断是否有值

            for (int i=0;i<columnNames.length;i++){
                TableColumn tableColumn=table.getColumn(columnNames[i]);
                tableColumn.setCellRenderer(renderer);
            }
        }


        student.add(table.getTableHeader(),BorderLayout.NORTH);
        student.add(table,BorderLayout.CENTER);

        add(student,BorderLayout.CENTER);


        //分页按钮
        JButton firstPage=new JButton("首页");
        JButton upPage=new JButton("上一页");
        JButton nextPage=new JButton("下一页");
        JButton endPage=new JButton("末页");

        /**
         * 监听首页
         */
        firstPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage==1||pageData.getPageNum()==1){
                    JOptionPane.showMessageDialog(null,"已到达首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else
                    {
                    currentPage=1;//第一页
                    getData();//刷新数据
                    table.validate();
                    table.updateUI();
                }
            }
        });
        /**
         * 监听上一页
         */
        upPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (currentPage==1||pageData.getPageNum()==1){
                    JOptionPane.showMessageDialog(null,"已到首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage--;//设置上一页
                    getData();
                    table.validate();
                    table.updateUI();
                }
            }
        });
        /**
         * 监听下页
         */
        nextPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pageData.getPageNum()==pageData.getPages()){
                    JOptionPane.showMessageDialog(null,"已到末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage++;//设置为下一页
                    getData();
                    table.validate();
                    table.updateUI();
                }
            }
        });
        /**
         * 监听末页
         */
        endPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pageData.getPageNum()==pageData.getPages()){
                    JOptionPane.showMessageDialog(null,"已到末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage=pageData.getPages();//末页
                    getData();
                    //更新表格
                    table.validate();
                    table.updateUI();
                }
            }
        });
        JPanel page=new JPanel();
        page.add(firstPage);
        page.add(upPage);
        page.add(nextPage);
        page.add(endPage);
        add(page,BorderLayout.SOUTH);
    }

    /**
     * 刷新面板数据
     */
    public void refreshData(){
        getData();//获取数据
        showView();//展现视图
    }
}
