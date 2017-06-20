package jfc.ch02.sample01;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        super.init();

//        Container contentPanel = getContentPane();
        Icon icon = new ImageIcon(TestJApplet.this.getClass().getResource(
                "swing.gif").getPath(), "An animated GIF of Duke on a swing");
        JLabel label = new JLabel("Swing", icon, SwingConstants.CENTER);
//        contentPanel.add(label, BorderLayout.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
