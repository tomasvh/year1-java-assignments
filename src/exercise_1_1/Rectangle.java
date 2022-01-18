/**
 * Class for rectangle objects, inherits from shape
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_1;

public class Rectangle extends Shape {
    private int base;
    private int height;

    /**
     * Default constructor
     *
     * @param shapeName String
     * */
    public Rectangle(String shapeName) {
        super(shapeName);
    }

    /**
     * Constructor with parameters
     *
     * @param shapeName String
     * @param base int
     * @param height int
     * */
    public Rectangle(String shapeName, int base, int height) {
        super(shapeName);
        this.base = base;
        this.height = height;
    }

    /**
     * Get integer base
     *
     * @return base int*/
    public int getBase() {
        return base;
    }

    /**
     * Set integer base
     *
     * @param base int */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * Get integer height
     *
     * @return height int*/
    public int getHeight() {
        return height;
    }

    /**
     * Set integer height
     *
     * @param height int */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get double area
     *
     * @return area double*/
    @Override
    public double getArea() {
        return this.base * this.height;
    }

    /**
     * Get double perimeter
     *
     * @return perimeter double*/
    @Override
    public double getPerimeter() {
        return 2 * (this.base + this.height);
    }
}
