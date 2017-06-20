package jfc.ch15.example02;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class InternalFrameEventTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameEventTest frame = new InternalFrameEventTest();
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
	public InternalFrameEventTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		Container contentPane = getContentPane();

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setLayout(new FlowLayout());
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JInternalFrame jif = new JInternalFrame("An internal frame", true, true, true, true);
		jif.setPreferredSize(new Dimension(300, 200));
		jif.addInternalFrameListener(new InternalFrameListener() {
			
			public void internalFrameOpened(InternalFrameEvent e) {
				System.out.println("Opened");
			}
			
			public void internalFrameIconified(InternalFrameEvent e) {
				System.out.println("Iconified");
			}
			
			public void internalFrameDeiconified(InternalFrameEvent e) {
				System.out.println("Deiconified");
			}
			
			public void internalFrameDeactivated(InternalFrameEvent e) {
				System.out.println("Deactivated");
			}
			
			public void internalFrameClosing(InternalFrameEvent e) {
				System.out.println("Closing");
			}
			
			public void internalFrameClosed(InternalFrameEvent e) {
				System.out.println("Closed");
			}
			
			public void internalFrameActivated(InternalFrameEvent e) {
				System.out.println("Activated");
			}
		});
		jif.setVisible(true);
		
		desktopPane.add(jif);
	}

}
