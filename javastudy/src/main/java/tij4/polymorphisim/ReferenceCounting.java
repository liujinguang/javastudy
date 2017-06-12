package polymorphisim;

import static net.mindview.util.Print.*;

//cleaning up shared member objects

class Shared {
	public Shared() {
		print("Creating " + this);
	}

	public void addRef() {
		refcount++;
	}
	
	public long getRef() {
		return refcount;
	}

	protected void dispose() {
		print("Current refcount = " + refcount);
		if (--refcount == 0) {
			print("Disposing " + this);
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		print("Current refcount = " + refcount);
		if(refcount != 0)
			print("Error: object is not properly cleaned-up!");
	}

	@Override
	public String toString() {
		return "Shared " + id;
	}

	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;

}

class Composing {
	public Composing(Shared shared) {
		print("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}

	protected void dispose() {
		print("disposing " + this);
		shared.dispose();
	}

	@Override
	public String toString() {
		return "Composing " + id;
	}

	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
}

public class ReferenceCounting {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Composing[] composings = { new Composing(shared), new Composing(shared), new Composing(shared),
				new Composing(shared) };

		for (Composing c : composings) {
			c.dispose();
		}
		
		print("---------------------");
		
		System.gc();
		
		//verify failure
		new Composing(new Shared());
		System.gc();
	}

}
