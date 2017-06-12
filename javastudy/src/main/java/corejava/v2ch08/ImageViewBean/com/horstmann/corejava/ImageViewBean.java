package corejava.v2ch08.ImageViewBean.com.horstmann.corejava;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageViewBean extends JLabel {

    public ImageViewBean() {
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * Get file name property
     * @return image file name
     * 
     */
    public String getFileName() {
        if (file == null) {
            return "";
        } else {
            return file.getPath();
        }
    }

    public void setFileName(String fileName) {
        try {
            file = new File(fileName);
            setIcon(new ImageIcon(ImageIO.read(file)));
        } catch (Exception e) {
            file = null;
            setIcon(null);
        }
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(XPRESIZE, YPRESIZE);
    }

    private File file = null;
    private static final int XPRESIZE = 200;
    private static final int YPRESIZE = 300;
}
