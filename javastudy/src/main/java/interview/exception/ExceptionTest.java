package interview.exception;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		try {
			try {
				throw new Sneeze();
			} catch (Annoyance e) {
				System.out.println("Caught Annoyance");
				
				throw e;
			}
		} catch (Sneeze e) {
			System.out.println("Caught Sneeze");
			
			return;
		} finally {
			System.out.println("hello world");
		}
	}

}
