package access.connection2;

public class Connection {
	Connection() { // package access
	}

	@Override
	public String toString() {
		return "Connection " + id;
	}

	public void doSomething() {
	}
	
	public void checkIn() {
		ConnectionManager.checkIn(this);
	}

	private int id = counter++;
	private static int counter = 0;
}
