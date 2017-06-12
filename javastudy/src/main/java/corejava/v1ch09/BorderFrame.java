package v1ch09;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class BorderFrame extends JFrame {

    public BorderFrame() {
        setTitle("Border Test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();
        demoPanel = new JPanel();
        buttonGroup = new ButtonGroup();

        addRadioButton("Empty", BorderFactory.createEmptyBorder());
        addRadioButton("Raised bevel",
                BorderFactory.createBevelBorder(BevelBorder.RAISED));
        addRadioButton("Lowered bevel",
                BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Line", BorderFactory.createLineBorder(Color.blue));
        addRadioButton("Matte",
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));

        buttonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Border type"));

        setLayout(new GridLayout(2, 1));
        add(buttonPanel);
        add(demoPanel);
    }

    public void addRadioButton(String buttonname, final Border border) {
        JRadioButton button = new JRadioButton(buttonname);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                demoPanel.setBorder(border);
            }
        });

        buttonGroup.add(button);
        buttonPanel.add(button);
    }

    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup buttonGroup;

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                BorderFrame frame = new BorderFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
