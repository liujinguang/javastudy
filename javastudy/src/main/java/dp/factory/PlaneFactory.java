package dp.factory;

public class PlaneFactory extends VehicleFactory {
    public Plane createPlane() {
        return new Plane();
    }

    @Override
    public Movable create() {
        return new Plane();
    }
}
