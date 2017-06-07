package dp.abstractFactory;

public abstract class AbstractFactory {
    //create a serial of products
    public abstract Vehicle createVehicle() ;
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
