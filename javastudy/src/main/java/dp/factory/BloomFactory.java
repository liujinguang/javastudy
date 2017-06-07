package dp.factory;

public class BloomFactory extends VehicleFactory {

    @Override
    public Movable create() {
        return new Bloom();
    }

}
