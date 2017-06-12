package v1ch07.NotHelloWorld;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NotHelloWorldFrame extends JFrame {

    public NotHelloWorldFrame() {
        setTitle("Not Hello World Frame");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        NotHelloWorldComponet comp = new NotHelloWorldComponet();
        add(comp);
    }
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new NotHelloWorldFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

@SuppressWarnings("serial")
class NotHelloWorldComponet extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Not a hello world program", MESSAGE_X, MESSAGE_Y);
    }
    
    private static final int MESSAGE_X = 75;
    private static final int MESSAGE_Y = 100;
}
