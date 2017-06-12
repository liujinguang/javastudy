package interfaces.classprocessor;

import static net.mindview.util.Print.print;

import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Apply {
    //创建一个能够根据所传递的参数对象不同而具有不同行为的方法，被称为策略设计模式
    public static void process(Processor p, Object s) {
        print("Using processor " + p.name());
        print(p.process(s));
    }

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";
}
