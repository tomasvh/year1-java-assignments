package count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {



    public static void main(String[] args) {
        File originalText = new File("exercises/count_words/resources/words.txt");
        HashSet<Word> wordHashSet = new HashSet<>();
        TreeSet<Word> wordTreeSet = new TreeSet<>();
        try {
            Scanner scan = new Scanner(originalText);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Word newWord = new Word(line);
                wordHashSet.add(newWord);
                wordTreeSet.add(newWord);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(wordHashSet.size());
        System.out.println(wordTreeSet.size());
    }
}