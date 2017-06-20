package jfc.ch15.example05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DesktopManagerTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesktopManagerTest frame = new DesktopManagerTest();
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
	public DesktopManagerTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

	}

}

class OutlineManager extends DefaultDesktopManager {
	@Override
	public void beginDraggingFrame(JComponent f) {
		super.beginDraggingFrame(f);
	}

	private void updateOutline(JComponent frame, int x, int y, int w, int h) {
		Container container = frame.getParent();
		Graphics g = container.getGraphics();

		try {
			g.setXORMode(container.getBackground());

			if (!first) {
				g.drawRect(last.x, last.y, last.width - 1, last.height - 1);
			}
			g.drawRect(x, y, w - 1, h - 1);
			
			first = false;
		} finally {
			g.dispose();
			last.setBounds(x, y, w, h);
		}
	}

	private void endOutline(JComponent frame) {
		frame.setVisible(true);
		setBoundsForFrame(frame, last.x, last.y, last.width, last.height);
	}

	private Rectangle start, last;
	private boolean first = true;
}
