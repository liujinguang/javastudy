package v1ch07.SizedFrameTest;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SizedFrame extends JFrame {

    public SizedFrame() {
        setTitle("Sized Frame Test");
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        // set frame width, height and let the platform pick screen location
        setSize((int) screenSize.getWidth() / 2,
                (int) screenSize.getHeight() / 2);
        setLocationByPlatform(true);
        
        Image image = kit.getImage(SizedFrame.class.getResource("icon.gif"));
        setIconImage(image);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new SizedFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
