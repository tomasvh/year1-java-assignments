/**Main executing method for Time measurement
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package time;

import java.util.Comparator;
import java.util.Random;

public class TimeMeasurementMain {


    /** Insertion sort implementation from Assignment-3*/
    private static void insertionSortRecursive(int[] input, int inputLength) {
        if (inputLength <= 1) {
            return;
        }
        insertionSortRecursive(input, inputLength - 1);
        int key = input[inputLength - 1];
        int j = inputLength - 2;
        while (j >= 0 && input[j] > key) {
            input[j + 1] = input[j];
            j = j - 1;
        }
        input[j + 1] = key;
    }

    /** Insertion sort implementation from Assignment-3*/
    public static int[] insertionSort(int[] in) {
        int [] newArray = in.clone();
        insertionSortRecursive(newArray, newArray.length);
        return newArray;
    }

    /** Insertion sort implementation from Assignment-3*/
    public static String[] insertionSort(String[] in, Comparator<String> c) {

        String[] newArray = in.clone();

        for (int i = 1; i < newArray.length; i++)
        {
            int currentIndex = i;

            while (currentIndex > 0 && newArray[currentIndex - 1].compareTo(newArray[currentIndex]) > 0)
            {
                String temp = newArray[currentIndex];
                newArray[currentIndex] = newArray[currentIndex - 1];
                newArray[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
        return newArray;
    }


    /**Suite for running 10 tests of Stringbuilder
     * @param warmup int
     * @param repetitionInput int
     * @param itemToAdd String
     * @param increaseForNextTest int
     * @return int[]*/
    public static int[] stringBuilderSuite (int warmup, int repetitionInput, String itemToAdd, int increaseForNextTest) {

        int repetitions = repetitionInput;
        int[] resultArray = new int[10];

        for (int i = 0; i < 5; i++){
            TimeTestStringBuilder temp = new TimeTestStringBuilder(warmup, itemToAdd);
            temp.run10Tests();
        }

        for (int i = 0; i < 10; i++) {
            TimeTestStringBuilder temp = new TimeTestStringBuilder(repetitions, itemToAdd);
            resultArray[i] = temp.run10Tests();
            repetitions += increaseForNextTest;
        }
        return resultArray;
    }

    /** Suite for running 10 tests of String concat
     * @param warmup int
     * @param repetitionInput int
     * @param itemToAdd String
     * @param increaseForNextTest int
     * @return int[]*/
    public static int[] standardConcatSuite (int warmup, int repetitionInput, String itemToAdd, int increaseForNextTest) {
        int repetitions = repetitionInput;
        int[] resultArray = new int[10];

        for (int i = 0; i < 5; i++){
            TimeTestStandardConcat temp = new TimeTestStandardConcat(warmup, itemToAdd);
            temp.run10Tests();
        }

        for (int i = 0; i < 10; i++) {
            TimeTestStandardConcat temp = new TimeTestStandardConcat(repetitions, itemToAdd);
            resultArray[i] = temp.run10Tests();
            repetitions += increaseForNextTest;
        }
        return resultArray;
    }

    /**Method for printing int values from an array
     * @param array int[]*/
    public static void printArrayValues (int[] array) {
        for (int element:array
             ) {
            System.out.println(element);

        }
    }

    /**method for randomising numbers
     * @param max int
     * @return int
     * */
    public static int randomNumber (int max) {
        Random random = new Random();
        return random.nextInt(max);

    }

    /**method for randomising a string
     * @return String
     * */
    public static String randomString(){
        Random random = new Random();
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < 10; i++){
            char c = (char)('a' + random.nextInt(26));
            strB.append(c);
        }
        return strB.toString();
    }

    /** method for creating a String array to sort
     * @param arraySize int
     * @return  String[]
     * */
    public static String[] createStringArrayToSort (int arraySize) {
        String[] array = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = randomString();
        }
        return array;
    }

    /**Method for creating an Int array to sort
     * @param arraySize int
     * @return int[]
     * */
    public static int[] createIntArrayToSort (int arraySize){
        int [] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            array[i] = randomNumber(arraySize*2);
        }
        return array;
    }

    /**test suite for InsertionSort integers
     * @param warmup int
     * @param increase int
     * @param initial int
     * @param runtime Runtime
     * */
    public static int[] testSuiteIntInsertionSort (int warmup, int increase, int initial, Runtime runtime){
        int[] resultArray = new int[10];

        int numbersOfSortedNumbers = initial;

        for (int i = 0; i < 5; i++){
            run10timeTestIntInsertionSort(warmup, runtime);
        }

        for (int i = 0; i < 10; i++) {
            resultArray[i] = run10timeTestIntInsertionSort(numbersOfSortedNumbers,runtime);
            numbersOfSortedNumbers+=increase;
        }
        return resultArray;
    }

    /**test suite for InsertionSort String
     * @param warmup int
     * @param increase int
     * @param initial int
     * @param runtime Runtime*/
    public static int[] testSuiteStringInsertionSort (int warmup, int increase, int initial, Runtime runtime){
        int[] stringResultArray = new int[10];

        int numbersOfSortedNumbers = initial;

        for (int i = 0; i < 5; i++){
            run10timeTestStringInsertionSort(warmup, runtime);
        }

        for (int i = 0; i < 10; i++) {
            stringResultArray[i] = run10timeTestStringInsertionSort(numbersOfSortedNumbers,runtime);
            numbersOfSortedNumbers+=increase;
        }
        return stringResultArray;
    }

    /**method for running 10 tests of Insertion Sort Int
     * @param arraySize int
     * @param runtime Runtime*/
    public static int run10timeTestIntInsertionSort (int arraySize, Runtime runtime) {
        int[] array = createIntArrayToSort(arraySize);
        int sum = 0;
        for (int i = 0; i < 10; i++){
            sum += timeTestIntInsertionSort(array, runtime);
        }
        return sum/10;
    }

    /**method for running 10 tests for InsertionSort String
     * @param arraySize int
     * @param runtime Runtime*/
    public static int run10timeTestStringInsertionSort (int arraySize, Runtime runtime) {
        String[] array = createStringArrayToSort(arraySize);
        int sum = 0;
        for (int i = 0; i < 10; i++){
            sum += timeTestStringInsertionSort(array, runtime);
        }
        return sum/10;
    }

    /**Method for an individual Int InsertionSort test
     * @param unsortedArray int[]
     * @param runtime Runtime
     * */
    public static int timeTestIntInsertionSort (int[] unsortedArray, Runtime runtime) {
        runtime.gc();
        long before = System.currentTimeMillis();
        insertionSort(unsortedArray);
        long after = System.currentTimeMillis();
        return (int) (after - before);
    }

    /**method for an individual String insertion sort Test
     * @param arrayToSort String[]
     * @param runtime Runtime
     * */
    public static int timeTestStringInsertionSort(String[] arrayToSort, Runtime runtime){
        runtime.gc();
        long before = System.currentTimeMillis();
        insertionSort(arrayToSort, new IntComparator<>());
        long after = System.currentTimeMillis();
        return (int) (after - before);
    }

    /**Implementation of a Comparator*/
    private static class IntComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

    /**Main executing method*/
    public static void main(String[] args) {

        int stbSmallWarmup = 94500000;
        int stbSmallInitial = 92500000;
        int stbSmallIncrease = 500000;
        int stbLargeWarmup = 8600000;
        int stbLargeInitial = 8500000;
        int stbLargeIncrease = 25000;
        int stdSmallWarmup = 114000;
        int stdSmallInitial = 110000;
        int stdSmallIncrease = 1000;
        int stdLargeWarmup = 12400;
        int stdLargeInitial = 12200;
        int stdLargeIncrease = 50;
        int insertSortIntWarmup = 100000;
        int insertSortIntInitial = 95000;
        int insertSortIntIncrease = 1000;
        int insertSortStringWarmup = 19800;
        int insertSortStringInitial = 19600;
        int insertSortStringIncrease = 50;

        Runtime runtime = Runtime.getRuntime();

        //int[] stringBuilderSmallStringTest = stringBuilderSuite(stbSmallWarmup, stbSmallInitial, "t", stbSmallIncrease );
        //int[] stringBuilderLargeStringTest = stringBuilderSuite(stbLargeWarmup, stbLargeInitial, "Darth Vader, Whose name is Anakin Skywalker, is the ironclad fist of the empire!", stbLargeIncrease);
        //int[] standardConcatSmallStringTest = standardConcatSuite(stdSmallWarmup, stdSmallInitial, "t", stdSmallIncrease);
        //int[] standardConcatLargeStringTest = standardConcatSuite(stdLargeWarmup, stdLargeInitial, "Darth Vader, Whose name is Anakin Skywalker, is the ironclad fist of the empire!", stdLargeIncrease);
        //int[] insertionSortIntTest = testSuiteIntInsertionSort(insertSortIntWarmup,insertSortIntIncrease , insertSortIntInitial, runtime);
        int[] insertionSortStringTest = testSuiteStringInsertionSort(insertSortStringWarmup,insertSortStringIncrease , insertSortStringInitial, runtime);


        //System.out.println("Test of one char string concatenations during 1s with StringBuilder\n");
        //printArrayValues(stringBuilderSmallStringTest);
        //System.out.println("Test of 80 char string concatenations during 1s with StringBuilder\n");
        //printArrayValues(stringBuilderLargeStringTest);
        //System.out.println("Test of one char string concatenations during 1s with standard concatenations of Strings\n");
        //printArrayValues(standardConcatSmallStringTest);
        //System.out.println("Test of 80 char string concatenations during 1s with standard concatenations of Strings\n");
        //printArrayValues(standardConcatLargeStringTest);
        //System.out.println("Test of how many random numbers insertion sort can sort during 1s\n");
        //printArrayValues(insertionSortIntTest);
        System.out.println("Test of how many random 10 char long Strings insertion sort can sort during 1s\n");
        printArrayValues(insertionSortStringTest);

    }
}
