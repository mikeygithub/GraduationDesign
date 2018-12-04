package com.mikey.design.views.Test;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 21:22
 * @Version 1.0
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class MyButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = -6546334664166791132L;

    private JPanel panel;

    private JButton button;

    private int num;

    public MyButtonEditor() {

        initButton();

        initPanel();

        panel.add(this.button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,
                        "您确定要录取这位学生吗?", "确认录取",
                        JOptionPane.YES_NO_OPTION);

                if(res ==  JOptionPane.YES_OPTION){
                    num++;
                }
                //stopped!!!!
                fireEditingStopped();

            }
        });

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        num = (Integer) value;

        button.setText(value == null ? "" : String.valueOf(value));

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return num;
    }

}