/**
 * Class for a ferry containing attributes, arrays of vehicle and passenger objects
 * and counters to control space and revenue
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;



public class StudentFerry implements Ferry {
    int maxPassenger = 200;
    int maxVehicleSpace = 200;
    int currentOccupiedVehicleSpace = 0;
    Vehicle[] vehicles = new Vehicle[0];
    Passenger[] passengers = new Passenger[0];
    int passengerCount;
    int totalFerryRevenue;

    /**
     * Default constructor
     * */
    public StudentFerry () {
    }

    /**
     * Getter for number of passengers on the ferry
     *
     * @return passengerCount integer
     * */
    @Override
    public int countPassengers() {
        return this.passengerCount;
    }

    /**
     * Getter for occupied vehiclespace
     *
     * @return currentOccupiedVehicleSpace integer
     * */
    @Override
    public int countVehicleSpace() {
        if(this.currentOccupiedVehicleSpace % 5 != 0) {
            return this.currentOccupiedVehicleSpace/5 + 1;
        }
        return this.currentOccupiedVehicleSpace/5;
    }

    /**
     * Method for producing the total revenue for the current trip
     *
     * @return sum integer
     * */
    @Override
    public int countMoney() {
        int sum = 0;
        for (Vehicle vehicle: this.vehicles) {
            sum += vehicle.getFerryPrice();
        }
        for (Passenger passenger: this.passengers) {
            sum += passenger.getFerryPrice();
        }
        return sum;
    }

    /**
     * Method to reach the vehicle array
     *
     * @return vehicles Array of Vehicle class objects*/
    @Override
    public Vehicle[] getAllVehicles() {
        return this.vehicles;
    }

    /**
     * Method to embark a vehicle from main method to the vehicle and passenger array
     * after checking if the ferry has space for it.
     *
     * @param v Vehicle class object*/
    @Override
    public void embark(Vehicle v) {
        if (hasSpaceFor(v)){
            Passenger[] vehiclePassengers =  new Passenger[v.getNumberOfPassengers()];
            for(int i = 0; i < v.getNumberOfPassengers(); i++) {
                Passenger p = new Passenger(v.getPassengerFerryFee());
                if(!hasRoomFor(p)) {
                    break;
                }
                vehiclePassengers[i] = p;
            }
            loadVehicle(v);
            loadPassengers(vehiclePassengers);
        }
    }

    /**
     * Sub-method for embark to copy the Vehicle class object to the ferry array
     * and increasing revenue and currentOccupiedVehicleSpace
     *
     * @param vehicle Vehicle class object
     * */
    private void loadVehicle(Vehicle vehicle) {
        int newSize = this.vehicles.length + 1;
        Vehicle[] tmpArray = new Vehicle[newSize];
        for (int i = 0; i < this.vehicles.length; i++) {
            tmpArray[i] = this.vehicles[i];
        }
        tmpArray[newSize - 1] = vehicle;
        this.vehicles = null;
        this.vehicles = tmpArray;
        this.totalFerryRevenue += vehicle.getFerryPrice();
        this.currentOccupiedVehicleSpace += vehicle.getSpaceOccupied();
    }

    /**
     * Method for copying a Passenger class objects from an array to ferry passenger array and increase
     * revenue, and passengerCount variable
     *
     * @param newPassengers Array of Passenger class objects
     * */
    private void loadPassengers(Passenger[] newPassengers) {
        int newSize = this.passengers.length + newPassengers.length;
        Passenger[] tmpArray = new Passenger[newSize];
        int currentSize = this.passengers.length;
        for (int i = 0; i < currentSize; i++) {
            tmpArray[i] = this.passengers[i];
        }
        for (int i = 0; i < newPassengers.length; i++) {
            tmpArray[currentSize + i] = newPassengers[i];
            this.totalFerryRevenue += newPassengers[i].getFerryPrice();
            this.passengerCount++;
        }
        this.passengers = null;
        this.passengers = tmpArray;
    }

    /**
     * Method for embarking pedestrians and loading it through the loadPassengers method
     *
     * @param p Passenger class object
     * */
    @Override
    public void embark(Passenger p) throws Exception {
        if(hasRoomFor(p)) {
            Passenger[] ps = new Passenger[1];
            ps[0] = p;
            loadPassengers(ps);
        } else {
            throw new Exception("The passenger will not fit on the Ferry");
        }
    }

    /**
     * Method for disembarking(emptying the ferry)
     * */
    @Override
    public void disembark() {
        this.vehicles = null;
        this.passengers = null;
        this.vehicles = new Vehicle[0];
        this.passengers = new Passenger[0];
        this.passengerCount = 0;
        this.currentOccupiedVehicleSpace = 0;
    }

    /**
     * Method to check if the ferry has space for the Vehicle class object
     *
     * @param v Vehicle class object
     * @return boolean
     * */
    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return this.currentOccupiedVehicleSpace + v.getSpaceOccupied() <= this.maxVehicleSpace;
    }

    /**
     * Method for checking if ferry has space for a Passenger class object
     *
     * @param p Passenger class object
     * @return boolean
     * */
    @Override
    public boolean hasRoomFor(Passenger p) {
        return this.passengers.length + 1 <= this.maxPassenger;
    }

    /**
     * Method for printing the content of the ferry and the total revenue for the trip
     * and total revenue of the ferry
     *
     * @return str String*/
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Vehicle element:this.vehicles) {
            str.append(element.getType()).append(" with ").append(element.getNumberOfPassengers()).append(" passengers, ");
        }
        str.append("\n").append(this.countPassengers());
        str.append("\n").append(this.countVehicleSpace());
        str.append("\n").append(this.countMoney());
        str.append("\n").append(this.totalFerryRevenue);
        return str.toString();
    }
}


