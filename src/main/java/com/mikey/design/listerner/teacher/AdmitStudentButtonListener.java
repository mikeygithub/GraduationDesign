package com.mikey.design.listerner.teacher;

import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.service.TitleOfStudentService;
import com.mikey.design.utils.SpringUtil;
import com.mikey.design.views.teacher.AdmitStudentsJpanel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * @author Mikey
 * @Title: 监听录取按钮
 * @Description: 监听教师在报名列表录取报名学生
 * @Email:1625017540@qq.com
 * @date 2018/12/4 21:27
 * @Version 1.0
 */
public class AdmitStudentButtonListener extends AbstractCellEditor implements TableCellEditor {

    private TitleOfStudentService titleOfStudentService;

    //当前教师的毕设题目列表
    private static List<TitleOfStudent>  titleOfStudentList;

    public static void setTitleOfStudentList(List<TitleOfStudent> titleOfStudentList) {
        AdmitStudentButtonListener.titleOfStudentList = titleOfStudentList;
    }

    private JPanel buttonJpanel;

    private JButton admitButton;

    public AdmitStudentButtonListener(JTable table,AdmitStudentsJpanel admitStudentsJpanel) {

        //获取当前登入用户信息

        titleOfStudentService = (TitleOfStudentService) SpringUtil.getBean("titleOfStudentServiceImpl");

        buttonJpanel=new JPanel();
        buttonJpanel.setLayout(new BorderLayout());
        admitButton=new JButton("录取");
        admitButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        buttonJpanel.add(admitButton,BorderLayout.CENTER);


        admitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("Message=当前页数量"+titleOfStudentList.size());

                int selectedRow = table.getSelectedRow();

                System.out.println("选中的行--------------------》》》》》》》》》》》》"+selectedRow);

                if (selectedRow>titleOfStudentList.size()){
                    JOptionPane.showMessageDialog(admitStudentsJpanel, "该行无数据");
                    return;
                }

                int result = JOptionPane.showConfirmDialog(admitStudentsJpanel, "您确定要录取这位学生吗?", "确认录取", JOptionPane.YES_NO_OPTION);

                if(result ==  JOptionPane.YES_OPTION){
                    //进行录取操作、调用service执行sql语句
                    TitleOfStudent titleOfStudent = titleOfStudentList.get(selectedRow);
                    //
                    System.out.println("将要录取的学生姓名="+titleOfStudent.getStudent().getStudentName());
                    //录取
                    titleOfStudentService.admitStudentWish(titleOfStudent);

                    titleOfStudentList.remove(selectedRow);//移除

                    JOptionPane.showMessageDialog(admitStudentsJpanel, "录取学生成功");

                    admitStudentsJpanel.refreshData();//刷新数据

                    System.out.println("录取学生成功===================》》》》》》》》》");
                }
                fireEditingStopped();//终止编辑
            }
        });
    }
    /**
     * 为编辑器设置初始值
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return buttonJpanel;
    }

    /**
     *设置编辑器返回值
     * @return
     */
    @Override
    public Object getCellEditorValue() {
        return null;
    }

}
