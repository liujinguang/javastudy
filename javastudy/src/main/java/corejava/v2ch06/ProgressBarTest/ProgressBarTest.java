package v2ch06.ProgressBarTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class ProgressBarTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new ProgressBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

/**
 * A frame that contains a button to launch a simulated activity, a progress
 * bar, and a text area for the activity output.
 * @author jliu
 *
 */
class ProgressBarFrame extends JFrame {
	
	public ProgressBarFrame() {
		setTitle("ProgressBarTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		//this text area holds the activity output
		textArea = new JTextArea();
		
		//set up a panel with button and progress bar
		final int MAX = 100;
		JPanel panel = new JPanel();
		startButton = new JButton("Start");
		progressBar = new JProgressBar(0, MAX);
		progressBar.setStringPainted(true);
		panel.add(startButton);
		panel.add(progressBar);
		
		checkBox = new JCheckBox("indeterminate");
		checkBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				progressBar.setIndeterminate(checkBox.isSelected());
				progressBar.setStringPainted(!progressBar.isIndeterminate());
			}
		});
		panel.add(checkBox);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				activity = new SimulateActivity(MAX);
				activity.execute();
			}
		});
	}
	
	private JButton startButton;
	private JProgressBar progressBar;
	private JCheckBox checkBox;
	private JTextArea textArea;
	private SimulateActivity activity;
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;

	class SimulateActivity extends SwingWorker<Void, Integer> {
		
		public SimulateActivity(int t) {
			current = 0;
			target = t;
		}

		@Override
		protected Void doInBackground() throws Exception {
			try {
				while (current < target) {
					Thread.sleep(100);
					current++;
					publish(current);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void done() {
			startButton.setEnabled(true);
		}

		@Override
		protected void process(List<Integer> chunks) {
			for (Integer chunk:chunks) {
				textArea.append(chunk + "\n");
				progressBar.setValue(chunk);
			}
		}

		private int current;
		private int target;
	}
}
