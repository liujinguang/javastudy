package dp.thinkingInOO;

public class Plane extends Vehicle {

    @Override
    public void go(Address dest) {
        System.out.println("一路搧着翅膀去" + dest.getName());
    }
}
