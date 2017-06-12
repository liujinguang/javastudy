package v1ch14.bounce;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/** The component that draws the balls
 * @author jliu
 *
 */
public class BallComponent extends JPanel {
	/**
	 * Add a ball to the component
	 * @param b
	 */
	public void add(Ball b) {
		balls.add(b);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //erase background
		Graphics2D g2 = (Graphics2D)g;
		for (Ball b : balls) {
			g2.fill(b.getShape());
		}
	}

	private ArrayList<Ball> balls = new ArrayList<Ball>();
}
