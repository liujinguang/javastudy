package dp.abstractFactory;

public class DefaultFactory extends AbstractFactory {
    public Car createCar() {
        return new Car();
    }
    
    public AK47 createAk47() {
        return new AK47();
    }
    
    public Apple createApple() {
        return new Apple();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
