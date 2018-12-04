package com.mikey.design.views.teacher;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

/**
 * @author Mikey
 * @Title: 继承JTable类
 * @Description: 设置表格数据不可修改
 * @Email:1625017540@qq.com
 * @date 2018/12/4 22:47
 * @Version 1.0
 */
public class AdmitStudentTable extends JTable {

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column==4){
            return true;
        }else {
        return false;
        }
    }

    public AdmitStudentTable(final Object[][] rowData, final Object[] columnNames) {
        super( rowData, columnNames);
    }
}
