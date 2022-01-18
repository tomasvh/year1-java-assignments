/**
 * Class for circle objects, inherits from shape
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_1;

public class Circle extends Shape {
    private int radius = 0;

    public static final double PI = 3.14;

    /**
     * Default constructor
     *
     * @param name String*/
    public Circle (String name) {
        super(name);

    }

    /**
     * Constructor with parameters
     *
     * @param name String
     * @param radius int*/
    public Circle (String name, int radius) {
        super(name);
        this.radius = radius;
    }
/**
 * Get integer radius
 *
 * @return radius int*/
    public int getRadius() {
        return this.radius;
    }

    /**
     * Set integer radius
     *
     * @param radius int */
    public void setRadius(int radius) {
        this.radius = radius;
    }


    /**
     * Get double area
     *
     * @return radius double*/
    @Override
    public double getArea() {
        return PI * this.radius * this.radius;
    }

    /**
     * Get double perimeter
     *
     * @return perimeter double*/
    @Override
    public double getPerimeter() {
        return 2 * PI * this.radius;
    }
}
