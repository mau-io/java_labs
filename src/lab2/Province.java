package lab2;
import java.util.Arrays;

public class Province {

    private String name;       // e.g. “British Columbia”
    private String capital;    // e.g. “Victoria”
    private long   population; // e.g. 2264823

    private final String DEFAULT_PROVINCE   = "British Columbia";
    private final String DEFAULT_CAPITAL    = "Victoria";
    private final long   DEFAULT_POPULATION = 4_648_055;

    private final int MIN_POPULATION_VALUE = 30_000;
    private final int MAX_POPULATION_VALUE = 15_000_000;

    private final String[] PROVINCES_ALLOWED = {
            "Alberta",
            "British Columbia",
            "Manitoba",
            "New Brunswick",
            "Newfoundland and Labrador",
            "Nova Scotia",
            "Ontario",
            "Prince Edward Island",
            "Quebec",
            "Saskatchewan",
    };

    private final String[] CAPITALS_ALLOWED = {
            "Edmonton",
            "Victoria",
            "Winnipeg",
            "Fredericton",
            "St. John’s",
            "Halifax",
            "Toronto",
            "Charlottetown",
            "Québec",
            "Regina",
    };

    public Province() {
        setName(DEFAULT_PROVINCE);
        setCapital(DEFAULT_CAPITAL);
        setPopulation(DEFAULT_POPULATION);
    }

    public Province(String name, String capital, long population) {
        setName(name);
        setCapital(capital);
        setPopulation(population);
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public long getPopulation() {
        return this.population;
    }

    public void setName(String name) {
        if (isValidProvince(name)) {
            this.name = name;
        } else {
            this.name = DEFAULT_PROVINCE; // “British Columbia”
        }
    }

    public void setCapital(String capital) {
        if (isValidCapitalCity(capital)) {
            this.capital = capital;
        } else {
            this.capital = DEFAULT_CAPITAL; // “Victoria”
        }
    }

    public void setPopulation(long population) {
        if (isValidPopulation(population)) {
            this.population = population;
        } else {
            this.population = DEFAULT_POPULATION; // 4,648,055
        }
    }

    private boolean isValidPopulation(long population) {
        return population >= MIN_POPULATION_VALUE && population <= MAX_POPULATION_VALUE;
    }

    private boolean isValidProvince(String province) {
        return Arrays.asList(PROVINCES_ALLOWED).contains(province);
    }

    private boolean isValidCapitalCity(String capital) {
        return Arrays.asList(CAPITALS_ALLOWED).contains(capital);
    }

    // example
    // The capital of British Columbia (population. 4648055) is Victoria.
    public String getDetails() {
        return String.format("The capital of %s (population. %d) is %s.", getName(), getPopulation(), getCapital());
    }

}
