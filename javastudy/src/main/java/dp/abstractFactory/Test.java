package dp.abstractFactory;

public class Test {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.run();
//        
//        AK47 ak = new AK47();
//        ak.shoot();
//        
//        Apple a = new Apple();
//        a.printName();
      
//      DefaultFactory factory = new DefaultFactory();
//      Car car = factory.createCar();
//      car.run();
//      
//      AK47 ak = factory.createAk47();
//      ak.shoot();
//      
//      Apple a = factory.createApple();
//      a.printName();
        
        
//        AbstractFactory factory = new MagicFactory();
        AbstractFactory factory = new DefaultFactory();
        Vehicle v = factory.createVehicle();
        v.run();
        Weapon w = factory.createWeapon();
        w.shoot();
        Food f = factory.createFood();
        f.printName();
    }
}
