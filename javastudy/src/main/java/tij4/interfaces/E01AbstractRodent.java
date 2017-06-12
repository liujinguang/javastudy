package interfaces;

import static net.mindview.util.Print.*;

public class E01AbstractRodent {
    public static void main(String args[]) {
        Rodent[] rodents = { 
                new Mouse(), 
                new Gerbil(), 
                new Hamster(), 
                };
        
        for (Rodent r : rodents) {
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
            print("========================");
        }
    }
}

abstract class Rodent {
    public abstract void hop();

    public abstract void scurry();

    public abstract void reproduce();
}

class Mouse extends Rodent {
    public void hop() {
        print("Mouse hopping");
    }

    public void scurry() {
        print("Mouse scurrying");
    }

    public void reproduce() {
        print("Making more Mice");
    }

    public String toString() {
        return "Mouse";
    }
}

class Gerbil extends Rodent {
    public void hop() {
        print("Gerbil hopping");
    }

    public void scurry() {
        print("Gerbil scurrying");
    }

    public void reproduce() {
        print("Making more Gerbils");
    }

    public String toString() {
        return "Gerbil";
    }
}

class Hamster extends Rodent {
    public void hop() {
        print("Hamster hopping");
    }

    public void scurry() {
        print("Hamster scurrying");
    }

    public void reproduce() {
        print("Making more Hamsters");
    }

    public String toString() {
        return "Hamster";
    }
}