package miniproject2;

import java.util.Scanner;

public class InputCollector {
    public static Scanner reader = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        String input = reader.nextLine();
        return input;
    }
}
