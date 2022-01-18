package count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IdentyfyWordsMain {



    public static void main(String[] args) {
        ArrayList<String> wordArrayList = new ArrayList<>();
        File originalText = new File("exercises/count_words/resources/HistoryOfProgramming.txt");
        try {
            Scanner scan = new Scanner(originalText);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] words = line.split("[\\d \n\t\r\".,;:!*?(){]");

                wordArrayList.addAll(Arrays.asList(words));
                wordArrayList.removeIf(element -> element.isBlank() || element.length() < 2);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            File newWordFile = new File("exercises/count_words/resources/words.txt");
            if (newWordFile.createNewFile()) {
                System.out.println("File created: " + newWordFile.getName());
                try {
                    PrintWriter out = new PrintWriter("exercises/count_words/resources/words.txt");
                    for (String e:wordArrayList
                    ) {
                        out.println(e);

                    }
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
