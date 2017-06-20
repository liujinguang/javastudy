package jfc.ch15.example01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class InternalFrameTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameTest frame = new InternalFrameTest();
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
	public InternalFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Container contentPane = getContentPane();

		// JDesktopPane has a null layout manager by default
		desktopPane = new JDesktopPane();
		// System.out.println(desktopPane.getLayout());
		desktopPane.setLayout(new FlowLayout());
		desktopPane.setBackground(new Color(200, 200, 100));
		contentPane.add(desktopPane, BorderLayout.CENTER);

		button = new JButton("Make frame");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JInternalFrame jif = new JInternalFrame("Internal Frame" + windowCount++, true, true, true, true);
				jif.setPreferredSize(new Dimension(250, 100));
				jif.setVisible(true);
				desktopPane.add(jif);
				desktopPane.revalidate();

			}
		});
		contentPane.add(button, BorderLayout.NORTH);

	}

	private JButton button;
	private JDesktopPane desktopPane;
	private int windowCount = 1;

}
