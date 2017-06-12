package access.connection;

public class Connection {
	Connection() { //package access
	}
	
	@Override
	public String toString() {
		return "Connection " + id;
	}
	
	public void doSomething() {}
	
	private int id = counter++;
	private static int counter = 0;
}
