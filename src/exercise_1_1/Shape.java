/**
 * Abstract class for shape with two methods, one attribute and one overridden method from object class
 *
 * Copied from assignment
 * */

package exercise_1;

import java.text.DecimalFormat;

public abstract class Shape {
    protected String name;

    public Shape(String shapeName) { name = shapeName; }

    public abstract double getArea();
    public abstract double getPerimeter();

    /**
     * to string method for printing details of the objects that inherit from this abstract class
     *
     * @return string of details*/
    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("##.00");
        String a = f.format( getArea() );
        String p = f.format( getPerimeter() );
        return name+", Area = "+a+", Perimeter = "+p;
    }
}
