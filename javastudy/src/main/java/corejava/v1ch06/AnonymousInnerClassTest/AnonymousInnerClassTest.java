package v1ch06.AnonymousInnerClassTest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousInnerClassTest {

    public AnonymousInnerClassTest() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
        
        JOptionPane.showMessageDialog(null, "Quite program?");
        System.exit(0);
    }
}

class TalkingClock {
    public void start(int interval, final boolean beep) {
        ActionListener listener = new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        
        Timer t = new Timer(1000, listener);
        t.start();
    }
}
