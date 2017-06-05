package tij4.reusing;

//Composition with public objects

class Engine {
    public void start() {
    }

    public void stop() {
    }

    public void rev() {
    }
}

class Wheel {
    public void inflate(int psi) {
    }
}

class Window {
    public void rollup() {
    }

    public void rolldown() {
    }
}

class Door {
    public Window window = new Window();

    public void open() {
    }

    public void close() {
    }
}

public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door left = new Door(), right = new Door(); // 2-door

    public Car() {
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel();
        }
    }
    
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheels[0].inflate(72);
    }
}
