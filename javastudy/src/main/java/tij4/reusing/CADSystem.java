package tij4.reusing;

//ensuring proper cleanup

import static tij4.net.mindview.util.Print.*;

class Shape {
    Shape(int i) {
        print("Shape constructor");
    }

    void dispose() {
        print("Shape dispose");
    }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        print("Drawing Circle");
    }

    void dispose() {
        print("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        print("Drawing Triangle");
    }

    void dispose() {
        print("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Drawing Line: " + start + ", " + end);
    }

    void dispose() {
        print("Erasing Line: " + start + ", " + end);
        super.dispose();
    }

    private int start, end;

}

public class CADSystem extends Shape {
    public CADSystem(int i) {
        super(i + 1);
        for (int j=0; j<lines.length; j++) {
            lines[j] = new Line(j, j*j);
        }
        
        c = new Circle(1);
        t = new Triangle(1);
        print("Combined constructor");
    }
    
    public void dispose() {
        print("CADSystem.dispose()");
        
        //the order of cleanup is the reverse of the order of initialization 
        t.dispose();
        c.dispose();
        for (int j = lines.length-1; j>=0; j--) {
            lines[j].dispose();
        }
        super.dispose();
    }
    
    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        
        try {
            // code and exception handling
        } finally {
            x.dispose();
        }
    }

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
}
