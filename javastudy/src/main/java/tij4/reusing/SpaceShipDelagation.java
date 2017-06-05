package tij4.reusing;

//使用代理时可以拥有更多的控制力，因为我们可以选择只提供在成员对象中的方法的某个子集
public class SpaceShipDelagation {
    public SpaceShipDelagation(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }
    
    @Override
    public String toString() {
        return name;
    }

    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
}
