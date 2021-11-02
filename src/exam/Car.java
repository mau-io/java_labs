package exam;

public class Car extends Vehicle {

    private boolean isLeftHandDriving;

    Car(String productId, Integer weight, boolean isLeftHandDriving) {
        super(productId, weight);
        setLeftHandDriving(isLeftHandDriving);
    }

    public boolean getIsLeftHandDriving() {
        return isLeftHandDriving;
    }
    public void setLeftHandDriving(boolean leftHandDriving) {
        isLeftHandDriving = leftHandDriving;
    }

    @Override
    public void accelerate() {
        if(this.weight == null) {
            System.out.println("there’s something wrong");
        } else {
            System.out.println("fire pistons, turn wheels");
        }
    }

    @Override
    public void steerLeft() {
        System.out.println("turn wheels left");
    }

    @Override
    public void steerRight() {
        System.out.println("turn wheels right");
    }

    @Override
    public String toString() {
        return "Car{productId='" + this.getProductId() + "', weight=" + this.getWeight() + ", isLeftHandDriving=" + this.getIsLeftHandDriving() + "}";
    }
}
