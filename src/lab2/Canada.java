package lab2;

public class Canada {
    private Province[] provinces;

    public Canada() {
        this.provinces = new Province[] {
                new Province("Alberta", "Edmonton", 4_067_175),
                new Province("British Columbia", "Victoria", 4_648_055),
                new Province("Manitoba", "Winnipeg", 1_278_365),
                new Province("New Brunswick", "Fredericton", 747_101),
                new Province("Newfoundland and Labrador","St. John's",  519_716),
                new Province("Nova Scotia", "Halifax", 923_598),
                new Province("Ontario", "Toronto", 13_448_494),
                new Province("Prince Edward Island","Charlottetown", 142_907),
                new Province("Quebec", "Quebec", 8_164_361),
                new Province("Saskatchewan", "Regina", 1_098_352)
        };
    }

    /**
     * Which loops through the array and prints each Province object’s getDetails() method.
     */
    public void displayAllProvinces() {
        for (Province province : provinces) {
            System.out.println(province.getDetails());
        }
    }

    /**
     * which takes the population in millions (e.g. 4, 6)
     * @param min
     * @param max
     * @return the number of Provinces with the populations in that range (e.g. 4-6 million, inclusive).
     */
    public int getNumOfProvincesBetween(int min, int max) {
        long MIN = min * 1_000_000;
        long MAX = max * 1_000_000;
        int count = 0;

        for (Province province : provinces) {
            if (
                province.getPopulation() >= MIN &&
                province.getPopulation() <= MAX
            ) {
                count++;
            }
        }
        return count;
    }

}
