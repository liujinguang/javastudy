package v1ch14.bounceThread;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bounce extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new Bounce();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public Bounce() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Bounce");

		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "start", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});

		addButton(buttonPanel, "close", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		Ball ball = new Ball();
		comp.add(ball);

		Runnable runnable = new BallRunnable(ball, comp);
		Thread t = new Thread(runnable);
		t.start();
	}

	private BallComponent comp;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
}

class BallRunnable implements Runnable {

	public BallRunnable(Ball ball, Component comp) {
		super();
		this.ball = ball;
		this.comp = comp;
	}

	public void run() {
		try {
			for (int i = 0; i < STEPS; i++) {
				ball.move(comp.getBounds());
				comp.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	private Ball ball;
	private Component comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
}
