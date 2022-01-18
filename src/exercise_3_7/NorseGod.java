/**Class for the Gods
 * Created from UML template in Assignment-3*/

package exercise_7;

public class NorseGod {
    private String name;
    private String race;
    private String desc;

    /**Default constructor*/
    public NorseGod(){

    }

    /**Constructor with parameters
     * @param name String
     * @param race String
     * @param desc String*/
    public NorseGod(String name, String race, String desc) {
        this.name = name;
        this.race = race;
        this.desc = desc;
    }

    /* Generated Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
