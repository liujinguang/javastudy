package v1ch09;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColorChooserFrame extends JFrame {

    public ColorChooserFrame() {
        setTitle("Color Chooser Test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JPanel panel = new ColorChooserPanel();
        add(panel);
    }

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new ColorChooserFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

@SuppressWarnings("serial")
class ColorChooserPanel extends JPanel {
    public ColorChooserPanel() {
        JButton modalButton = new JButton("Modal");
        modalButton.addActionListener(new ModalListener());
        add(modalButton);

        JButton modalessButton = new JButton("Modaless");
        modalessButton.addActionListener(new ModalessListener());
        add(modalessButton);
        
        JButton immediateButton = new JButton("Immediate");
        immediateButton.addActionListener(new ImmediateListener());
        add(immediateButton);
    }

    /**
     * This listener pops up a modal color chooser
     */
    private class ModalListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Color defaultColor = getBackground();
            Color selected = JColorChooser.showDialog(ColorChooserPanel.this,
                    "Set backgroud", defaultColor);
            if (selected != null) {
                setBackground(selected);
            }
        }
    }

    private class ModalessListener implements ActionListener {
        public ModalessListener() {
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog(ColorChooserPanel.this,
                    "Backgroud color", false, chooser, new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            setBackground(chooser.getColor());

                        }
                    }, null);
        }

        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }

        private JDialog dialog;
        private JColorChooser chooser;
    }

    private class ImmediateListener implements ActionListener {

        public ImmediateListener() {
            chooser = new JColorChooser();
            chooser.getSelectionModel().addChangeListener(new ChangeListener() {
                
                public void stateChanged(ChangeEvent e) {
                    setBackground(chooser.getColor());
                }
            });
            
            dialog = new JDialog((Frame)null, false);
            dialog.add(chooser);
            dialog.pack();
        }

        public void actionPerformed(ActionEvent e) {
            chooser.setColor(getBackground());
            dialog.setVisible(true);
        }

        private JDialog dialog;
        private JColorChooser chooser;
    }

}
