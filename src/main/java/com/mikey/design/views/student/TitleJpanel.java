package com.mikey.design.views.student;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Design;
import com.mikey.design.entity.Teacher;
import com.mikey.design.service.DesignService;
import com.mikey.design.service.TeacherService;
import com.mikey.design.views.renderer.MyTableCellRenderer;
import com.mikey.design.utils.SpringUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author Mikey
 * @Title:  浏览毕设题目
 * @Description: 学生浏览教师毕设题目
 * @Email:1625017540@qq.com
 * @date 2018/12/4 11:41
 * @Version 1.0
 */
public class TitleJpanel extends JPanel {
    //service接口
    private DesignService designService;
    //service接口
    private TeacherService teacherService;
    //当前页
    private int currentPage=1;
    //每页显示条数
    private int pageSize=12;
    //表头（列名）
    private Object[] columnNames = {"题目", "导师", "人数", "要求"};
    //列表内容
    private Object[][] rowData=new Object[20][4];
    //分页
    private PageInfo pageData;
    //教师列表
    private List<Teacher> teacherList;

    public void getData(){
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        designService = (DesignService) SpringUtil.getBean("designServiceImpl");
        //获取全部教师信息
        teacherList=teacherService.getAllTeacher();
        //进行分页、每页显示20行信息
        pageData = designService.getDesignByPage(currentPage,pageSize);

        rowData[0][0]="暂无";rowData[0][1]="暂无";rowData[0][2]="暂无";rowData[0][3]="暂无";


        List<Design> designList=pageData.getList();//获取数据

        clearData(rowData);//清除数据

        if (designList.size()>0){
            int i=0;
            for(Design d:designList){//赋值
                rowData[i][0]=d.getDesignTitle();
                for (Teacher t:teacherList){
                    if (t.getTeacherId()==d.getDesignOfTeacher()){
                        rowData[i][1]=t.getTeacherName();
                    }
                }
                rowData[i][2]=d.getDesignNum();
                rowData[i][3]=d.getDesignRequire();
                i++;
            }
        }

    }

    private void clearData(Object[][] rowData) {
        for (int i=0;i<rowData.length;i++){
            for(int j=0;j<4;j++){
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
        JLabel title=new JLabel("毕业设计题目信息列表");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);
        /**
         * 毕业设计题目列表
         */
        JPanel teach=new JPanel(new BorderLayout());

        teach.setBackground(Color.red);

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


        teach.add(table.getTableHeader(),BorderLayout.NORTH);
        teach.add(table,BorderLayout.CENTER);

        add(teach,BorderLayout.CENTER);


        //分页按钮
        JButton firstPage=new JButton("首页");
        JButton upPage=new JButton("上一页");
        JButton nextPage=new JButton("下一页");
        JButton endPage=new JButton("末页");
        //提示框显示位置
        JPanel showTipMessageLocationJpanel=this;

        /**
         * 监听首页
         */
        firstPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage==1||pageData.getPageNum()==1){
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已经到达首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage=1;//设置为第一页
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
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已到首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage--;//设置为上一页
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
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已到末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已到末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }else {
                    currentPage=pageData.getPages();//设置为末页
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
