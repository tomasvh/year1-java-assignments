/**
 * Passenger class object
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */
package exercise_3;

public class Passenger {
    int ferryPrice = 25;

    /**
     * Default constructor
     * */
    public Passenger() {
    }

    /**
     * Constructor with parameter
     * @param ferryPrice int
     * */
    public Passenger(int ferryPrice) {
        this.ferryPrice = ferryPrice;
    }

    /**
     * getter for ferryPrice
     *
     * @return ferryPrice int
     * */
    public int getFerryPrice() {
        return ferryPrice;
    }

    /**
     * Setter for FerryPrice
     *
     * @param ferryPrice int
     * */
    public void setFerryPrice(int ferryPrice) {
        this.ferryPrice = ferryPrice;
    }
}
