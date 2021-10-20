package guess;
import java.util.List;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        final String FILE_NAME = "cities.txt";
        final int    MAX_GUESS = 10;

        String city = getCity(FILE_NAME);
        Question game = new Question(city, MAX_GUESS);
        //System.out.println(city);
        game.init();
    }

    private static String getCity(String path) {

        FileManager file = new FileManager();
        List<String> cities = file.load(path);

        Random number = new Random();
        int low = 0;
        int high = cities.size();
        int index = number.nextInt(high - low) + low;

        return cities.get(index);
    }
}