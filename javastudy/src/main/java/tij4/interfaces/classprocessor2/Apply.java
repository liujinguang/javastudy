package interfaces.classprocessor2;

import static net.mindview.util.Print.print;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using processor " + p.name());
        print(p.process(s));
    }
}
