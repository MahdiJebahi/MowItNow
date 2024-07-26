import entities.Lawn;
import entities.Mower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/resources/inputFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String[] collection = reader.readLine().split(" ");
            Lawn lawn = new Lawn(Integer.parseInt(collection[0]), Integer.parseInt(collection[1]));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                Mower mower = new Mower(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2].charAt(0), lawn);
                String sequence = tokens[3];
                mower.move(sequence);
                System.out.println(mower.getPosition());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}