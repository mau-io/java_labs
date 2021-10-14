package lab1;

/**
 * @author Mauricio
 * @version 1.0
 */
public class Model {

    public static final int     INCHES_PER_FOOT = 12;
    public static final double  POUNDS_PER_KG   = 2.2046;
    public static final int     TALL_INCHES     = 67;
    public static final double  THIN_POUNDS     = 140.0;
    public static final int     BASE_RATE_DOLLARS_PER_HOUR        = 60;
    public static final int     TALL_THIN_BONUS_DOLLARS_PER_HOUR  = 5;
    public static final int     TRAVEL_BONUS_DOLLARS_PER_HOUR     = 4;
    public static final int     SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

    private static final  int MIN_NAME_LENGTH = 3;
    private static final  int MAX_NAME_LENGTH = 20;
    private static final  int MAX_HEIGHT_IN_INCHES = 84;
    private static final  int MIN_HEIGHT_IN_INCHES = 24;
    private static final  int MAX_WEIGHT_IN_POUNDS = 280;
    private static final  int MIN_WEIGHT_IN_POUNDS = 80;

    private String  firstName;
    private String  lastName;
    private int     height;
    private double  weight;
    private boolean canTravel   = false;
    private boolean smokes      = false;

    /**
     * Default constructor
     */
    public Model() {}

    /**
     *
     * @param firstName first name
     * @param lastName  last name
     * @param height    height in inches
     * @param weight    weight in pounds
     * @param canTravel can travel?
     * @param smokes    smokes?
     */
    public Model(
            String firstName,
            String lastName,
            int     height,
            double  weight,
            boolean canTravel,
            boolean smokes
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(canTravel);
        setSmokes(smokes);
    }

    /**
     * @param firstName first name
     * @param lastName last name
     * @param height height in inches
     * @param weight weight in pounds
     */
    public Model(
            String firstName,
            String lastName,
            int    height,
            double weight
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(false);
        setSmokes(false);
    }

    private static boolean isValidName(String name) {
        return name.length() > MIN_NAME_LENGTH && name.length() < MAX_NAME_LENGTH;
    }

    private static boolean isValidHeight(int height) {
        return height > MIN_HEIGHT_IN_INCHES && height < MAX_HEIGHT_IN_INCHES;
    }

    private static boolean isValidWeight(double weight) {
        return weight > MIN_WEIGHT_IN_POUNDS && weight < MAX_WEIGHT_IN_POUNDS;
    }

    /**
     * @return the value of first name
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(isValidName(firstName)){
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Invalid FirstName. The value must be " + MIN_NAME_LENGTH + " to "+ MAX_NAME_LENGTH + " characters.");
        }
    }

    /**
     * @return the value of last name
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(isValidName(lastName)){
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Invalid LastName. The value must be " + MIN_NAME_LENGTH + " to "+ MAX_NAME_LENGTH + " characters.");
        }
    }

    /**
     * @return the value of height in inches
     */
    public int getHeightInches() {
        return height;
    }

    public void setHeight(int inches) {
        if(isValidHeight(inches)){
            this.height = inches;
        }
        else {
            throw new IllegalArgumentException("Invalid Height. Height must be " + MIN_HEIGHT_IN_INCHES + " to "+ MAX_HEIGHT_IN_INCHES + " inches.");
        }
    }

    public void setHeight(int feet, int inches) {
        inches += feet * INCHES_PER_FOOT;
        if(isValidHeight(inches)){
            this.height = inches;
        }
        else {
            throw new IllegalArgumentException("Invalid Height. Height must be " + MIN_HEIGHT_IN_INCHES + " to "+ MAX_HEIGHT_IN_INCHES + " inches.");
        }
    }

    /**
     * @return the value of weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return the value of weight in Kg
     */
    public long getWeightKg() {
        return Math.round(weight / POUNDS_PER_KG);
    }

    public void setWeight(double pound) {
        if(isValidWeight(pound)){
            this.weight = pound;
        }
        else {
            throw new IllegalArgumentException("Invalid Weight. The value must be " +
                    MIN_WEIGHT_IN_POUNDS +
                    " to "+
                    MAX_WEIGHT_IN_POUNDS +
                    " pounds.");
        }
    }

    public void setWeight(long kilograms) {
        double weightInPounds = kilograms * POUNDS_PER_KG;
        if(isValidWeight(weightInPounds)){
            this.weight = weightInPounds;
        }
        else {
            throw new IllegalArgumentException("Invalid Weight. The value must be " +
                    (MIN_WEIGHT_IN_POUNDS * POUNDS_PER_KG) +
                    " to " +
                    (MAX_WEIGHT_IN_POUNDS * POUNDS_PER_KG) +
                    " Kg.");
        }
    }

    public boolean canTravel() {
        return canTravel;
    }

    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    public boolean isSmokes() {
        return smokes;
    }

    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }


    /**
     * Convert the height into feet and inches
     * e.g. "5 feet"
     * e.g. "5 feet 1 inch"
     * e.g. "5 feet 6 inches"
     * @return a string height with format (feet and inches)
     */
    public String getHeightInFeetAndInches() {

        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;

        String result = "";

        if((height % INCHES_PER_FOOT == 0)){
            result = String.format("%d feet", feet);
        }
        else {
           String inchesTitle = (height % INCHES_PER_FOOT == 1)
                   ? "inch"    // singular
                   : "inches"; // plural
            String.format("%d feet %d %s", feet, inches, inchesTitle);
        }

        return result;
    }

    /**
     * Calculates a model's per-hour pay rate and returns the amount. Everyone receives the
     * hourly BASE_RATE_DOLLARS_PER_HOUR. Tall, thin models (both tall and thin) receive an hourly bonus of TALL_THIN_BONUS_DOLLARS_PER_HOUR. Tall means
     * TALL_INCHES inches or more, thin means less than THIN_POUNDS pounds. Models
     * who are willing to travel receive an extra TRAVEL_BONUS_DOLLARS_PER_HOUR per
     * hour. However, models who smoke have SMOKER_DEDUCTION_DOLLARS_PER_HOUR per hour deducted from their pay.
     * @return per-hour pay rate
     */
    public int calculatePayDollarsPerHour() {

        int payDollarsPerHour = BASE_RATE_DOLLARS_PER_HOUR;

        if (height >= TALL_INCHES && weight < THIN_POUNDS) {
            payDollarsPerHour += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }

        if (canTravel()) {
            payDollarsPerHour += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }

        if (isSmokes()) {
            payDollarsPerHour -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }

        return payDollarsPerHour;

    }

    /**
     * Displays all the model's information on the screen.
     */
    public void printDetails() {
        System.out.println("Name: "   + getFirstName()    + " " + getLastName());
        System.out.println("Height: " + getHeightInches() + " inches");
        System.out.println("Weight: " + Math.round(getWeight()) + " pounds");

        if (canTravel()) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        if (isSmokes()) {
            System.out.println("Does smoke");
        } else {
            System.out.println("Does not smoke");
        }
    }

    /**
     * Displays details about the model.
     */
    public void displayModelDetails() {

        System.out.printf(
            "Name: %s %s \n" +
            "Height: %s \n" +
            "Weight: %.1f pounds \n" +
            "Travels: %s \n" +
            "Smokes: %s \n" +
            "Hourly rate: $%d \n",
            getFirstName(),
            getLastName(),
            getHeightInFeetAndInches(),
            getWeight(),
            canTravel() ? "yep" : "nope",
            isSmokes()    ? "yep" : "nope",
            calculatePayDollarsPerHour()
        );

    }


}