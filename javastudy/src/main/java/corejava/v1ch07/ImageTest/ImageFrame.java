package v1ch07.ImageTest;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ImageFrame extends JFrame {

    public ImageFrame() {
        setTitle("Image Frame Test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        JComponent component = new ImageComponent();
        add(component);
    }
    
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new ImageFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

@SuppressWarnings("serial")
class ImageComponent extends JComponent {
    public ImageComponent() {
        try {
            image = ImageIO.read(new File(ImageComponent.class.getResource("blue-ball.gif")
                    .getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) {
            return ;
        }
        
        //draw the image in the upper-left corner
        g.drawImage(image, 0, 0, null);
        
        int width = image.getWidth(this);
        int height = image.getHeight(this);
        
        //tile the image in the upper-left corner
        for (int i = 0; i * width <= getWidth(); i++) {
            for (int j = 0; j * height <= getHeight(); j++) {
                if (i + j > 0) {
                    g.copyArea(0, 0, width, height, i * width, j * height);
                }
            }
        }
    }

    private Image image;
}
