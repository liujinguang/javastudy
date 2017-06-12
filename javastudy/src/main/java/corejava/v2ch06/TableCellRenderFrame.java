package v2ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableCellRenderFrame extends JFrame {

    public TableCellRenderFrame() {
        setTitle("TableCellRenderTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        TableModel model = new PlanetTableModel();
        JTable table = new JTable(model);
        table.setRowSelectionAllowed(false);

        // set up renders and editors
        table.setDefaultEditor(Color.class, new ColorTableCellEditor());
        table.setDefaultRenderer(Color.class, new ColorTableCellRender());

        JComboBox<Integer> moonComboBox = new JComboBox<Integer>();
        for (int i = 0; i <= 20; i++) {
            moonComboBox.addItem(i);
        }
        
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn moonColumn = columnModel.getColumn(PlanetTableModel.MOONS_COLUMN);
        moonColumn.setCellEditor(new DefaultCellEditor(moonComboBox));
        moonColumn.setHeaderRenderer(table.getDefaultRenderer(ImageIcon.class));
        moonColumn.setHeaderValue(new ImageIcon(this.getClass().getResource("Moons.gif")));
        
        //show table
        table.setRowHeight(100);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new TableCellRenderFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
    }

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

}

class ColorTableCellRender extends JPanel implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground((Color) value);
        if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        } else {
            setBorder(null);
        }
        // TODO Auto-generated method stub
        return this;
    }

}

/**
 * @author bob The planet table model specifies the values, rendering and
 *         editing properties for the planet data
 */
class PlanetTableModel extends AbstractTableModel {

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return cells[0][columnIndex].getClass();
    }

    public int getRowCount() {
        return cells.length;
    }

    public int getColumnCount() {
        return cells[0].length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return cells[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cells[rowIndex][columnIndex] = aValue;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == PLANET_COLUMN || columnIndex == MOONS_COLUMN
                || columnIndex == GASEOUS_COLUMN || columnIndex == COLOR_COLUMN;
    }

    public static final int PLANET_COLUMN = 0;
    public static final int MOONS_COLUMN = 2;
    public static final int GASEOUS_COLUMN = 3;
    public static final int COLOR_COLUMN = 4;

    private Object[][] cells = {
            { "Mercury", 2440.0, 0, false, Color.YELLOW,
                    new ImageIcon(this.getClass().getResource("Mercury.gif")) },
            { "Venus", 6052.0, 0, false, Color.YELLOW,
                    new ImageIcon(this.getClass().getResource("Venus.gif")) },
            { "Earth", 6378.0, 1, false, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("Earth.gif")) },
            { "Mars", 3397.0, 2, false, Color.RED,
                    new ImageIcon(this.getClass().getResource("Mars.gif")) },
            { "Jupiter", 71492.0, 16, true, Color.ORANGE,
                    new ImageIcon(this.getClass().getResource("Jupiter.gif")) },
            { "Saturn", 60268.0, 18, true, Color.ORANGE,
                    new ImageIcon(this.getClass().getResource("Saturn.gif")) },
            { "Uranus", 25559.0, 17, true, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("Uranus.gif")) },
            { "Neptune", 24766.0, 8, true, Color.BLUE,
                    new ImageIcon(this.getClass().getResource("Neptune.gif")) },
            { "Pluto", 1137.0, 1, false, Color.BLACK,
                    new ImageIcon(this.getClass().getResource("Pluto.gif")) } };

    private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous",
            "Color", "Image" };
    private static final long serialVersionUID = 1L;
}

@SuppressWarnings("serial")
class ColorTableCellEditor extends AbstractCellEditor implements
        TableCellEditor {

    public ColorTableCellEditor() {
        panel = new JPanel();

        colorChooser = new JColorChooser();
        colorDialog = JColorChooser.createDialog(null, "Planet Color", false,
                colorChooser, new ActionListener() { // OK button listener

                    public void actionPerformed(ActionEvent e) {
                        stopCellEditing();
                    }
                }, new ActionListener() { // Cancel button listener

                    public void actionPerformed(ActionEvent e) {
                        cancelCellEditing();
                    }
                });
        colorDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cancelCellEditing();
            }
        });
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        //
        colorDialog.setVisible(false);
        return super.shouldSelectCell(anEvent);
    }

    @Override
    public void cancelCellEditing() {
        // editing is canceled -- hide dialog
        colorDialog.setVisible(false);
        super.cancelCellEditing();
    }

    @Override
    public boolean stopCellEditing() {
        // editing is complete-hide dialog
        colorDialog.setVisible(false);
        return super.stopCellEditing();
    }

    public Object getCellEditorValue() {
        return colorChooser.getColor();
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        colorChooser.setColor((Color) value);
        return panel;
    }

    private JPanel panel;
    private JDialog colorDialog;
    private JColorChooser colorChooser;
}
