package dp.thinkingInOO;

public class Bloom extends Vehicle {

    @Override
    public void go(Address dest) {
        System.out.println("一路扫着土去" + dest.getName());
    }

}
