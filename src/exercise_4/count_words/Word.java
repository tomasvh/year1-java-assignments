/**
 * Class for word
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @Version 1.0
 * */

package count_words;

public class Word implements Comparable<Word>  {

    private String word;

    /**Constructor with parameter
     * @param str String*/
    public Word(String str) {
        this.word = str;
    }
    /**Method for returning the String value of the word class
     * @return String
     * */
    public String toString() { return this.word; }

    /**Overridden method for hashcode using ASCII
     * @return int*/
    @Override
    public int hashCode() {
        int code = 0;
        for (int i = 0; i < this.word.length(); i++) {
            char c = this.word.toLowerCase().charAt(i);
            code += (int)c;
        }
        return code;
    }

    /**Overridden method for checking if a word equals another
     * @param other Object
     * @return boolean*/
    @Override
    public boolean equals(Object other) {
        return this.hashCode() == other.hashCode();
    }

    /**Overridden method for comparing one Word to another
     * @param word Word
     * @return int*/
    @Override
    public int compareTo(Word word) {
        return this.hashCode() - word.hashCode();
    }
}
