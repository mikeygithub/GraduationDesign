package com.mikey.design.views.teacher;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Teacher;
import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.listerner.teacher.AdmitStudentButtonListener;
import com.mikey.design.service.DesignService;
import com.mikey.design.service.StudentService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.service.TitleOfStudentService;
import com.mikey.design.views.renderer.MyTableCellRenderer;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.utils.ThreadLocalUtil;
import com.mikey.design.views.renderer.AdmitStudentButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
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
    private int pageSize=12;
    //表头（列名）
    private Object[] columnNames = {"姓名", "性别", "题目","志愿类型","联系方式", "操作"};
    //列表内容
    private Object[][] rowData;//=new Object[20][6];
    //分页
    private PageInfo pageData;
    //当前登入教师
    private Teacher selfTeacher;
    //当前教师的毕设题目列表
    private List<TitleOfStudent>  titleOfStudentList;
    //
    private JTable table;
    //
    private JPanel students;
    //
    DefaultTableModel tableModel;
    //
    public int flag=0;

    public void getData(){

        pageData=teacherService.getWillAdmitStudentMes(selfTeacher.getTeacherId(),currentPage,pageSize);//通过教师id获取志愿填报情况

        titleOfStudentList=pageData.getList();

        AdmitStudentButtonListener.setTitleOfStudentList(titleOfStudentList);//同步到监听器

        System.out.println("MESSAGE------->>>>>>>当前页：总数="+titleOfStudentList.size());

        rowData=new Object[pageData.getSize()==0?1:pageData.getSize()][6];

        clearRowData(rowData);//清空数据表格
        /**
         * 将数据填充到表格等待渲染
         */
        if (titleOfStudentList.size()>0){
            int i=0;
            for (TitleOfStudent t:titleOfStudentList){
                rowData[i][0]=t.getStudent().getStudentName();
                rowData[i][1]=t.getStudent().getStudentSex()==0?'女':'男';
                rowData[i][2]=t.getDesign().getDesignTitle();
                rowData[i][3]=t.getDesWishOrder()==0?"第一志愿":"第二志愿";
                rowData[i][4]=t.getStudent().getStudentPhone();
                i++;
            }
        }

    }

    public  void showView() throws HeadlessException {

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
        students=new JPanel(new BorderLayout());

        //默认表格数据
        if (titleOfStudentList.size()<1){
            rowData[0][0]="暂无";rowData[0][1]="暂无";rowData[0][2]="暂无";rowData[0][3]="暂无";rowData[0][4]="暂无";rowData[0][5]="暂无";
        }
        //数据表格

//        tableModel=new DefaultTableModel(rowData,columnNames);
        //表格
        table=new AdmitStudentTable(rowData,columnNames);

//        table=new AdmitStudentTable(tableModel);

        MyTableCellRenderer renderer=new MyTableCellRenderer();

        for (int i=0;i<columnNames.length;i++){
            TableColumn tableColumn=table.getColumn(columnNames[i]);
            tableColumn.setCellRenderer(renderer);
        }
            table.getColumnModel().getColumn(5).setCellEditor(
                    new AdmitStudentButtonListener(table,this));

            table.getColumnModel().getColumn(5).setCellRenderer(
                    new AdmitStudentButtonRenderer());

        students.add(table.getTableHeader(),BorderLayout.NORTH);
        students.add(table,BorderLayout.CENTER);

        add(students,BorderLayout.CENTER);

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

        if (flag==0) {

            JPanel showTipMessageLocationJpanel = this;
            /**
             * 监听首页
             */
            firstPage.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentPage == 1 || pageData.getPageNum() == 1) {
                        JOptionPane.showMessageDialog(showTipMessageLocationJpanel, "已到首页", "系统提示", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        currentPage = 1;//设置为第一页
                        table.removeAll();
                        students.removeAll();
                        refreshData();//刷新数据
                    }
                }
            });
            /**
             * 监听上一页
             */
            upPage.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("当前页=" + pageData.getPageNum() + "共" + pageData.getPages() + "data=" + rowData);
                    if (currentPage == 1 || pageData.getPageNum() == 1) {
                        JOptionPane.showMessageDialog(showTipMessageLocationJpanel, "已到达首页", "系统提示", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        currentPage--;//设置为上一页
                        table.removeAll();
                        students.removeAll();
                        refreshData();//刷新数据
                    }
                }
            });
            /**
             * 监听下页
             */
            nextPage.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (pageData.getPageNum() == pageData.getPages()) {
                        JOptionPane.showMessageDialog(showTipMessageLocationJpanel, "已到达末页", "系统提示", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        currentPage++;//设置为下一页
                        table.removeAll();
                        students.removeAll();
                        refreshData();//刷新数据
                    }
                }
            });

            /**
             * 监听末页
             */
            endPage.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pageData.getPageNum() == pageData.getPages()) {
                        JOptionPane.showMessageDialog(showTipMessageLocationJpanel, "已到达末页", "系统提示", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    } else {
                        currentPage = pageData.getPages();//设置为末页
                        table.removeAll();
                        students.removeAll();
                        refreshData();//刷新数据
                    }
                }
            });
        }

    }

    public AdmitStudentsJpanel() {
        //获取当前登入用户信息
        selfTeacher = (Teacher) ThreadLocalUtil.get();
        designService = (DesignService) SpringUtil.getBean("designServiceImpl");
        studentService = (StudentService) SpringUtil.getBean("studentServiceImpl");
        teacherService=(TeacherService) SpringUtil.getBean("teacherServiceImpl");
        titleOfStudentService = (TitleOfStudentService) SpringUtil.getBean("titleOfStudentServiceImpl");
    }

    /**
     * 清空数据表格
     * @param rowData
     */
    public void clearRowData(Object[][] rowData){
        for (int i=0;i<rowData.length;i++){
            for (int j=0;j<rowData[i].length;j++){
                rowData[i][j]="";
            }
        }
    }

    /**
     * 刷新面板数据
     */
    public void refreshData(){
        getData();//获取数据
        showView();//展现视图
        table.validate();
//        tableModel.fireTableDataChanged();
        students.updateUI();
    }
}
