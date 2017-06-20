package jfc.ch02.sample10;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestJApplet extends JApplet{
    @Override
    public void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JPanel panel = new JPanel();
        panel.add(new JButton("Swing Button..."));
        panel.add(new Button("AWT Button..."));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(panel);
        scrollPane.setPreferredSize(new Dimension(125, 50));
        
        contentPane.add(scrollPane);
    }
}
