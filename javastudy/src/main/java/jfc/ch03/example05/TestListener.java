package jfc.ch03.example05;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicSliderUI;

public class TestListener extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new TestListener();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 450, 300);
            }
        });
    }

    public TestListener() {
        setLayout(new FlowLayout());

        final JSlider slider = new JSlider();
        slider.setUI(new AnnotatedSliderUI(slider));
        add(slider);
        final JCheckBox checkBox = new JCheckBox("Annotate");
        checkBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean selected = checkBox.isSelected();

                slider.putClientProperty(AnnotatedSliderUI.ANNOTATE_PROPERTY,
                        selected ? Boolean.TRUE : Boolean.FALSE);
                
                slider.repaint();
            }
        });
        add(checkBox);

    }
}

class AnnotatedSliderUI extends BasicSliderUI {
    public static String ANNOTATE_PROPERTY = " AnnotatedSliderUI.annotate";
    boolean annotate = false;

    public AnnotatedSliderUI(JSlider b) {
        super(b);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Dimension d = super.getPreferredSize(c);

        return new Dimension(d.width, d.height + 20);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        if (annotate) {
            JSlider slider = (JSlider) c;
            int v = slider.getValue();

            g.setColor(UIManager.getColor(" Label.foreground"));
            g.setFont(new Font(" Dialog", Font.PLAIN, 28));
            g.drawString((new Integer(v)).toString(), 10, 33);
        }

        super.paint(g, c);
    }

    @Override
    protected PropertyChangeListener createPropertyChangeListener(JSlider slider) {
        return new AnnotatePropertyListener();
    }

    protected class AnnotatePropertyListener extends
            BasicSliderUI.PropertyChangeHandler {
        @Override
        public void propertyChange(PropertyChangeEvent e) {
            super.propertyChange(e);

            String name = e.getPropertyName();
            if (name.equals(ANNOTATE_PROPERTY)) {
                if (e.getNewValue() != null) {
                    annotate = ((Boolean) e.getNewValue()).booleanValue();
                }
            }
        }
    }

}
