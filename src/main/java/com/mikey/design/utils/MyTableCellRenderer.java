package com.mikey.design.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 16:07
 * @Version 1.0
 */
public class MyTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if(row%2==0){//隔行变色
            setBackground(Color.WHITE);
        }else {
            setBackground(Color.LIGHT_GRAY);
        }
        if (column == 0) {//对齐
            setHorizontalAlignment(SwingConstants.CENTER);
        } else if (column == (table.getColumnCount() - 1)) {
            setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
        //自动换行
//        int maxPreferredHeight = 0;
//        for (int i = 0; i < table.getColumnCount(); i++) {
//            setText("" + table.getValueAt(row, i));
//            setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
//            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
//        }
//
//        if (table.getRowHeight(row) != maxPreferredHeight)  // 少了这行则处理器瞎忙
//            table.setRowHeight(row, maxPreferredHeight);
//
//        setText(value == null ? "" : value.toString());

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
