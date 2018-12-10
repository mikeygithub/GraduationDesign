package com.mikey.design.views.admin;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.TitleOfStudent;
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
 * @Title: 学生填报志愿情况
 * @Description:  查看哪些学生是否已经填报志愿
 * @Email:1625017540@qq.com
 * @date 2018/12/4 23:30
 * @Version 1.0
 */
public class StudentWishStateJpanel extends JPanel {
    //service接口
    private TeacherService teacherService;
    //当前页
    private int currentPage=1;
    //每页显示条数
    private int pageSize=12;
    //表头（列名）
    private Object[] columnNames = {"姓名", "性别", "联系方式","是否已填报志愿"};
    //列表内容
    private Object[][] rowData=new Object[20][4];
    //分页
    private PageInfo pageData;

    public void getData(){
        teacherService = (TeacherService) SpringUtil.getBean("teacherServiceImpl");
        //进行分页、每页显示20行信息
        pageData = teacherService.getAllStudentWishStateForAdmin(currentPage,pageSize);

        List<TitleOfStudent> titleOfStudentList=pageData.getList();//获取数据

        if (titleOfStudentList.size()<1){
            rowData[0][0]="暂无";rowData[0][1]="暂无";rowData[0][2]="暂无";;rowData[0][3]="暂无";
        }


        clearData(rowData);//初始化表格

        if (titleOfStudentList.size()>0){
            int i=0;
            for(TitleOfStudent t:titleOfStudentList){//赋值
                rowData[i][0]=t.getStudent().getStudentName();
                rowData[i][1]=t.getStudent().getStudentSex()==0?'女':'男';
                rowData[i][2]=t.getStudent().getStudentPhone();
                rowData[i][3]=t.getDesOfStuId()==null?"未填报":"已经填报";
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
        JLabel title=new JLabel("学生信息列表");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        titleJpanel.add(title);
        add(titleJpanel,BorderLayout.NORTH);
        /**
         * 教师列表
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

        JPanel showTipMessageLocationJpanel=this;
        /**
         * 监听首页
         */
        firstPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage==1||pageData.getPageNum()==1){
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已到首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
                System.out.println("当前页="+pageData.getPageNum()+"共"+pageData.getPages()+"data="+rowData);
                if (currentPage==1||pageData.getPageNum()==1){
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已达首页","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已达末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(showTipMessageLocationJpanel,"已达末页","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
