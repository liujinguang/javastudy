package interfaces;

/****************** Exercise 2 *****************
* Create a class as abstract without including
* any abstract methods, and verify that you
* cannot create any instances of that class.
***********************************************/

abstract class NoAbstractMethods {
    void f() {
        System.out.println("f()");
    }
}

public class E02Abstract {
    public static void main(String args[]) {
//        new NoAbstractMethods();
    }
}
