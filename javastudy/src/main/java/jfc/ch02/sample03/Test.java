package jfc.ch02.sample03;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Test extends JApplet {
    @Override
    public void init() {
        super.init();
        
      Container contentPanel = getContentPane();
      Icon icon = new ImageIcon(Test.this.getClass().getResource(
              "swing.gif").getPath(), "An animated GIF of Duke on a swing");
      JLabel label = new JLabel("Swing", icon, SwingConstants.CENTER);
      contentPanel.add(label, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        JApplet applet = new Test();
        applet.init();
        
        //share the contentPane
        frame.setContentPane(applet.getContentPane());
        frame.setBounds(100, 100, 300, 200);
        frame.setTitle("An application");
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
