package jfc.ch02.sample06;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JApplet;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        super.init();
        
        Container contentPane = getContentPane();
        Panel p = new BorderedPanel();
        
        // set layout managers for content pane and panel
        // to null so their components can be explicitly
        // positioned and sized
        contentPane.setLayout(null);
        p.setLayout(null);
        
        // create heavyweight AWT buttons
        b1 = new Button("Heavyweight Button #1");
        b2 = new Button("Heavyweight Button #2");
        b3 = new Button("Heavyweight Button #3");
        b4 = new Button("Heavyweight Button #4");

        // create lightweight Swing buttons
        jb1 = new JButton("Swing Button #1");
        jb2 = new JButton("Swing Button #2");
        jb3 = new JButton("Swing Button #3");

        // set bounds for heavyweights
        b1.setBounds(10, 10, 150, 25);
        b2.setBounds(110, 25, 150, 25);
        b3.setBounds(210, 40, 150, 25);
        b4.setBounds(310, 55, 150, 25);

        // set bounds for lightweights
        jb1.setBounds(5, 5, 150, 65);
        jb2.setBounds(20, 45, 150, 65);
        jb3.setBounds(35, 85, 150, 65);
        
        // set bounds for panel and add lightweights
        p.setBounds(85, 15, 195, 155);
        p.add(jb1);
        p.add(jb2);
        p.add(jb3);

        // add AWT buttons and panel to content pane
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(p);
        contentPane.add(b3);
        contentPane.add(b4);
    }
    
    Button b1, b2, b3, b4;
    JButton jb1, jb2, jb3;
}

class BorderedPanel extends Panel {
    @Override
    public void paint(Graphics g) {
        Dimension size = getSize();
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, size.width - 1, size.height - 1);
        // TODO Auto-generated method stub
        super.paint(g);
    }
}
