/**Class for keeping and calculating the interest
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */
package exercise_7;

public class CompoundInterest {
    private int startingAmount;
    private double endAmount;
    private int interest;
    private int NumberOfYears;

    /**Default constructor*/
    public CompoundInterest() {

    }

    /**Constructor with parameters and executing the calculation of the compounded interest
     *
     * @param startingAmount int
     * @param interest int
     * @param numberOfYears int
     * */
    public CompoundInterest(int startingAmount, int interest, int numberOfYears) {
        this.startingAmount = startingAmount;
        this.interest = interest;
        this.NumberOfYears = numberOfYears;
        this.endAmount = computeEndAmount(getStartingAmount(), getInterest(), getNumberOfYears());
    }

    /**Getter for starting amount
     *
     * @return startingAmount int
     * */
    public int getStartingAmount() {
        return this.startingAmount;
    }

    /**Setter for startingAmount
     *
     * @param startingAmount int
     * */
    public void setStartingAmount(int startingAmount) {
        this.startingAmount = startingAmount;
    }

    /**
     * Getter for EndAmount
     *
     * @return String
     * */
    public String getEndAmount() {
        StringBuilder str = new StringBuilder();
        str.append(this.endAmount);
        return str.toString();
    }

    /**
     * Method for calculating compounded interest
     *
     * @param startingAmount int
     * @param interest int
     * @param numberOfYears int
     *
     * @return double
     * */
    public double computeEndAmount (int startingAmount, int interest, int numberOfYears) {
        double newInterest = interest;
        newInterest = newInterest/100;
        System.out.println(newInterest);
        System.out.println(startingAmount);
        System.out.println(numberOfYears);
        return Math.floor(startingAmount * Math.pow((1 + newInterest), numberOfYears));



    }

    /**Getter for interest
     *
     * @return interest int
     * */
    public int getInterest() {
        return this.interest;
    }
    /**
     * Setter for interest
     *
     * @param interest int
     */
    public void setInterest(int interest) {
        this.interest = interest;
    }

    /**Getter for numberOfYears
     *
     * @return numberOfYears int
     * */
    public int getNumberOfYears() {
        return this.NumberOfYears;
    }

    /**Setter for numberOfYears
     *
     * @param numberOfYears int*/
    public void setNumberOfYears(int numberOfYears) {
        this.NumberOfYears = numberOfYears;
    }
}
