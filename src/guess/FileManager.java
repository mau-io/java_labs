package guess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    List<String> rows = new ArrayList<>();

    public List<String> load(String fileName) {
        try {
            Scanner file = new Scanner(new File(fileName));

            while(file.hasNextLine()) {
                String row = file.nextLine();
                rows.add(row);
            }

            file.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }


}