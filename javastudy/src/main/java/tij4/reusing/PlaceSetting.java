package tij4.reusing;

//combining composition & inheritance

import static tij4.net.mindview.util.Print.*;

class Plate {
    Plate(int i) {
        print("Plate constructor");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor");
    }
}

class Utensil {
    Utensil(int i) {
        print("Utensil constructor");
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        print("Spoon constructor");
    }
}

class Fork extends Utensil {
    Fork(int i) {
        super(i);
        print("Fork constructor");        
    }
}

class Knife extends Utensil {
    Knife(int i) {
        super(i);
        print("Knife constructor");        
    }
}

// A cultural way of doing something
class Custom {
    Custom(int i) {
        print("Custom constructor");
    }
}

public class PlaceSetting extends Custom {
    public PlaceSetting(int i) {
        super(i);
        sp = new Spoon(i+ 2);
        frk = new Fork(i+3);
        kn = new Knife(i+4);
        pl = new DinnerPlate(i+5);
        print("PlaceSetting constructor");
    }
    
    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
    
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;
}
