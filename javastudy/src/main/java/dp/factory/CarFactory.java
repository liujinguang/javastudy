package dp.factory;

public class CarFactory extends VehicleFactory {
    public Car createCar() {
        return new Car();
    }

    @Override
    public Movable create() {
        return new Car();
    }
}
