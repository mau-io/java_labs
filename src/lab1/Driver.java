package lab1;

public class Driver {

    public static void main(String[] args) {
        try {
            Model person1 = new Model();
            person1.printDetails();

            Model person2 = new Model("Mauricio", "Albert", 75, 82, true, false);
            person2.displayModelDetails();
            person2.printDetails();

            Model person3 = new Model("Mauricio", "Albert", 70, 80.80);
            person3.displayModelDetails();
            person3.printDetails();
        }
        catch (IllegalArgumentException e) {
            System.out.printf("---> " + e);
        }
    }
}
