package tij4.generics;

public class Holder3<T> {
	
	public Holder3(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

	public void set(T a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile automobile = h3.get();
	}

	private T a;
}
