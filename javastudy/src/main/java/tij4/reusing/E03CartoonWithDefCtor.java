package tij4.reusing;

import static tij4.net.mindview.util.Print.*;

//: reusing/E03_CartoonWithDefCtor.java
/****************** Exercise 3 ******************
* Even if you don't create a constructor for
* Cartoon(), the compiler will synthesize a
* default constructor that calls the base-class
* constructor. Prove that assertion.
***********************************************/

class CartoonWithDefCtor extends Drawing {
//	CartoonWithDefCtor() {
//		print("CartoonWithDefCtor constructor");
//	}
}

public class E03CartoonWithDefCtor {
	public static void main(String[] args) {
		CartoonWithDefCtor cartoon = new CartoonWithDefCtor();
	}
}
