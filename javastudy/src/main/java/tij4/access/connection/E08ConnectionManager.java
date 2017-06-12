package access.connection;

public class E08ConnectionManager {
	public static void main(String args[]) {
		Connection c = ConnectionManager.getConnection();
		while (c != null) {
			System.out.println(c);
			c.doSomething();
			c = ConnectionManager.getConnection();
		}
	}
}
