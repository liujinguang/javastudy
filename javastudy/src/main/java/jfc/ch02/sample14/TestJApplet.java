package jfc.ch02.sample14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

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
    public GetInfoThread(final TestJApplet applet) {
        runnable = new Runnable() {
            
            public void run() {
                JProgressBar pb = applet.getProgressBar();
                pb.setValue(value);
                System.out.println(Thread.currentThread().getName());
                // TODO Auto-generated method stub
                
            }
        };
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                //simulate "lengthy" information retrieval
                Thread.sleep(500);
//                System.out.println(".");
                
                //this is OK, because it is not called
                // on the event dispatch thread
                value = (int)(Math.random()*100);
                SwingUtilities.invokeLater(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private int value;
    private Runnable runnable;
}
