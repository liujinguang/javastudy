package jfc.ch15.example04;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class DesktopPaneTest extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new DesktopPaneTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DesktopPaneTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setJMenuBar(createMenuBar());
		
		add(desktopPane, BorderLayout.CENTER);
		
		for (int i =0; i<numFrames;i++) {
			JInternalFrame jif = new JInternalFrame("Internal Frame" + frameCount, true, true, true, true);
			x = (int) (Math.random() * 100);
			y = (int) (Math.random() * 100);
			
			jif.setBounds(x, y, 250, 100);
			jif.setVisible(true);
			
			desktopPane.add(jif);
		}

//		Container contentPane = getContentPane();
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu windowMenu = new JMenu("Window");
		windowMenu.add(new OpenAllAction());
		windowMenu.add(new CloseAllAction());
		windowMenu.add(new CascadeAction());
		
		menuBar.add(windowMenu);
		
		return menuBar;
	}
	
	class OpenAllAction extends AbstractAction {
		public OpenAllAction() {
			super("Open All");
		}

		public void actionPerformed(ActionEvent e) {
			desktopPane.openAll();
		}
	}
	
	class CloseAllAction extends AbstractAction {
		public CloseAllAction() {
			super("Close All");
		}

		public void actionPerformed(ActionEvent e) {
			desktopPane.closeAll();
		}
	}
	
	class CascadeAction extends AbstractAction {
		public CascadeAction() {
			super("Cascade");
		}

		public void actionPerformed(ActionEvent e) {
			desktopPane.cascade();
		}
		
	}
	
	private CustomeDesktopPane desktopPane = new CustomeDesktopPane();
	private int frameCount = 1, numFrames = 5, x, y;
}

class CustomeDesktopPane extends JDesktopPane {
	private int xoffset = 20, yoffset = 20, w = 250, h = 350;

	public void closeAll() {
		JInternalFrame[] frames = getAllFrames();

		for (int i = 0; i < frames.length; i++) {
			if (!frames[i].isIcon()) {
				try {
					frames[i].setIcon(true);
				} catch (PropertyVetoException e) {
					System.out.println("iconification vetoed");
				}
			}
		}
	}

	public void openAll() {
		JInternalFrame[] frames = getAllFrames();

		for (int i = 0; i < frames.length; i++) {
			if (frames[i].isIcon()) {
				try {
					frames[i].setIcon(false);
				} catch (PropertyVetoException e) {
					System.out.println("restoration vetoed");
				}
			}
		}
	}

	public void cascade() {
		JInternalFrame[] frames = getAllFrames();
		int x = 0, y = 0;

		for (int i = 0; i < frames.length; i++) {
			if (!frames[i].isIcon()) {
				frames[i].setBounds(x, y, w, h);
				x += xoffset;
				y += yoffset;
			}
		}
	}
}
