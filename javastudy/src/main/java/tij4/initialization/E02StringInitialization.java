package initialization;

import java.awt.print.Printable;

/******************
 * Exercise 2 ***************** Create a class with a String field initialized
 * at the point of definition, and another one initialized by the constructor.
 * What is the difference between the two approaches?
 ***********************************************/

public class E02StringInitialization {
    private String s1 = "Initialized at definition";
    private String s2;

    E02StringInitialization(String s2i) {
        s2 = s2i;
    }

    public static void main(String[] args) {
        E02StringInitialization si = new E02StringInitialization(
                "Initialized at construction");
        System.out.println("si.s1 = " + si.s1);
        System.out.println("si.s2 = " + si.s2);
    }
}

/*
 * The s1 field is initialized before the constructor is entered; technically,
 * so is the s2 field, which is set to null as the object is created. The more
 * flexible s2 field lets you choose what value to give it when you call the
 * constructor, whereas s1 always has the same value.
 */
