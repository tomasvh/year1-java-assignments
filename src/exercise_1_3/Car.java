/**
 * Car class with ID and carPrice as a unique attribute compared to the extended Vehicle class.
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;

public class Car extends Vehicle {
    private int iD = 1;

    /**
     * default constructor
     * */
    public Car() throws Exception {
        this.spaceOccupied = 5;
        this.maxNumberOfPassengers = 4;
        this.setNumberOfPassengers();
        this.passengerFerryFee = 20;
        this.type = "car";
        this.ferryPrice = 100;
    }

    /**
     * Setter for ID
     *
     * @param iD int
     * */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * getter for iD
     *
     * @return iD int*/
    public int checkId(){
        return this.iD;
    }


}
