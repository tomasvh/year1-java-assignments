/**
 * Main exectuing class
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_3;

import java.util.*;

public class FerryMain {
    /**
     * Method for generating a unique vehicle ID for Vehicle class Objects
     *
     * @param type String
     * @param vehicleIds Array of Vehicle ID numbers
     * */
    public static int genNewVehicleId(String type, int[] vehicleIds){
    int vehicleId = 0;
        switch (type){
            case "bicycle":
                vehicleIds[0] = vehicleIds[0] + 1;
                vehicleId = vehicleIds[0];
                break;
            case "car":
                vehicleIds[1] = vehicleIds[1] + 1;
                vehicleId = vehicleIds[1];
                break;
            case "bus":
                vehicleIds[2] = vehicleIds[2] + 1;
                vehicleId = vehicleIds[2];
                break;
            case "lorry":
                vehicleIds[3] = vehicleIds[3] + 1;
                vehicleId = vehicleIds[3];
            default:
                break;


        }
        return vehicleId;
    }

    /**
     * Method for generating an Arraylist of Vehicle class objects
     *
     * @param number int, number of vehicles to be generated
     * @param vehiclesList ArrayList of Vehicle class objects
     * @param vehicleIds Array of VehicleIds
     * */
    public static void generateVehicle(int number, ArrayList<Vehicle> vehiclesList, int[] vehicleIds){
        for(int i = 0; i<number;i++){
            int randVehicle = (int) (Math.random()*4);
            switch (randVehicle) {
                case 0:
                    Bicycle tmpBi = new Bicycle();
                    tmpBi.setiD(genNewVehicleId("bicycle", vehicleIds));
                    vehiclesList.add(tmpBi);
                    break;
                case 1:
                    try {
                        Car tmpCa = new Car();
                        tmpCa.setiD(genNewVehicleId("car", vehicleIds));
                        vehiclesList.add(tmpCa);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try{
                        Bus tmpBu = new Bus();
                        tmpBu.setiD(genNewVehicleId("bus", vehicleIds));
                        vehiclesList.add(tmpBu);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        Lorry tmpLo = new Lorry();
                        tmpLo.setiD(genNewVehicleId("lorry", vehicleIds));
                        vehiclesList.add(tmpLo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }
    }

    /**
     * Method for generating a list of Passenger class objects
     * @param number int, number of objects created
     * @param passengerArrayList ArrayList of Passenger class objects
     * */
    public static void generatePedestrians (int number, ArrayList<Passenger> passengerArrayList) {
        for(int i = 0; i < number; i++) {
            Passenger tmpPe = new Passenger();
            passengerArrayList.add(tmpPe);
        }
    }

    /**
     * Method for embarking vehicles and pedestrians on the ferry
     *
     * @param vehicleList ArrayList of Vehicle objects
     * @param passengerList ArrayList of Passenger objects
     * @param theFerry StudentFerry object
     * */
    public static void populateFerry(ArrayList<Vehicle> vehicleList, ArrayList<Passenger> passengerList, StudentFerry theFerry ) throws Exception {

        /*First we embark vehicles and the passengers of those vehicles*/
        try {
                ListIterator<Vehicle> it = vehicleList.listIterator();
                while (it.hasNext()) {
                    Vehicle element = it.next();
                    if (theFerry.hasSpaceFor(element)) {
                        theFerry.embark(element);
                        it.remove();
                    } else {
                        break;
                    }



                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println(theFerry.toString());
        /*Secondly we fill upp the rest of the spaces with pedestrians*/
        try {
            ListIterator<Passenger> it2 = passengerList.listIterator();
            while (it2.hasNext()) {
                Passenger element2 = it2.next();
                if (theFerry.hasRoomFor(element2)) {
                    theFerry.embark(element2);
                    it2.remove();
                } else {
                    break;
                }
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
        System.out.println(theFerry.toString());
    }

    /**
     * Main executing method
     * */
    public static void main(String[] args){
        StudentFerry theFerry = new StudentFerry();
        int[] vehicleIds = {0,0,0,0};
;
        ArrayList<Passenger> passengerList = new ArrayList<>();
        ArrayList<Vehicle> vehiclesList = new ArrayList<>();
        generateVehicle((int) (Math.random()*30), vehiclesList, vehicleIds);
        generatePedestrians(200, passengerList);

        try {
            populateFerry(vehiclesList, passengerList, theFerry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        theFerry.disembark();

        System.out.println(theFerry.toString());

        try {
            populateFerry(vehiclesList, passengerList, theFerry);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
