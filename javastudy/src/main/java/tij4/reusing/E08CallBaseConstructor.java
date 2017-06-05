package tij4.reusing;

//: reusing/E08_CallBaseConstructor.java
/****************** Exercise 8 *****************
* Create a base class with only a non-default
* constructor, and a derived class with both a
* default (no-arg) and non-default constructor.
* Call the base-class constructor in the
* derived-class constructors.
* Implicit super constructor BaseNonDefault() is undefined. 
* Must explicitly invoke another constructor
***********************************************/

import static tij4.net.mindview.util.Print.*;

class BaseNonDefault {
	BaseNonDefault(int i) {
		print("BaseNonDefault constructor");
	}
}

class DerivedTwoConstructors extends BaseNonDefault {
	public DerivedTwoConstructors() {
		super(0);
		print("DerivedTwoConstructors default constructor");
	}

	public DerivedTwoConstructors(int i) {
		super(i);
		print("DerivedTwoConstructors implicate constructor");
	}
}

public class E08CallBaseConstructor {
	public static void main(String[] args) {
		DerivedTwoConstructors d = new DerivedTwoConstructors();
		print("============================");
		DerivedTwoConstructors d2 = new DerivedTwoConstructors(10);
	}
}
