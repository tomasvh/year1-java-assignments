/**
 * Tiny Painter
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * @InspirationReference https://gist.github.com/abdelaziz321/e9932bd15e4b263c3dae08644c61600c
 * */

package exercise_8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class TinyPainter extends Application {

    @Override
    public void start(Stage stage) {


        /*Two comboboxes and the colorpicker*/
        ComboBox<String> paintType = new ComboBox();
        ComboBox<Integer> brushSize = new ComboBox();
        final ColorPicker colorPicker = new ColorPicker();

        /*Making a list of strings for the painttypes*/
        ObservableList<String> paintTypeList = FXCollections.observableArrayList();
        paintTypeList.add("Line");
        paintTypeList.add("Rectangle");
        paintTypeList.add("Circle");
        paintTypeList.add("Dot");

        /* making brush size list*/
        ObservableList<Integer> brushSizesList = FXCollections.observableArrayList();
        for (int i = 0; i < 40; i++) {
            brushSizesList.add(i+1);
        }

        /*adding said itemLists to the comboboxes*/
        for (String element:paintTypeList
             ) {
            paintType.getItems().add(element);
        }

        for (Integer element:brushSizesList
        ) {
            brushSize.getItems().add(element);
        }

        /*Main box*/
        VBox mainBox = new VBox();
        mainBox.setMinWidth(800);
        mainBox.setMinHeight(600);
        mainBox.setAlignment(Pos.CENTER);
        /*Main Box*/
        HBox menuBox = new HBox();
        menuBox.setMinWidth(800);
        menuBox.setMinHeight(50);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setSpacing(10);
        menuBox.setMargin(paintType, new Insets(5, 5, 5, 5));
        menuBox.setMargin(brushSize, new Insets(5, 5, 5, 5));
        menuBox.setMargin(colorPicker, new Insets(5, 5, 5, 5));

        /*Adding the comboboxes and colorpicker to parent*/
        ObservableList menulist = menuBox.getChildren();
        menulist.addAll(paintType, brushSize, colorPicker);

        /*creating the paint area and*/
        Canvas paintArea = new Canvas();
        paintArea.setHeight(550);
        paintArea.setWidth(800);
        GraphicsContext graphicsContext;
        graphicsContext = paintArea.getGraphicsContext2D();
        graphicsContext.setLineWidth(1);

        /*making the geometric objects*/
        Line line = new Line();
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        /*setting filling to none*/
        graphicsContext.setFill(Color.TRANSPARENT);


        /*eventhandlers for pressed mouse*/
        paintArea.setOnMousePressed(e->{
            String value = (String) paintType.getValue();
            if(value.equals("line")) {
                graphicsContext.setStroke(colorPicker.getValue());
                line.setStartX(e.getX());
                line.setStartY(e.getY());
            }
            else if(value.equals("Dot")) {
                graphicsContext.setStroke(colorPicker.getValue());
                graphicsContext.beginPath();
                graphicsContext.lineTo(e.getX(), e.getY());
            }

            else if(value.equals("Rectangle")) {
                graphicsContext.setStroke(colorPicker.getValue());
                rectangle.setX(e.getX());
                rectangle.setY(e.getY());
            }
            else if(value.equals("Circle")) {
                graphicsContext.setStroke(colorPicker.getValue());
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }

        });

        /*eventhandler for the Dot on drag*/
        paintArea.setOnMouseDragged(e->{
            String value = (String) paintType.getValue();
            if(value.equals("Dot")) {
                graphicsContext.lineTo(e.getX(), e.getY());
                graphicsContext.stroke();
            }
        });


        /*eventhandler for the release of the mouse*/
        paintArea.setOnMouseReleased(e->{
            String value = (String) paintType.getValue();
            if(value.equals("Dot")) {
                graphicsContext.lineTo(e.getX(), e.getY());
                graphicsContext.stroke();
                graphicsContext.closePath();
            }

            else if(value.equals("Line")) {
                line.setEndX(e.getX());
                line.setEndY(e.getY());
                graphicsContext.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());


            }
            else if(value.equals("Rectangle")) {
                rectangle.setWidth(Math.abs((e.getX() - rectangle.getX())));
                rectangle.setHeight(Math.abs((e.getY() - rectangle.getY())));
                //rect.setX((rect.getX() > e.getX()) ? e.getX(): rect.getX());
                if(rectangle.getX() > e.getX()) {
                    rectangle.setX(e.getX());
                }
                //rect.setY((rect.getY() > e.getY()) ? e.getY(): rect.getY());
                if(rectangle.getY() > e.getY()) {
                    rectangle.setY(e.getY());
                }

                graphicsContext.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                graphicsContext.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());



            }
            else if(value.equals("Circle")) {
                circle.setRadius((Math.abs(e.getX() - circle.getCenterX()) + Math.abs(e.getY() - circle.getCenterY())) / 2);

                if(circle.getCenterX() > e.getX()) {
                    circle.setCenterX(e.getX());
                }
                if(circle.getCenterY() > e.getY()) {
                    circle.setCenterY(e.getY());
                }

                graphicsContext.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
                graphicsContext.strokeOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());


            }
        });

        /*Eventhandler for changing color*/
        colorPicker.setOnAction(e->{
            graphicsContext.setStroke(colorPicker.getValue());
        });

        /*Eventhandler for changing brushsize*/
        brushSize.valueProperty().addListener(e->{
            double width = brushSize.getValue();
            graphicsContext.setLineWidth(width);
        });



        /*populating parents and starting app*/

        mainBox.getChildren().addAll(menuBox, paintArea);

        Scene scene = new Scene(mainBox);
        stage.setTitle("Tiny Painter");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String args[]){
        launch(args);
    }
}
