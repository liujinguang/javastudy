package tij4.reusing;

import static tij4.net.mindview.util.Print.*;

public class E11DetergentDelegation {

    //Delegated methods
    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        append(" DetergentDelegation.scrub()");
        cleanser.scrub();
    }
    
    public void foam() {
        append(" foam()");
    }
    
    @Override
    public String toString() {
        return cleanser.toString();
    }
    
    private Cleanser cleanser = new Cleanser();
    
    public static void main(String[] args) {
        E11DetergentDelegation x = new E11DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
}
