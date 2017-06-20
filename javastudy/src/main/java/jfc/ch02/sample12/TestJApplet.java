package jfc.ch02.sample12;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        Container contentPane = getContentPane();
        
        final JButton startButton = new JButton("Start");
        contentPane.setLayout(new FlowLayout());
        contentPane.add(startButton);
        contentPane.add(pb);
        
        startButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                GetInfoThread t = new GetInfoThread(TestJApplet.this);
                t.start();
                
                // this is not OK, because actionPerformed
                // is called on the event dispatch thread
                startButton.setEnabled(false);
            }
        });
    }
    
    public JProgressBar getProgressBar() {
        return pb;
    }
    
    private JProgressBar pb = new JProgressBar();
}

class GetInfoThread extends Thread {
    public GetInfoThread(TestJApplet applet) {
        this.applet = applet;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                //simulate "lengthy" information retrieval
                Thread.sleep(500);
                System.out.println(".");
                
                //this is not OK, because it is not called
                // on the event dispatch thread
                applet.getProgressBar().setValue((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private TestJApplet applet;
}
