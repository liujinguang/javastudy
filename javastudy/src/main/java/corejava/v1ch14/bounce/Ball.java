package v1ch14.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	/**
	 * Move the ball to the next position, reversing it position if it hits one
	 * of its edges.
	 * 
	 * @param bound
	 */
	public void move(Rectangle2D bound) {
		x += dx;
		y += dy;

		if (x < bound.getMinX()) {
			x = bound.getMinX();
			dx = -dx;
		}

		if (x + XSIZE >= bound.getMaxX()) {
			x = bound.getMaxX() - XSIZE;
			dx = -dx;
		}

		if (y < bound.getMinY()) {
			y = bound.getMinY();
			dy = -dy;
		}

		if (y + YSIZE >= bound.getMaxY()) {
			y = bound.getMaxY() - YSIZE;
			dy = -dy;
		}
	}

	/**
	 * Get the shape of the ball at its current position
	 * 
	 * @return
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}

	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0, y = 0;
	private double dx = 1, dy = 1;
}
