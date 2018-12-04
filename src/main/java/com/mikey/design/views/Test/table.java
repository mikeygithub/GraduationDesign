package com.mikey.design.views.Test;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/12/4 20:50
 * @Version 1.0
 */


        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
        import javax.swing.table.*;

public class table {

    JTable table = null;
    JButton viewButton2 = new JButton("hhh");


    JButton editButton2 = new JButton("www");
    DefaultTableModel model = null;


    public JComponent makeUI() {
        String[] columnNames = { "String", "Button" }; // When I increase the
        // number of columns it
        // hides another button
        Object[][] data = { { "AAA", null }, { "BBB", null } };
        model = new DefaultTableModel(data, columnNames) {

        };
        table = new JTable(model);
        table.setRowHeight(36);
        ActionPanelEditorRenderer er = new ActionPanelEditorRenderer();
        TableColumn column = table.getColumnModel().getColumn(1);
        column.setCellRenderer(er);
        column.setCellEditor(er);

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(table));
        p.setPreferredSize(new Dimension(320, 200));
        return p;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().add(new table().makeUI());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }



    class ActionPanelEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        public ActionPanelEditorRenderer() {
            super();
//			JButton viewButton2 = new JButton(new AbstractAction("yy") {
//
//				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(null, "Viewing");
//				}
//			});
//			JButton editButton2 = new JButton(new AbstractAction("edit2") {
//				;
//				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(null, "Editing");
//				}
//			});
            //panel1.setOpaque(true);

            //panel2.setOpaque(true);


            panel2.add(viewButton2);
            panel2.add(editButton2);
            viewButton2.setBackground(Color.red);

            viewButton2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub

                    int i = table.getSelectedRow();
                    String s = (String)model.getValueAt(i, 0);

                    JOptionPane.showMessageDialog(null, s);
                }
            });
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            panel2.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());



            //	panel2.setBackground(table.getBackground());
            return panel2;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel2.setBackground(table.getSelectionBackground());
            return panel2;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }
}