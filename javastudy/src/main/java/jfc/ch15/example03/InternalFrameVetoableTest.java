package jfc.ch15.example03;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import jfc.ch15.example02.InternalFrameEventTest;

public class InternalFrameVetoableTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameVetoableTest frame = new InternalFrameVetoableTest();
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
	public InternalFrameVetoableTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		Container contentPane = getContentPane();
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setLayout(new FlowLayout());
		contentPane.add(desktopPane, BorderLayout.CENTER);

		final JInternalFrame jif = new JInternalFrame("Some Editor", false, true);
		jif.setPreferredSize(new Dimension(300, 250));
		jif.setVisible(true);
		jif.setFrameIcon(new ImageIcon(InternalFrameEventTest.class.getResource("print.gif")));
		jif.addVetoableChangeListener(new VetoableChangeListener() {

			public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
				System.out.println("vetoableChange event");
				String name = evt.getPropertyName();

				if (name.equals(JInternalFrame.IS_CLOSED_PROPERTY)) {
					Component internalFrame = (Component) evt.getSource();
					Boolean oldValue = (Boolean) evt.getOldValue();
					Boolean newValue = (Boolean) evt.getNewValue();

					if (oldValue == Boolean.FALSE && newValue == Boolean.TRUE) {
						int answer = JOptionPane.showConfirmDialog(jif, "Save Changes?", "Unsaved Changes",
								JOptionPane.YES_NO_CANCEL_OPTION);
						
						if (answer == JOptionPane.CANCEL_OPTION) {
							throw new PropertyVetoException("close cancelled", evt);
						}
					}
				}
			}
		});
		desktopPane.add(jif);
	}

}
