/**
 * Euclidean Algorithm(greatest common divisor) implementation
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @Inspiration and walkthrough from: https://www.baeldung.com/java-greatest-common-divisor
 *
 * version 1.0.
 * */

package exercise_5;

import java.util.Scanner;

public class EuclideanMain {

    /**
     * The actual recursive implementation
     *
     * @param lower int
     * @param higher int
     * return GCD int
     * */
    public static int GCD(int lower, int higher) {
        if (higher == 0) {
            return lower;
        }
        return GCD(higher, lower % higher);
    }

    /**
     * Main executing method with scanner
     * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the first number");
        int lower = scan.nextInt();
        System.out.println("Choose the second number");
        int higher = scan.nextInt();

        System.out.println(GCD(lower, higher));
    }
}
