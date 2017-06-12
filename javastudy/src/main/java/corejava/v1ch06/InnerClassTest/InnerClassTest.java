package v1ch06.InnerClassTest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

    public InnerClassTest() {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();
        
        //keep the program running until selects "OK"
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }

}

class TalkingClock {
    /**
     * Constructs a talking clock
     * 
     * @param interval
     *            the interval between messages
     * @param beep
     *            true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        super();
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    private int interval;
    private boolean beep;

    public class TimerPrinter implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

    }
}
