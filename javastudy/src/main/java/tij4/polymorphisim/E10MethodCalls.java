package polymorphisim;

/****************** Exercise 10 *****************
* Create a base class with two methods. In the
* first method, call the second method. Inherit
* a class and override the second method. Create
* an object of the derived class, upcast it to
* the base type, and call the first method.
* Explain what happens.
***********************************************/


/*The first method isn¡¯t overridden, but it calls the second method, which is. Java
always uses the most-derived method for the object type; this is very powerful
(and may surprise the unaware). The Template Method design pattern makes
heavy use of polymorphism. (See Thinking in Patterns with Java at
www.MindView.net.)
*/

class TwoMethods {
	public void m1() {
		System.out.println("Inside m1, calling m2");
		
		m2();
	}
	
	public void m2() {
		System.out.println("Inside m2");
	}
}

class Inherited extends TwoMethods {
	@Override
	public void m2() {
		System.out.println("Inside Inherited.m2");
		super.m2();
	}
}

public class E10MethodCalls {
	public static void main(String[] args) {
		TwoMethods methods = new Inherited();
		methods.m1();
	}
}
