package jfc.ch02.sample13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

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
        getValue = new Runnable() {

            public void run() {
                JProgressBar pb = applet.getProgressBar();
                currentValue = pb.getValue();
            }
        };

        setValue = new Runnable() {

            public void run() {
                JProgressBar pb = applet.getProgressBar();
                pb.setValue(value);
            }
        };
    }

    @Override
    public void run() {
        while (true) {
            try {
                // simulate "lengthy" information retrieval
                Thread.sleep(500);

                // this is okay because the getValue's run()
                // is invoked on the event dispatch thread
                value = (int) (Math.random() * 100);

                SwingUtilities.invokeAndWait(getValue);
                System.out.println(".");

                if (currentValue != value) {
                    SwingUtilities.invokeLater(setValue);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable getValue, setValue;
    private int value, currentValue;
}
