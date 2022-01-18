/**Class for running StringBuilder tests
 * @Author Tomas Marx-Raacz von Hidveg
 * @version 1.0
 * */

package time;

import java.util.ArrayList;

public class TimeTestStringBuilder {
    private int repetitions = 0;
    private String itemToAdd = "";
    private Runtime runtime = Runtime.getRuntime();


    /**Default constructor*/
    public TimeTestStringBuilder() {

    }

    /**Constructor with parameters
     * @param repetitions int
     * @param itemToAdd String
     * */
    public TimeTestStringBuilder (int repetitions, String itemToAdd) {
        this.repetitions = repetitions;
        this.itemToAdd = itemToAdd;
    }

    /**Method for running an individual StringBuilder timemeasure
     * @return int
     * */
    public int measureTime() {
        StringBuilder builtString = new StringBuilder();
        this.runtime.gc();
        long before = System.currentTimeMillis();
        for (int i = 0; i < this.repetitions; i++){
            builtString.append(this.itemToAdd);
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

        for (Integer element:testResultArray
             ) {
            sum += element;
        }
        return sum / 10;
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
