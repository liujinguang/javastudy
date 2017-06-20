package jfc.ch02.sample04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TestJFrame extends JFrame {
    public TestJFrame() {
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEtchedBorder());
        contentPane.add(panel, BorderLayout.CENTER);

        // add GJApp's status area to contentPane
        contentPane.add(GJApp.getStatusArea(), BorderLayout.SOUTH);

        // update GJApp's status area with resource string
        GJApp.showStatus(GJApp.getResource("statusAreaText"));
    }

    public static void main(String[] args) {
        // launch application
        GJApp.launch(new TestJFrame(), "Status area", 300, 300, 450, 300);
    }
}

class GJApp {
    private static JPanel statusArea = new JPanel();
    private static JLabel status = new JLabel();
    private static ResourceBundle resources;

    static {
        // System.out.println(GJApp.class
        // .getResource("/jfc/ch02/sample04/GJApp.properties"));
        // System.out.println(Locale.getDefault());
        // System.out.println(GJApp.class.getPackage().toString().substring(8));
        // resources = ResourceBundle.getBundle(
        // GJApp.class.getResource("/jfc/ch02/sample04/GJApp.properties")
        // .getPath(), Locale.getDefault());
        resources = ResourceBundle.getBundle(GJApp.class.getPackage()
                .toString().substring(8)
                + ".GJApp", Locale.getDefault());

    }

    private GJApp() { // defeat instantiation

    }

    public static void launch(final JFrame f, String title, final int x,
            final int y, final int w, final int h) {
        f.setTitle(title);
        f.setBounds(x, y, w, h);
        f.setVisible(true);

        statusArea.setBorder(BorderFactory.createEtchedBorder());
        statusArea.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statusArea.add(status);
        status.setHorizontalAlignment(JLabel.LEFT);

        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static JPanel getStatusArea() {
        return statusArea;
    }

    public static void showStatus(String s) {
        status.setText(s);
    }

    static String getResource(String key) {
        return (resources == null) ? null : resources.getString(key);
    }
}
