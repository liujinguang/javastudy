package v1ch11.ConsoleWindow;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConsoleWindowTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				ButtonFrame frame = new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

				// initialize the console window--system.out will show here
				ConsoleWindow.init();
			}
		});
	}
}

class ButtonFrame extends JFrame {
	public ButtonFrame() {
		setTitle("ButtonTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add panel to frame

		ButtonPanel panel = new ButtonPanel();
		add(panel);
	}

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
}

/**
 * A panel with three button
 * 
 * @author jliu
 *
 */
class ButtonPanel extends JPanel {
	public ButtonPanel() {
		// create buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");

		// add buttons to panel
		add(yellowButton);
		add(blueButton);
		add(redButton);

		// create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);

		// associate actions with buttons
		yellowButton.addActionListener(yellowAction);
		;
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}

	private class ColorAction implements ActionListener {

		public ColorAction(Color c) {
			backgroundColor = c;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println(e); // shows in console window
			setBackground(backgroundColor);
		}

		private Color backgroundColor;
	}
}
