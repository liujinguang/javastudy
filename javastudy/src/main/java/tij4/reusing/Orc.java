package tij4.reusing;

//the protected keyword

import static tij4.net.mindview.util.Print.*;

class Villain {
    public Villain(String name) {
        this.name = name;
    }

    protected void set(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }

    private String name;
}

public class Orc extends Villain {
    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name); // available because it's protected
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    private int orcNumber;
    
    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
}
