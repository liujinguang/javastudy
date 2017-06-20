package jfc.ch04.sample02;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ComponentPaintTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentPaintTest frame = new ComponentPaintTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComponentPaintTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new FlowLayout());
		
		ImageCanvas canvas = new ImageCanvas("sphere.gif");
		add(canvas);
	}

}

class ImageCanvas extends Canvas {

	public ImageCanvas(String imageName) {
		image = Toolkit.getDefaultToolkit().getImage(ComponentPaintTest.class.getResource(imageName));
		MediaTracker mt = new MediaTracker(this);

		try {
			mt.addImage(image, 0);
			mt.waitForID(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(image.getWidth(null), image.getHeight(null));
	}

	private Image image;
}
