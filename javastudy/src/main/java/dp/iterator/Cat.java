package dp.iterator;

public class Cat {
    public Cat(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Cat: " + id;
    }

    private int id;
}
