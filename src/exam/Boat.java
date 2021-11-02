package exam;

public class Boat extends Vehicle{
    Boat(String productId, int weight) {
        super(productId, weight);
    }

    Boat(String productId) {
        super(productId);
    }

    @Override
    public void accelerate() {
        System.out.println("jet water");
    }

    @Override
    public void steerLeft() {
        System.out.println("turn tiller left");
    }

    @Override
    public void steerRight() {
        System.out.println("turn tiller right");
    }

    @Override
    public String toString() {
        return "Boat{productId='" + this.getProductId() + "', weight=" + this.getWeight() + "}";
    }

}
