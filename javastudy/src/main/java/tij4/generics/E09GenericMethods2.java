package tij4.generics;


public class E09GenericMethods2 {
	public <A, B, C> void f(A a, B b, C c) {
		System.out.println(a.getClass().getSimpleName());
		System.out.println(b.getClass().getSimpleName());
		System.out.println(c.getClass().getSimpleName());
	}
	
	public <A, B> void g(A a, B b, Boolean c) {
		System.out.println(a.getClass().getSimpleName());
		System.out.println(b.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		E09GenericMethods2 gm = new E09GenericMethods2();
		gm.f("", 1, 2.0);
		System.out.println("===========================");
		gm.g(2.0f, gm, true);
	}
}
