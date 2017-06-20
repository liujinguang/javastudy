package jfc.ch03.example02;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        super.init();

        JSlider slider = new JSlider(0, 100, 50);

        add(slider, BorderLayout.CENTER);
        slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();
                showStatus(Integer.toString(slider.getValue()));
            }
        });
    }

}
