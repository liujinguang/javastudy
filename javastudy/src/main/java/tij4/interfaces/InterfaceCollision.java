package tij4.interfaces;

interface I1 {
	void f();
}

interface I2 {
	int f(int i);
}

interface I3 {
	int f();
}

class C {
	public int f() {
		return 1;
	}
}

class C2 implements I1, I2 {

	public int f(int i) {
		return 0;
	}

	public void f() {  //OVERLOAD
		
	}
	
}

class C3 extends C implements I2 {

	public int f(int i) { //overload
		return 0;
	}
	
}

class C4 extends C implements I3 {
	public int f(int i) { //Identical, no problem
		return 1;
	}
}

//interface I4 extends I1, I3 {}
//class C5 extends C implements I1 {
//	
//}

public class InterfaceCollision {

}
