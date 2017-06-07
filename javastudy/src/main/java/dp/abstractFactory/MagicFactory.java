package dp.abstractFactory;

public class MagicFactory extends AbstractFactory {
    public Bloom createBloom()  {
        return new Bloom();
    }
    
    public MagicStick createMagicStick(){
        return new MagicStick();
    }
    
    public MushRoom createMushRoom() {
        return new MushRoom();
    }

    @Override
    public Vehicle createVehicle() {
        return new Bloom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food createFood() {
        return new MushRoom();
    }
}
