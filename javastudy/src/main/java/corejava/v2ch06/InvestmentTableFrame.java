package v2ch06;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class InvestmentTableFrame extends JFrame {

    public InvestmentTableFrame() {
        setTitle("InvestmentTable");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        TableModel model = new InvestmentTableModel(30, 5, 10);
        JTable table = new JTable(model);
        add(new JScrollPane(table));
    }

    public static void main(String[] args) {
        JFrame frame = new InvestmentTableFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 300;
}

class InvestmentTableModel extends AbstractTableModel {
    public int getRowCount() {
        return years;
    }

    public int getColumnCount() {
        return maxRate - minRate +  1;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        double rate = (columnIndex + minRate) / 100.0;
        int nperiods = rowIndex;
        double futureBalance = INITIAL_BALANCE * Math.pow(1+rate, nperiods);
        
        return String.format("%.2f", futureBalance);
    }
    
    public String getColumnName(int c) {
        return (c + minRate) + "%";
    }
    
    
    /** Constructs an investment table model
     * 
     * @param years the number of years
     * @param minRate the lowest interest rate to tabulate
     * @param maxRate the highest interest rate to tabulate
     */
    public InvestmentTableModel(int years, int minRate, int maxRate) {
        super();
        this.years = years;
        this.minRate = minRate;
        this.maxRate = maxRate;
    }


    private int years;
    private int minRate;
    private int maxRate;
    private static double INITIAL_BALANCE = 10000.0;
}
