package jfc.ch03.example01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestJApplet extends JApplet {
    @Override
    public void init() {
        super.init();
        final int value = 50;
        final BoundedRangeModel model = new DefaultBoundedRangeModel(100, 0, 0,
                100);
        JSlider slider = new JSlider(model);
        final JLabel readout = new JLabel("100%");
        ImageIcon image = new ImageIcon(TestJApplet.this.getClass()
                .getResource("shortcake.jpg").getPath());
        ImageView imageView = new ImageView(image, model);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Set Image Size:"));
        panel.add(slider);
        panel.add(readout);

        add(panel, BorderLayout.NORTH);
        add(imageView, BorderLayout.CENTER);

        model.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                String s = Integer.toString(model.getValue());
                readout.setText(s + "%");
                readout.revalidate();
            }
        });
        
        model.setValue(value);
    }
}

class ImageView extends JScrollPane {

    public ImageView(final ImageIcon icon, BoundedRangeModel model) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(icon));

        this.icon = icon;
        this.originalImage = icon.getImage();

        setViewportView(panel);
        model.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                BoundedRangeModel model = (BoundedRangeModel) e.getSource();
                if (!model.getValueIsAdjusting()) {
                    int min = model.getMinimum();
                    int max = model.getMaximum();
                    int span = max - min;
                    int value = model.getValue();

                    double multiplier = (double) value / (double) span;
                    multiplier = multiplier == 0.0 ? 0.01 : multiplier;
                    Image scaled = originalImage.getScaledInstance(
                            (int) (originalSize.width * multiplier),
                            (int) (originalSize.height * multiplier),
                            Image.SCALE_FAST);

                    icon.setImage(scaled);
                    panel.revalidate();
                }
            }
        });

        originalSize = new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }

    private JPanel panel;
    private Dimension originalSize;
    private Image originalImage;
    private ImageIcon icon;
}