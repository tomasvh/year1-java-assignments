/**
 * Class for Lorry, inherits Vehicle class object
 * Unique ID and ferryPrice attributes
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;

public class Bicycle  extends Vehicle{
    private int iD = 1;

    /**
     * Default constructor
     * */
    public Bicycle() {
        this.spaceOccupied = 1;
        this.numberOfPassengers = 1;
        this.type = "bicycle";
        this.ferryPrice = 40;
    }

    /**
     * Setter for iD
     *
     * @param iD integer
     * */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**getter for iD
     *
     * @return iD integer
     * */
    public int checkId(){
        return this.iD;
    }


}
