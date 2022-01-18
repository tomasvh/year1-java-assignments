/**Class for Standard concat time tests
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */
package time;

import java.util.ArrayList;

public class TimeTestStandardConcat {
    private int repetitions = 0;

    private String itemToAdd = "";
    private Runtime runtime = Runtime.getRuntime();

    /** Default constructor*/
    public TimeTestStandardConcat() {

    }
    /**Constructor with parameters
     * @param repetitions int
     * @param itemToAdd String
     * */
    public TimeTestStandardConcat (int repetitions, String itemToAdd) {
        this.repetitions = repetitions;
        this.itemToAdd = itemToAdd;
    }

    /**Method for a standard concat Test
     * @return int
     * */
    public int measureTime() {
        this.runtime.gc();
        String builtString = "";
        long before = System.currentTimeMillis();
        for (int i = 0; i < this.repetitions; i++){
            builtString += this.itemToAdd;
        }
        long after = System.currentTimeMillis();

        return (int) (after - before);

    }

    /**Method for running 10 tests
     * @return int
     * */
    public int run10Tests(){
        ArrayList<Integer> testResultArray = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 10; i++ ) {
            testResultArray.add(measureTime());
        }

        for (long element:testResultArray
        ) {
            sum += element;
        }
        return (int) (sum / 10);
    }

    /*Generated getters and setters*/
    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public String getItemToAdd() {
        return itemToAdd;
    }

    public void setItemToAdd(String itemToAdd) {
        this.itemToAdd = itemToAdd;
    }
}
