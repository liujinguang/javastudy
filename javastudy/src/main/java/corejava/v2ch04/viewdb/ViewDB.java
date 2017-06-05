package corejava.v2ch04.viewdb;

import com.sun.rowset.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author bob
 * 
 */
public class ViewDB extends JFrame {

    public ViewDB() {
        setTitle("ViewDB");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        tableNames = new JComboBox<String>();
        tableNames.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                showTable((String) tableNames.getSelectedItem());
            }
        });
        add(tableNames, BorderLayout.NORTH);

        try {
            readProperties();

            Connection conn = getConnection();

            try {
                DatabaseMetaData meta = conn.getMetaData();
                ResultSet rs = meta.getTables(null, null, null,
                        new String[] { "TABLE" });
                while (rs.next()) {
                    tableNames.addItem(rs.getString(3));
                }
            } finally {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void showTable(String tblName) {
        try {
            // open connection
            Connection conn = getConnection();
            try {
                Statement stat = conn.createStatement();
                ResultSet result = stat
                        .executeQuery("SELECT * FROM " + tblName);

                // copy into cached row set
                crs = new CachedRowSetImpl();
                crs.setTableName(tblName);
                crs.populate(result);
            } finally {
                conn.close();
            }

            if (scrollPane != null) {
                remove(scrollPane);
            }

            dataPanel = new DataPanel(crs);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane, BorderLayout.CENTER);
            validate();
            showNextRow();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void showPreviousRow() {
        try {
            if (crs == null || crs.isFirst()) {
                return;
            }

            crs.previous();
            dataPanel.showRow(crs);
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    public void showNextRow() {
        try {
            if (crs == null || crs.isLast()) {
                return;
            }

            crs.next();
            dataPanel.showRow(crs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void deleteRow() {
        try {
            Connection conn = getConnection();

            try {
                crs.deleteRow();
                crs.acceptChanges(conn);
                if (!crs.isLast()) {
                    crs.next();
                } else if (!crs.isFirst()) {
                    crs.previous();
                } else {
                    crs = null;
                }
                dataPanel.showRow(crs);
            } finally {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public void saveChanges() {
        try {
            Connection conn = getConnection();
            try {
                dataPanel.setRow(crs);
                crs.acceptChanges(conn);
            } finally {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void readProperties() throws IOException {
        props = new Properties();
        String path = ViewDB.class.getResource("database.properties").getPath();
        FileInputStream in = new FileInputStream(path);
        props.load(in);
        in.close();

        String driver = props.getProperty("jdbc.driver");
        if (driver != null) {
            System.setProperty("jdbc.drivers", driver);
        }
    }

    /**
     * Gets a connection from the properties specified in the file
     * database.properties
     * 
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        String url = props.getProperty("jdbc.url");
        String user = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, user, password);
    }

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;

    private Properties props;
    private CachedRowSet crs;
    private DataPanel dataPanel;
    private Component scrollPane;
    private JComboBox<String> tableNames;
    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;

}

/**
 * This panel displays the contents of a result set.
 * 
 * @author bob
 * 
 */
@SuppressWarnings("serial")
class DataPanel extends JPanel {

    /**
     * Constructs the data panel.
     * 
     * @param rs
     *            the result set whose contents this panel displays
     */
    public DataPanel(RowSet rs) throws SQLException {
        fields = new ArrayList<JTextField>();
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            gbc.gridy = i - 1;
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;

            String columnName = rsmd.getColumnLabel(i);
            add(new JLabel(columnName), gbc);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;

            int columnWidth = rsmd.getColumnDisplaySize(i);
            JTextField textField = new JTextField(columnWidth);
            if (!rsmd.getColumnClassName(i).equals("java.lang.String")) {
                textField.setEditable(false);
            }
            fields.add(textField);

            add(textField, gbc);
        }
    }

    /**
     * Shows a database row by populating all text fields with the column
     * values.
     */
    public void showRow(ResultSet rs) throws SQLException {
        for (int i = 1; i < fields.size(); i++) {
            String field = rs.getString(i);
            JTextField textField = (JTextField) fields.get(i - 1);
            textField.setText(field);
        }
    }

    /**
     * Shows a database row by populating all text fields with the column
     * values.
     */
    public void setRow(RowSet rs) throws SQLException {
        for (int i = 1; i < fields.size(); i++) {
            String field = rs.getString(i);
            JTextField textField = fields.get(i - 1);
            if (!field.equals(textField.getText())) {
                rs.updateString(i, textField.getText());
            }
        }

        rs.updateRow();
    }

    private ArrayList<JTextField> fields;
}
