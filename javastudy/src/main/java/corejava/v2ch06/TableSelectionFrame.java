package v2ch06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableSelectionFrame extends JFrame {

    /**
     * This frame shows a multiplication table and has menus for setting the
     * row/column/cell selection models, and for adding and removing rows and
     * columns
     */
    public TableSelectionFrame() {
        setTitle("TableSelectionSet");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up multiplication table
        model = new DefaultTableModel(10, 10);
        for (int i = 0; i < model.getRowCount(); i++)
            for (int j = 0; j < model.getColumnCount(); j++) {
                model.setValueAt((i + 1) * (j + 1), i, j);
            }

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        removeColumns = new ArrayList<TableColumn>();

        // create menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu selectionMenu = new JMenu("Selection");
        menuBar.add(selectionMenu);

        final JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("Rows");
        final JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("Columns");
        final JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("Cells");

        rowsItem.setSelected(table.getRowSelectionAllowed());
        rowsItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                table.setRowSelectionAllowed(rowsItem.isSelected());
                cellsItem.setSelected(table.getCellSelectionEnabled());
            }
        });
        selectionMenu.add(rowsItem);

        columnsItem.setSelected(table.getColumnSelectionAllowed());
        columnsItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                table.setColumnSelectionAllowed(columnsItem.isSelected());
                cellsItem.setSelected(table.getCellSelectionEnabled());
            }
        });
        selectionMenu.add(columnsItem);
        
        cellsItem.setSelected(table.getCellSelectionEnabled());
        cellsItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                table.setCellSelectionEnabled(cellsItem.isSelected());
                rowsItem.setSelected(table.getRowSelectionAllowed());
                columnsItem.setSelected(table.getColumnSelectionAllowed());
            }
        });
        selectionMenu.add(cellsItem);
        
        JMenu tableMenu = new JMenu("Edit");
        menuBar.add(tableMenu);
        
        JMenuItem hideColumnsItem = new JMenuItem("Hide Columns");
        hideColumnsItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                int[] selected = table.getSelectedColumns();
                TableColumnModel columnModel = table.getColumnModel();
                
                // remove columns from view, starting at the last index
                // so that column numbers aren't affected
                for (int i = selected.length -1; i >= 0; i--) {
                    TableColumn column = columnModel.getColumn(selected[i]);
                    table.removeColumn(column);
                    
                    //store removed columns for "show columns" command
                    removeColumns.add(column);
                }
                
            }
        });
        tableMenu.add(hideColumnsItem);
        
        JMenuItem showColumnsItem = new JMenuItem("Show Columns");
        showColumnsItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //restore all removed columns
                for (TableColumn tc : removeColumns) {
                    table.addColumn(tc);
                }
                
                removeColumns.clear();
            }
        });
        tableMenu.add(showColumnsItem);
        
        JMenuItem addRowItem = new JMenuItem("Add Row");
        addRowItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //add a new row to the multiplication table in
                //the model
                Integer[] newCells = new Integer[model.getColumnCount()];
                for (int i = 0; i < newCells.length; i++) {
                    newCells[i] = (i + 1) * (model.getRowCount() + 1);
                }
                model.addRow(newCells);
                
            }
        });
        tableMenu.add(addRowItem);
        
        JMenuItem removeRowItem = new JMenuItem("Remove Rows");
        removeRowItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                int[] selected = table.getSelectedRows();
                for (int i = selected.length -1; i >= 0; i--) {
                    model.removeRow(selected[i]);
                }
            }
        });
        tableMenu.add(removeRowItem);
        
        JMenuItem clearCellsItem = new JMenuItem("Clear Cells");
        clearCellsItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getRowCount(); i++)
                    for (int j = 0; j < table.getColumnCount(); j++)
                        if (table.isCellSelected(i, j)) {
                            table.setValueAt(0, i, j);
                        }
            }
        });
        tableMenu.add(clearCellsItem);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new TableSelectionFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    private DefaultTableModel model;
    private JTable table;
    private ArrayList<TableColumn> removeColumns;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
}
