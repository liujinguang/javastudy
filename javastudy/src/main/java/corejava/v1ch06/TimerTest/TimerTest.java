package v1ch06.TimerTest;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {

    public TimerTest() {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args) {
        ActionListener listener = new TimerPrinter();
        
        Timer t = new Timer(2000, listener);
        t.start();
        
        JOptionPane.showMessageDialog(null, "Quit");
        
        t.stop();
    }
}


class TimerPrinter implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone, the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
    
}
