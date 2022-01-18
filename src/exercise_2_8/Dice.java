/**
 * Class for dice
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 *
 * */

package exercise_8;

import javafx.scene.image.Image;

public class Dice {
    private Image image;
    private int value;

    /**Default constructor*/
    public Dice(){

    }

    /**Constructor with parameters
     *
     * @param image Image
     * @param value Integer
     * */
    public Dice (Image image, int value) {
        this.image = image;
        this.value = value;
    }

    /**Getter for image
     *
     * @return image Image*/
    public Image getImage() {
        return image;
    }

    /**Setter for image
     *
     * @param image Image
     * */
    public void setImage(Image image) {
        this.image = image;
    }

    /**Getter for value
     *
     * @return value Integer
     * */
    public int getValue() {
        return value;
    }

    /**Setter for value
     *
     * @param value Integer*/
    public void setValue(int value) {
        this.value = value;
    }
}
