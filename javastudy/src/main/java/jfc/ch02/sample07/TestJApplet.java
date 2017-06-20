package jfc.ch02.sample07;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(new Button("Add AWT Button..."));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.add("New...");
        menu.add("Open...");
        menu.add("Save...");
        menu.add("Save as...");
        menu.add("Exit...");

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
}
