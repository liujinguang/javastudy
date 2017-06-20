package jfc.ch03.example03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class TestPropertyChangeFrame extends JFrame {
    public TestPropertyChangeFrame() {
        tree = new JTree();

        JPanel ctrlPanel = new JPanel();
        final JCheckBox showRoot = new JCheckBox("show root node");
        showRoot.setSelected(tree.isRootVisible());
        ctrlPanel.setLayout(new FlowLayout());
        ctrlPanel.add(showRoot);
        showRoot.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tree.setRootVisible(showRoot.isSelected());
            }
        });

        add(ctrlPanel, BorderLayout.NORTH);

        tree.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if (name.equals(JTree.ROOT_VISIBLE_PROPERTY)) {
                    String msg = "Root Visible Property: "
                            + evt.getNewValue().toString();
                    JOptionPane.showMessageDialog(TestPropertyChangeFrame.this,
                            msg, "Propterty Change",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(new JScrollPane(tree), BorderLayout.CENTER);

    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new TestPropertyChangeFrame();
                frame.setVisible(true);
                frame.setBounds(100, 100, 450, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    private JTree tree;
}
