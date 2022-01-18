/**Main executing JavaFX application
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompoundInterestFX extends Application {

    /**Main executing method*/
    public static void main(String[] args) {
        launch(args);
    }

    /**GUI start application*/
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setMinWidth(300);
        grid.setMinHeight(200);
        grid.setGridLinesVisible(false);
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(5);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);

        Text compound = new Text("Compound Interest");
        Text amount = new Text("Start amount");
        Text interest = new Text("Interest");
        Text noOfYears = new Text("Number of years");
        Text inTotal = new Text("In total that will be: ");
        Text theTotal = new Text("");

        Button calculate = new Button("Calculate");

        TextField amountInput = new TextField();
        amountInput.setPromptText("Loan amount");
        TextField interestInput = new TextField();
        interestInput.setPromptText("Interest");
        TextField noOfYearsInput = new TextField();
        noOfYearsInput.setPromptText("Loan time");




        GridPane.setConstraints(compound, 2, 1);
        grid.add(compound,0,0);
        grid.add(amount, 0,1);
        grid.add(amountInput,1,1);
        grid.add(interest, 0,2);
        grid.add(interestInput,1,2);
        grid.add(noOfYears, 0,3);
        grid.add(noOfYearsInput,1,3);
        grid.add(calculate, 0,4);
        grid.add(inTotal, 0,5);
        grid.add(theTotal, 1, 5);

        /*Eventhandler for clicking the calculation button*/
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) throws NumberFormatException {
                try {
                    int handledAmount = Integer.parseInt(amountInput.getText());
                    int handledInterest = Integer.parseInt(interestInput.getText());
                    int handledYears = Integer.parseInt(noOfYearsInput.getText());
                    CompoundInterest calculatedInterest = new CompoundInterest(handledAmount, handledInterest, handledYears);
                    theTotal.setText(calculatedInterest.getEndAmount());
                } catch (Exception e) {
                    inTotal.setText("Wrong input");
                }
            }
        });

        Scene scene = new Scene(grid, 300 , 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Compound interest");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();



    }
}
