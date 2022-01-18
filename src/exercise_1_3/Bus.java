/**
 * Class for Bus, inherits Vehicle class object
 * Unique ID and ferryPrice attributes
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;

public class Bus  extends Vehicle {
    private int iD = 1;

    /**
     * Default constructor
     * */
    public Bus() throws Exception {
        this.spaceOccupied = 20;
        this.maxNumberOfPassengers = 20;
        this.setNumberOfPassengers();
        this.passengerFerryFee = 15;
        this.type = "bus";
        this.ferryPrice = 200;
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
