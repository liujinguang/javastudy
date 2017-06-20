package jfc.ch02.sample02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TestJFrame extends JFrame {
    public TestJFrame() {
        super("An application");
        Container contentPane = getContentPane();
        Icon icon = new ImageIcon(TestJFrame.this.getClass()
                .getResource("swing.gif").getPath(),
                "An animated GIF of Duke on a swing");
        JLabel label = new JLabel("Swing", icon, SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        JFrame frame = new TestJFrame();
        frame.setBounds(100, 100, 300, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Process window close event");
                System.exit(0);
            }
        });
    }
}
