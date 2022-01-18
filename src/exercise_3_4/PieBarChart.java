/**Class for making a pie chart from the txt file of integers
 * @Author Tomas Marx-Raacz von Hidvég
 * @Version 1.0
 * @Reference: XYChart examples@ https://knowm.org/open-source/xchart/xchart-example-code/
 * */
package exercise_4;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class PieBarChart  {


    /**Method for adding the number of counts to an ArrayList
     * @param oldList ArrayList<Integer>
     * @return Arraylist<Integer>*/
    public static ArrayList<Integer> countListPopulation (ArrayList<Integer> oldList) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newList.add(0);
        }
        for (Integer element: oldList
             ) {
            if (element > 0 && element < 10) {
                newList.set(0, newList.get(0)+1);
            } else if (element >= 10 && element < 20) {
                newList.set(1, newList.get(1)+1);
            }
            else if (element >= 20 && element < 30) {
                newList.set(2, newList.get(2)+1);
            }
            else if (element >= 30 && element < 40) {
                newList.set(3, newList.get(3)+1);
            }
            else if (element >= 40 && element < 50) {
                newList.set(4, newList.get(4)+1);
            }
            else if (element >= 50 && element < 60) {
                newList.set(5, newList.get(5)+1);
            }
            else if (element >= 60 && element < 70) {
                newList.set(6, newList.get(6)+1);
            }
            else if (element >= 70 && element < 80) {
                newList.set(7, newList.get(7)+1);
            }
            else if (element >= 80 && element < 90) {
                newList.set(8, newList.get(8)+1);
            }
            else if (element >= 90) {
                newList.set(9, newList.get(9)+1);
            }
        }
        return newList;
    }

    /**Same as above but percent
     * @param oldList ArrayList<Integer>
     * @param countList ArrayList<Integer>
     * @return Arraylist<Double>
     *     */
    public static ArrayList<Double> populatePercentageList (ArrayList<Integer> oldList, ArrayList<Integer> countList){
        ArrayList<Double> newList = new ArrayList<>();

        for (Integer element:countList
             ) { double percentage = element.doubleValue() / oldList.size()*100;
             percentage = Math.round( percentage*1000d) / 1000d ;
             newList.add(percentage);
        }
        return newList;
    }

    public static void main(String[] args) {

        String fileName = "src/exercise_4/resources/integers.dat";

        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        System.out.println(list);

        ArrayList<Integer> countsList = countListPopulation(list);
        ArrayList<Double> percentageList = populatePercentageList(list, countsList);

        System.out.println(countsList);
        System.out.println(percentageList);


        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(PieBarChart.class.getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182), new Color(255,226,0),new Color(75,196,213 ), new Color(253,154,251 ), new Color(149,119,109 ), new Color(180,176,173 ), new Color(59,40,96 ) };
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        chart.addSeries("1-9", percentageList.get(0));
        chart.addSeries("10-19", percentageList.get(1));
        chart.addSeries("20-29", percentageList.get(2));
        chart.addSeries("30-39", percentageList.get(3));
        chart.addSeries("40-49", percentageList.get(4));
        chart.addSeries("50-59", percentageList.get(5));
        chart.addSeries("60-69", percentageList.get(6));
        chart.addSeries("70-79", percentageList.get(7));
        chart.addSeries("80-89", percentageList.get(8));
        chart.addSeries("90-100", percentageList.get(9));

        new SwingWrapper<>(chart).displayChart();

        // Create Chart
        CategoryChart chart2 = new CategoryChartBuilder().width(800).height(600).title("Integer Bar chart").xAxisTitle("counts").yAxisTitle("interval").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);


        ArrayList<String> groups2 = new ArrayList<>();
        groups2.add("<10");
        groups2.add("<20");
        groups2.add("<30");
        groups2.add("<40");
        groups2.add("<50");
        groups2.add("<60");
        groups2.add("<70");
        groups2.add("<80");
        groups2.add("<90");
        groups2.add("<100");


        // Series


        chart2.addSeries("numbercounts", groups2, countsList);
        new SwingWrapper<>(chart2).displayChart();


    }
}
