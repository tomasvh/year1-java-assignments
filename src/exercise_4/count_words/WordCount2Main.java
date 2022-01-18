package count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class WordCount2Main {

    public static void main(String[] args) {
        File originalText = new File("exercises/count_words/resources/words.txt");
        HashWordSet hashWordSet = new HashWordSet();
        TreeWordSet treeWordSet = new TreeWordSet();
        //TreeSet<Word> utilTree = new TreeSet<>();

        try {
            Scanner scan = new Scanner(originalText);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Word newWord = new Word(line);
                hashWordSet.add(newWord);
                treeWordSet.add(newWord);
                //utilTree.add(newWord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*
        System.out.println(hashWordSet.size());
        System.out.println(hashWordSet.toString());
        System.out.println(treeWordSet.size());
        System.out.println(treeWordSet.toString());

         */
        Iterator<Word> hashItr = hashWordSet.iterator();
        while (hashItr.hasNext()) {
            System.out.println(hashItr.next());
        }

        /*
        Iterator<Word> itr = utilTree.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

         */

        Iterator<Word> treeItr = treeWordSet.iterator();
        while (treeItr.hasNext()) {
            System.out.println(treeItr.next());
        }


    }
}
