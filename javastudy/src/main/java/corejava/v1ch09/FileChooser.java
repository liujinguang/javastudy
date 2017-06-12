package v1ch09;

import javax.swing.Icon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

/**
 * @author bob A frame that has a menu for loading an image and a display area
 *         for the loaded image.
 */
@SuppressWarnings("serial")
public class FileChooser extends JFrame {

    public FileChooser() {
        setTitle("File Chooser Test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new FileOpenListener());
        menu.add(openItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        label = new JLabel();
        add(label);

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "gif");
        fileChooser.setFileFilter(filter);

        fileChooser.setAccessory(new ImagePreviewer(fileChooser));
        fileChooser.setFileView(new FileIconView(filter, new ImageIcon(
                FileChooser.class.getResource("palette.gif"))));
    }

    private class FileOpenListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (fileChooserDirPath == null) {
                fileChooser.setCurrentDirectory(new File(System
                        .getProperty("user.home")));
            } else {
                fileChooser.setCurrentDirectory(new File(fileChooserDirPath));
            }

            // show file chooser dialog
            int result = fileChooser.showOpenDialog(FileChooser.this);

            // if image file accepted, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = fileChooser.getSelectedFile().getPath();
                fileChooserDirPath = fileChooser.getSelectedFile().getParent();
                label.setIcon(new ImageIcon(name));
            }
        }

    }

    private JLabel label;

    private JFileChooser fileChooser;
    // record the directory last visited
    private String fileChooserDirPath = null;

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                FileChooser chooser = new FileChooser();
                chooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                chooser.setVisible(true);
            }
        });
    }
}

/**
 * A file view that displays an icon for all files that match a file filter.
 */
class FileIconView extends FileView {
    /**
     * Constructs a FileIconView.
     * 
     * @param aFilter
     *            a file filter--all files that this filter accepts will be
     *            shown with the icon.
     * @param anIcon
     *            --the icon shown with all accepted files.
     */
    public FileIconView(FileFilter filter, Icon icon) {
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File file) {
        System.out.println("getIcon of " + file.getName());
        if (!file.isDirectory() && filter.accept(file)) {
            return icon;
        } else {
            return null;
        }
    }

    private FileFilter filter;

    private Icon icon;
}

/**
 * A file chooser accessory that previews images.
 */
@SuppressWarnings("serial")
class ImagePreviewer extends JLabel {
    /**
     * Constructs an ImagePreviewer.
     * 
     * @param chooser
     *            the file chooser whose property changes trigger an image
     *            change in this previewer
     */
    public ImagePreviewer(JFileChooser chooser) {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                    File file = (File) evt.getNewValue();
                    if (file == null) {
                        setIcon(null);
                        return;
                    }

                    // read the image into an icon
                    ImageIcon icon = new ImageIcon(file.getPath());

                    // if the icon is too large to fit, scale it
                    if (icon.getIconWidth() > getWidth()) {
                        icon = new ImageIcon(icon.getImage().getScaledInstance(
                                getWidth(), -1, Image.SCALE_DEFAULT));
                    }
                    
                    setIcon(icon);
                }

            }
        });
    }
}
