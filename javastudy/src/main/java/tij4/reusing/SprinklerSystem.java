package tij4.reusing;

//Composition for code reuse
class WaterSource {
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }

    private String s;
}

public class SprinklerSystem {
    @Override
    public String toString() {
        return "valve1 = " + value1 + " " + "valve2 = " + value2 + " "
                + "valve3 = " + value3 + " " + "valve4 = " + value4 + "\n"
                + "i = " + i + " " + "f = " + f + " " + "source = " + source;
    }

    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}

//类中域为基本类型时能够自动初始化为令，但是对象引用会被初始化为null