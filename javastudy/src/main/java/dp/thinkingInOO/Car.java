package dp.thinkingInOO;

public class Car extends Vehicle {

    @Override
    public void go(Address dest) {
        System.out.println("一路冒着烟去" + dest.getName());
    }
    
}
