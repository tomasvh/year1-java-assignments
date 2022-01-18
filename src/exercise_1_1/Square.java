/**
 * Class for square objects, inherits from shape
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_1;

public class Square extends Rectangle {

    private int side;

    /**
     * Default constructor
     *
     * @param shapeName String*/
    public Square(String shapeName) {
        super(shapeName);
    }

    /**
     * Constructor with parameters
     *
     * @param shapeName String
     * @param side int*/
    public Square(String shapeName, int side) {
        super(shapeName, side, side);
    }

    /**
     * Get integer side
     *
     * @return side int*/
    public int getSide() {
        return side;
    }

    /**
     * Set integer side
     *
     * @param side int */
    public void setSide(int side) {
        this.side = side;
    }
}
