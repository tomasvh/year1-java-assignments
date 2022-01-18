/**Class for making a Sinuscurve from the txt file of integers
 * @Author Tomas Marx-Raacz von Hidvég
 * @Version 1.0
 * @Reference: XYChart examples@ https://knowm.org/open-source/xchart/xchart-example-code/
 * */

package exercise_4;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.Random;

public class SinMain {

    public static double doublePi = 2* Math.PI;

    public static double randomValue() {

        double rangeMin = 0;
        double rangeMax = doublePi;
        double intervall = 0.00628;

        Random random = new Random();
        double randomNumber = rangeMin + (rangeMax-rangeMin) * random.nextDouble();
        return randomNumber;
    }

    public static double calculateY(double x){
        double y  = (1 + x/Math.PI)*Math.cos(x)*Math.cos(40*x);
        return y;
    }

    public static void main(String[] args) {
        double intervall = 0.00628;

        ArrayList<Double> xList = new ArrayList<>();
        ArrayList<Double> yList = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            double x = i*intervall;
            xList.add(x);
            yList.add(calculateY(x));
        }
        System.out.println(xList);


        System.out.println(yList);

        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xList, yList);

        new SwingWrapper(chart).displayChart();


    }
}
