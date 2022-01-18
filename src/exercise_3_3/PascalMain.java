/**Class for printing a specific row of the Pascal Triangle
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0*/

package exercise_3;

import java.util.Scanner;

public class PascalMain {




    /**method for creating a row of the Pascal Triangle
     * @param row int(for which row)*/
    public static int[] pascalRow(int row) {

        int [] newRow = new int[row+1];
        if (row == 0) {
           newRow[0] = 1; //if row is 0, the first one is 1 (base cases)
           return newRow;
        } else {
            newRow[0] = 1; //if row is 1, its 11 (base cases)

            int [] previousLine = pascalRow(row - 1);  //recursive for giving the middle element the sum of the left and above number
            for (int i = 1; i < row; i++) {
                newRow[i] = previousLine[i-1] + previousLine[i];

            }
            newRow[row] = 1;
            return newRow;

        }


    }

    /**Method for printing the row
     * @param row int[] */
    public static String printRow(int [] row) {
        StringBuilder strb = new StringBuilder();
        for (int element: row
             ) { strb.append(element).append(" ");

        }
        return strb.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Which row of the Pascal triangle do you want to print?");
        int chosenRow = scan.nextInt();
        System.out.println(printRow(pascalRow(chosenRow)));
    }
}
