package tij4.reusing;

/******************
 * Exercise 17 ***************** Modify Exercise 16 so Frog overrides the method
 * definitions from the base class (provides new definitions using the same
 * method signatures). Note what happens in main().
 ***********************************************/
class Frog2 extends Amphibian {
    public void moveInWater() {
        System.out.println("Frog swimming");
    }

    public void moveOnLand() {
        System.out.println("Frog jumping");
    }
}

public class E17Frog2 {
    public static void main(String args[]) {
        Amphibian a = new Frog2();
        a.moveInWater();
        a.moveOnLand();
    }
}

/*
 * Since the compiler has a reference to an Amphibian, you might guess it will
 * call the Amphibian methods. Instead, it calls the Frog2 methods. Since a is
 * indeed a reference to a Frog2, this is the appropriate result. That’s
 * polymorphism: The right behavior happens even if you are talking to a
 * base-class reference.
 */