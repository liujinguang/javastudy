package v1ch14.SwingThreadTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingThreadTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				JFrame frame = new SwingThreadFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SwingThreadFrame extends JFrame {
	public SwingThreadFrame() {
		setTitle("SwingThreadTest");
		
		final JComboBox<Integer> combo = new JComboBox<Integer>();
		combo.insertItemAt(Integer.MAX_VALUE, 0);
		combo.setPrototypeDisplayValue(combo.getItemAt(0));
		combo.setSelectedIndex(0);
		
		JPanel panel = new JPanel();
		
		JButton goodButton = new JButton("Good");
		goodButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Thread(new GoodWorkerRunnable(combo)).start();
			}
		});
		panel.add(goodButton);
		
		JButton badButton = new JButton("Bad");
		badButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new Thread(new BadWorkerRunnable(combo)).start();
			}
		});
		panel.add(badButton);
		
		panel.add(combo);
		add(panel);
		pack();
	}
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers,
 * This can result in errors because the combo box methods are not synchronized
 * and both the worker thread and the event dispatch the thread access the combo
 * box.
 * @author jliu
 *
 */
class BadWorkerRunnable implements Runnable {

	public BadWorkerRunnable(JComboBox<Integer> combo) {
		super();
		this.combo = combo;
		generator = new Random();
	}

	public void run() {
		try {
			while (true) {
				int i = Math.abs(generator.nextInt());
				if (i % 2 == 0) {
					combo.insertItemAt(i, 0);
				} else if (combo.getItemCount() > 0) {
					combo.removeItemAt(i % combo.getItemCount());
				}

				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private JComboBox<Integer> combo;
	private Random generator;
}

/**
 * This runnable modifies a combox by randomly adding and removing number, in
 * order to ensure that the combo box is not corrupted, the editing operations
 * are forwarded to the event dispatch thread.
 * 
 * @author jliu
 *
 */
class GoodWorkerRunnable implements Runnable {

	public GoodWorkerRunnable(JComboBox<Integer> combo) {
		super();
		this.combo = combo;
		generator = new Random();
	}

	public void run() {
		try {
			while (true) {
				EventQueue.invokeLater(new Runnable() {

					public void run() {
						int i = Math.abs(generator.nextInt());
						if (i % 2 == 0) {
							combo.insertItemAt(i, 0);
						} else if (combo.getItemCount() > 0) {
							combo.removeItemAt(i % combo.getItemCount());
						}
					}
				});
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private JComboBox<Integer> combo;
	private Random generator;
}