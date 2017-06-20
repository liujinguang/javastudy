package jfc.ch02.sample05;

import java.awt.Button;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JButton;

public class TestJApplet extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // create heavyweight AWT buttons
        b1 = new Button("Heavyweight Button #1");
        b2 = new Button("Heavyweight Button #2");
        b3 = new Button("Heavyweight Button #3");
        b4 = new Button("Heavyweight Button #4");

        // create lightweight Swing buttons
        jb1 = new JButton("Swing Button #1");
        jb2 = new JButton("Swing Button #2");
        jb3 = new JButton("Swing Button #3");

        // set bounds for heavyweight buttons
        b1.setBounds(10, 10, 150, 25);
        b2.setBounds(110, 25, 150, 25);
        b3.setBounds(210, 40, 150, 25);
        b4.setBounds(310, 55, 150, 25);

        // set bounds for lightweight buttons
        jb1.setBounds(85, 25, 150, 65);
        jb2.setBounds(100, 65, 150, 65);
        jb3.setBounds(115, 105, 150, 65);

        // add lightweight buttons
        contentPane.add(jb1);
        contentPane.add(jb2);
        contentPane.add(jb3);

        // add heavyweight buttons
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);  
        
    };
    
    Button b1, b2, b3, b4;
    JButton jb1, jb2, jb3;
}
