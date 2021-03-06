package v1ch02.WelcomeApplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomeApplet extends Applet {
	@Override
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				setLayout(new BorderLayout());
				
				JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
				label.setFont(new Font("Serif", Font.BOLD, 18));
				add(label, BorderLayout.CENTER);
				
				JPanel panel = new JPanel();
				JButton cayButton = new JButton("Cay Horstmann");
				cayButton.addActionListener(makeAction("http://www.horstmann.com"));
				
				JButton garyButton = new JButton("Gary Cornell");
				garyButton.addActionListener(makeAction("mailto:gary_cornell@apress.com"));
				
				add(panel, BorderLayout.SOUTH);
				
			}
		});
	}
	
	private ActionListener makeAction(final String urlString) {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					getAppletContext().showDocument(new URL(urlString));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				
			}
		};
	}
}
