package tij4.reusing;

/****************** Exercise 1 *****************
 * Create a simple class. Inside a second class,
 * define a reference to an object of the first
 * class. Use lazy initialization to instantiate
 * this object.
 ***********************************************/

import static tij4.net.mindview.util.Print.*;

class Simple {
    public Simple(String si) {
        s = si;
    }

    void setString(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    private String s;
}

class Second {
    public Second(String si) {
        s = si; // 'simple' not initialized
    }

    public void check() {
        if (simple == null) {
            print("not initialized");
        } else {
            print("initialized");
        }
    }

    public Simple lazy() {
        if (simple == null) {
            print("Creating Simple");
            simple = new Simple(s);
        }

        return simple;
    }

    public Simple getSimple() {
        return lazy();
    }

    @Override
    public String toString() {
        return lazy().toString();
    }

    public void setSimple(String sNew) {
        lazy().setString(sNew);
    }

    private Simple simple;
    private String s;
}

public class E01Composition {
    public static void main(String args[]) {
        Second second = new Second("Init String");
        second.check();
        print(second.getSimple());
        second.check();
        print(second); // toString() call
        second.setSimple("New String");
        print(second);
    }
}
