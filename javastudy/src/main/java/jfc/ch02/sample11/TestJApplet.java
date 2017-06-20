package jfc.ch02.sample11;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel controlPanel = new ControlPanel(dtp);
        contentPane.add(controlPanel, BorderLayout.NORTH);

//        JPanel centerPanel = new JPanel();
        contentPane.add(dtp, BorderLayout.CENTER);
    }

    JDesktopPane dtp = new JDesktopPane();
}

class ControlPanel extends JPanel {
    public ControlPanel(final JDesktopPane dtp) {
        JButton b = new JButton("make frame");
        add(b);

        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JInternalFrame jif = new JInternalFrame();
                Container contentPane = jif.getContentPane();
                jif.setLocation(10, 50);
                jif.setTitle("Internal Frame" + cnt++);
                jif.setResizable(true);
                jif.setMaximizable(true);
                jif.setClosable(true);
                jif.setVisible(true);
                jif.setIconifiable(true);
                contentPane.setLayout(new FlowLayout());
                contentPane.add(new ColoredCanvas(), "Center");
                jif.pack();
                dtp.add(jif, 2); //add at layer 2
            }
        });
    }

    private static int cnt = 0;
}

class ColoredCanvas extends Canvas {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 200);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension sz = getSize();
        g.setColor(Color.RED);
        g.fillRect(0, 0, sz.width, sz.height);

//        super.paint(g);
    }
}
