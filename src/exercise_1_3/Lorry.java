/**
 * Class for Lorry, inherits Vehicle class object
 * Unique ID and ferryPrice attributes
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;

public class Lorry extends Vehicle {
    private int iD = 1;
    /**
     * Default constructor
     * */
    public Lorry() throws Exception {
        this.spaceOccupied = 40;
        this.maxNumberOfPassengers = 2;
        this.setNumberOfPassengers();
        this.passengerFerryFee = 20;
        this.type = "lorry";
        this.ferryPrice = 300;
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
