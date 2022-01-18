/**
 * Tiny Painter
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * @InspirationReference https://www.baeldung.com/java-insertion-sort
 * @InspirationReference https://www.baeldung.com/java-merge-sort*/

package exercise_6;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {


    /**Method for insertionSort for int
     * @param input int[]
     * @param inputLength int
     * */
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

    /**StartMethod with your chosen parameter and return types*/
    public static int[] insertionSort(int[] in) {
        int [] newArray = in.clone();
        insertionSortRecursive(newArray, newArray.length);
        return newArray;
    }

    /**Method for recursive insertionsorting of Strings using Comparator
     * @param in String[]
     * @param c Comparator<String>
     * @return String[] */
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

    /**Starting method with your chosen parameters and returntypes*/
    public static int[] mergeSort(int[] in) {
        int [] newArray = in.clone();

        mergeSort(newArray, newArray.length);
        return newArray;
    }

    /**Mergesort implementation
     * @param inputArray int[]
     * @param  inputLength */
    public static void mergeSort(int[] inputArray, int inputLength) {
        if (inputLength < 2) {
            return;
        }
        int mid = inputLength / 2;
        int[] leftArray = Arrays.copyOfRange(inputArray, 0, mid);
        int[] rightArray = Arrays.copyOfRange(inputArray, mid, inputLength);


        mergeSort(leftArray, mid);
        mergeSort(rightArray, inputLength - mid);

        merge(inputArray, leftArray, rightArray, mid, inputLength - mid);
    }

    /**Method for merging once split
     * @param  inputArray int[]
     * @param leftArray int[]
     * @param rightArray int[]
     * @param left int
     * @param right int*/
    public static void merge(int[] inputArray, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k++] = leftArray[i++];
            }
            else {
                inputArray[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            inputArray[k++] = leftArray[i++];
        }
        while (j < right) {
            inputArray[k++] = rightArray[j++];
        }
    }


    /**A try to implement a generic mergeSort
     * @param inputArray T[]
     * @param c Comparator<T>*/
    public static <T> T[] mergeSort(T[] inputArray, Comparator<T> c) {
        T [] newArray = inputArray.clone();
        mergeSortCopy(newArray, c);
        return newArray;
    }


    /**merge but with generic and using comparator*/
    public static <T> void merge(T[] leftArray, T[] rightArray, T[] inputArray, Comparator<T> comp) {

        int i = 0;
        int j = 0;
        while (i + j < inputArray.length) {
            if (j == rightArray.length || (i < leftArray.length && comp.compare(leftArray[i], rightArray[j]) < 0))
                inputArray[i + j] = leftArray[i++];
            else
                inputArray[i + j] = rightArray[j++];
        }

    }

    /**Generic implementation of handling left and right merges
     * @param  inputArray K[]
     * */
    public static <K> void mergeSortCopy(K[] inputArray, Comparator<K> comp) {

        int n = inputArray.length;
        if (n < 2)
            return;

        int mid = n / 2;
        K[] leftArray = Arrays.copyOfRange(inputArray, 0, mid);
        K[] rightArray = Arrays.copyOfRange(inputArray, mid, n);

        mergeSortCopy(leftArray, comp);
        mergeSortCopy(rightArray, comp);

        merge(leftArray, rightArray, inputArray, comp);
    }

    /**Chosen implementation of a comparator*/
    private static class IntComparator<T extends Comparable<T>> implements Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }



    /**Printing the generic array*/
    public static <T> String print (T[] inputArray) {
        StringBuilder str = new StringBuilder();
        for (T element: inputArray
             ) { str.append(element);
             str.append(" ");

        }
        return str.toString();
    }

    /**printing the int array*/
    public static  String print (int[] inputArray) {
        StringBuilder str = new StringBuilder();
        for (int element: inputArray
        ) { str.append(element);
            str.append(" ");

        }
        return str.toString();
    }

    public static void main(String[] args) {

        int [] intArray = {5, 15, 65, 78, 2, 36, 42};
        String [] stringArray = {"Han Solo", "Leia", "Darth Vader", "Chewie", "Lando", "Darth Sidious"};

        System.out.println("original: " + print(intArray));
        int [] insertionSorted = insertionSort(intArray);
        System.out.println("insertion sorted: " + print(insertionSorted));

        System.out.println("original: " + print(intArray));
        int [] mergeSorted = mergeSort(intArray);
        System.out.println("merge sorted: " + print(mergeSorted));

        System.out.println("Original stringarray: " + print(stringArray));
        Comparator<String> comparator = Comparator.naturalOrder();
        String [] insertionSortedString = insertionSort(stringArray, comparator);
        System.out.println("Insertionsorted array of strings: " + print(insertionSortedString));

        System.out.println("Original stringarray: " + print(stringArray));
        String [] mergeSortedString = mergeSort(stringArray, new IntComparator<String>());
        System.out.println("mergesorted array of strings: " + print(mergeSortedString));










    }

}
