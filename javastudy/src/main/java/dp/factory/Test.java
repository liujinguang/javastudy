package dp.factory;

public class Test {
    public static void main(String[] args) {
//        Car car1 = Car.getInstance();
//        Car car2 = Car.getInstance();
//        if (car1 == car2) {
//            System.out.println("Same car!");
//        }
        
//        Movable m = new Plane();
//        m.run();
        //step 1: factory--->abstract factory
//        PlaneFactory factory = new PlaneFactory();
//        Movable m = factory.createPlane();
        VehicleFactory factory = new PlaneFactory();
        Movable m = factory.create();
        m.run();
    }
}

//          Movable                VihecleFactory
//          /     \                    /       \
//         /       \                 \/         \/
//        Car     Plane           CarFactory   PlaneFactory
// 工厂模式：产品方面比较容易扩展                        缺点工厂泛滥
// 抽象工厂：产品系列，                                            缺点新产品品种支持费劲，增加接口
