package dp.thinkingInOO;

public class Driver {

    public Driver(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void drive(Car c, Address address) {
        c.go(address);
    }

    private String name;

}
