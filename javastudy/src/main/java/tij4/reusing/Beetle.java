package tij4.reusing;
//the full process of initialization

import static tij4.net.mindview.util.Print.*;
import tij4.net.mindview.util.Print;

class Insect {
    public Insect() {
        print("i = " + i + ", j" + j);
        j = 39;
        // TODO Auto-generated constructor stub
    }
    static int printInit(String s) {
        print(s);
        return 47;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    protected int j;
    private int i = 9;
}

public class Beetle extends Insect {
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    
    private int k = printInit("Beetle.k initialized");
    private static int x2 = printInit("static Beetle.x2 initialized");
    
    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle beetle = new Beetle();
    }
}
