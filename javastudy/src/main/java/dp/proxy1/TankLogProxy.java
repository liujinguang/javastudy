package dp.proxy1;

public class TankLogProxy implements Moveable {
	public TankLogProxy(Moveable m) {
		this.m = m;
	}

	public void move() {
		System.out.println("Tank Log start");
		m.move();
		System.out.println("Tank Log end");
	}

	private Moveable m;
}
