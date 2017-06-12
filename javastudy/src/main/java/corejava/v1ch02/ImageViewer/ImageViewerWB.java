package v1ch02.ImageViewer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class ImageViewerWB extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImageViewerWB frame = new ImageViewerWB();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ImageViewerWB() {
        setTitle("ImageViewerWB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        chooser = new JFileChooser();
        String path = (new File(ImageViewerWB.this.getClass()
                .getResource("Cay.gif").getPath())).getParent();
        chooser.setCurrentDirectory(new File(path));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = chooser.showOpenDialog(null);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selected = chooser.getSelectedFile().getPath();
                    imageLabel.setIcon(new ImageIcon(selected));
                }
            }
        });
        menu.add(openItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        imageLabel = new JLabel("");
        contentPane.add(imageLabel, BorderLayout.NORTH);
    }

    private JLabel imageLabel;
    private JPanel contentPane;
    private JFileChooser chooser;
}
