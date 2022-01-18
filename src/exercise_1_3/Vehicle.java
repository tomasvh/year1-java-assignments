/**
 * Abstract class for Vehicle
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */
package exercise_3;

public abstract class Vehicle {
    protected int spaceOccupied;
    protected int numberOfPassengers;
    protected int maxNumberOfPassengers;
    protected int passengerFerryFee;
    protected int ferryPrice;
    protected String type;


    /**
     * getter for spaceOccupied
     *
     * @return spaceOccupied int
     * */
    public int getSpaceOccupied() {
        return this.spaceOccupied;
    }

    /**
     * Setter for SpaceOccupied
     *
     * @param spaceOccupied integer
     * */
    public void setSpaceOccupied(int spaceOccupied) {
        this.spaceOccupied = spaceOccupied;
    }

    /**
     * getter for numberOfPassengers
     *
     * @return numberOfPassengers int
     * */
    public int getNumberOfPassengers() {
        return this.numberOfPassengers;
    }

    /**
     * getter for passengerFerryFee
     *
     * @return passengerFerryFee int
     * */
    public int getPassengerFerryFee() {
        return this.passengerFerryFee;
    }

    /**
     * Setter for passengerFerryFee
     *
     * @param passengerFerryFee integer
     * */
    public void setPassengerFerryFee(int passengerFerryFee) {
        this.passengerFerryFee = passengerFerryFee;
    }

    /**
     * Setter for numberOfPassengers(randomized towards maxNumberOfPassengers)
     * */
    public void setNumberOfPassengers() throws Exception {
        int numberOfPassengers = (int) (Math.random() * this.maxNumberOfPassengers) + 1;
        if(numberOfPassengers > maxNumberOfPassengers) {
            throw new Exception("Too many passengers");
        }
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * getter for type
     *
     * @return type String
     */
    public String getType() {
        return this.type;
    }

    /**
     * getter for ferryPrice
     * */
    public int getFerryPrice(){
        return this.ferryPrice;
    };
}
