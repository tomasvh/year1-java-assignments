/**Main JavaFX application for creating an ugly snowman
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SnowMan extends Application {

    /**Application start*/
    @Override
    public void start(Stage primaryStage) {
    BorderPane pane = new BorderPane();

    pane.setTop(getSunVbox());
    pane.setCenter(getMainVBox());
    pane.setBottom(getMainHBox());






        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**Method to pain an eye*/
    private Circle makeEye() {
        Circle eye = new Circle();
        eye.setFill(Color.BLACK);
        eye.setFill(Color.BLACK);
        eye.setRadius(3);
        return eye;
    }

    /**Method for creating an HBox*/
    private HBox getMainHBox() {
        HBox hBox = new HBox();
            hBox.setPadding(new Insets(70, 70, 70, 70));
            hBox.setStyle("-fx-background-color: white");
            return hBox;
        }


        /**Method for creating the sun*/
        private VBox getSunVbox () {
        VBox sunBox = new VBox();
        sunBox.setAlignment(Pos.TOP_RIGHT);
        sunBox.setStyle("-fx-background-color: blue");

            Circle circleBase = new Circle();
            circleBase.setRadius(50);
            circleBase.setStroke(Color.YELLOW);
            circleBase.setFill(Color.YELLOW);

            sunBox.getChildren().add(circleBase);

            return sunBox;
        }

        /**Method for creaing the main VBox and its children
         *
         * @return vBox VBox
         * */
    private VBox getMainVBox() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: blue");

        StackPane headStack = new StackPane();
        headStack.setAlignment(Pos.CENTER);

        Circle headCircle = new Circle();
        headCircle.setRadius(20);
        headCircle.setStroke(Color.WHITE);
        headCircle.setFill(Color.WHITE);

        VBox headBox = new VBox();
        headBox.setAlignment(Pos.CENTER);

        HBox eyeBox = new HBox(10);
        eyeBox.setAlignment(Pos.BOTTOM_CENTER);
        int numberOfEyes = 2;
        for (int i = 0; i < numberOfEyes; i++) {
            eyeBox.getChildren().add(makeEye());
        }

        VBox mouthBox = new VBox(10);
        mouthBox.setAlignment(Pos.BOTTOM_CENTER);
        mouthBox.setPadding(new Insets(10,10,10,10));

        Rectangle mouth = new Rectangle();
        mouth.setHeight(1);
        mouth.setWidth(10);

        mouthBox.getChildren().add(mouth);
        headBox.getChildren().addAll(eyeBox, mouthBox);
        headStack.getChildren().addAll(headCircle, headBox);



        StackPane bodyStack = new StackPane();
        bodyStack.setAlignment(Pos.CENTER);
        Circle bodyCircle = new Circle();
        bodyCircle.setRadius(40);
        bodyCircle.setStroke(Color.WHITE);
        bodyCircle.setFill(Color.WHITE);

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        int numberOfButtons = 3;
        for (int i = 0; i < numberOfButtons; i++) {
            buttonBox.getChildren().add(makeEye());
        }

        bodyStack.getChildren().addAll(bodyCircle, buttonBox);



        StackPane baseStack = new StackPane();
        baseStack.setAlignment(Pos.CENTER);
        Circle baseCircle = new Circle();
        baseCircle.setRadius(60);
        baseCircle.setStroke(Color.WHITE);
        baseCircle.setFill(Color.WHITE);

        baseStack.getChildren().add(baseCircle);

        vBox.getChildren().addAll(headStack, bodyStack, baseStack);






        return vBox;
    }


    /**Main executing method*/
    public static void main(String[] args) {
        launch(args);
    }


}
