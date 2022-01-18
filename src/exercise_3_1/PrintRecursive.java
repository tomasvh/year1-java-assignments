/**Class for printing recursively and printing in reverse, recursively
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * @Reference: Slides*/

package exercise_1;

public class PrintRecursive {


    /**Method for printing a string
     * @param str String
     * @param index int*/
    public static void print (String str, int index) {
        if (index == str.length()) {

        } else {
            System.out.print(str.charAt(index));
            print(str, index+1);
        }
    }
    /**Method for printing a string in reverse
     * @param str String
     * @param index int*/
    public static void printReverse (String str, int index) {
        if (index == str.length()) {

        } else {
            printReverse(str, index+1);
            System.out.print(str.charAt(index));
        }
    }

    public static void main(String[] args) {

        String str = "Hello Everyone!";

        print(str, 0);
        System.out.println(); // Line break
        printReverse(str, 0);

    }

}
