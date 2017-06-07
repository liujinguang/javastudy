package dp.factory;

import java.util.*;

public class Car implements Movable {

//    private Car() { //单例或多例
//
//    }
    public Car() {
        
    }

    public static Car getInstance() { //单例或静态工厂方法
        return car;
    }

    public void run() {
        System.out.println("Car冒着烟奔跑中...");
    }

    private static Car car = new Car();
    private static List<Car> cars = new ArrayList<Car>();//多例
}
