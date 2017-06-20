package jfc.ch04.sample03;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentPaintTest extends JFrame {

    public ComponentPaintTest() {
        setLayout(new FlowLayout());

        ImageCanvas canvas = new ImageCanvas("sphere.gif");
        canvas.setBorder(BorderFactory.createTitledBorder("ImageCanvas"));

        add(canvas);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComponentPaintTest frame = new ComponentPaintTest();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

class ImageCanvas extends JPanel {
    private ImageIcon icon;

    public ImageCanvas(String imageName) {
        icon = new ImageIcon(ComponentPaintTest.class.getResource(imageName));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Insets insets = getInsets();

        icon.paintIcon(this, g, insets.left, insets.top);
    }

    @Override
    public Dimension getPreferredSize() {
        Insets insets = getInsets();

        return new Dimension(icon.getIconWidth() + insets.left + insets.right,
                icon.getIconHeight() + insets.top + insets.bottom);
    }
}
