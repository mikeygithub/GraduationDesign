package com.mikey.design.views.Test;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 21:22
 * @Version 1.0
 */
public class MyButtonRenderer implements TableCellRenderer {
    private JPanel panel;

    private JButton button;

    private int num;

    public MyButtonRenderer() {
        initButton();

        initPanel();

        panel.add(button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        num = (Integer) value;

        button.setText(value == null ? "" : String.valueOf(value));

        return panel;
    }

}
