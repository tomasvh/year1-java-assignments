/**Class for making a Scatterplot from the txt file of integers
 * @Author Tomas Marx-Raacz von Hidvég
 * @Version 1.0
 * @Reference: XYChart examples@ https://knowm.org/open-source/xchart/xchart-example-code/
 * */


package exercise_4;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScatterPlot {

    public static void main(String[] args) {
        // Create and Customize Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();
        Random random = new Random();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            xData.add(random.nextGaussian() );
            yData.add(random.nextGaussian());
        }

        // Display scatter plot
        chart.addSeries("Gaussian Blob", xData, yData);
        new SwingWrapper(chart).displayChart();
    }


}
