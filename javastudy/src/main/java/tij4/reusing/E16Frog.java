package tij4.reusing;

/*******************
 * Exercise 16 ***************** Create a class called Amphibian. From it,
 * inherit a class from it called Frog. Put appropriate methods in the base
 * class. In main(), create a Frog, upcast it to Amphibian, and demonstrate that
 * all the methods still work.
 ***********************************************/

class Amphibian {
    public void moveInWater() {
        System.out.println("Moving in Water");
    }

    public void moveOnLand() {
        System.out.println("Moving on Land");
    }
}

class Frog extends Amphibian {
}

public class E16Frog {
    public static void main(String args[]) {
        Amphibian a = new Frog();
        a.moveInWater();
        a.moveOnLand();
    }
}
