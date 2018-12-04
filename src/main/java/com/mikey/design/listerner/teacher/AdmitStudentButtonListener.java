package com.mikey.design.listerner.teacher;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mikey
 * @Title: 监听录取按钮
 * @Description: 监听教师在报名列表录取报名学生
 * @Email:1625017540@qq.com
 * @date 2018/12/4 21:27
 * @Version 1.0
 */
public class AdmitStudentButtonListener extends AbstractCellEditor implements TableCellEditor {

    private JPanel buttonJpanel;

    private JButton admitButton;

    public AdmitStudentButtonListener() {

        buttonJpanel=new JPanel();
        buttonJpanel.setLayout(new BorderLayout());
        admitButton=new JButton("录取");
        buttonJpanel.add(admitButton,BorderLayout.CENTER);


        admitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "您确定要录取这位学生吗?", "确认录取",
                        JOptionPane.YES_NO_OPTION);

                if(result ==  JOptionPane.YES_OPTION){
                    //进行录取操作、调用service执行sql语句
                    JOptionPane.showMessageDialog(null, "录取学生成功");
                    System.out.println("录取学生成功===================》》》》》》》》》");
                }
                fireEditingStopped();//终止编辑
            }
        });
    }
    public AdmitStudentButtonListener(Integer studnetNum) {//录取学生

    }

    /**
     * 为编辑器设置初始 value
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
