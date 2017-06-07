package dp.proxy1;

import java.util.Random;

public class TankTimeProxy implements Moveable {

	public TankTimeProxy(Moveable m) {
		this.m = m;
	}

	public void move() {
		long start = System.currentTimeMillis();
		
		System.out.println("Tank time start");
		
		m.move();
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println("Time: " + (end - start));
	}

	private Moveable m;
}
