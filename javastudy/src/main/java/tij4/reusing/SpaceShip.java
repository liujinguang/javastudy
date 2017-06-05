package tij4.reusing;

public class SpaceShip extends SpaceShipControls {
	public SpaceShip(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	private String name;
	
	public static void main(String[] args) {
		SpaceShip protector = new SpaceShip("NSEA protector");
		protector.forward(100);
	}
}
