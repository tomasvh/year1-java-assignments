/**
 * Main executing JavaFX application for Yahtzee dice.
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 *
 * */


package exercise_8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YahtzeeFX extends Application {

    /**
     * Method for randomizing a six sided dice roll
     *
     * @return int
     * */
    public static int randomNumber(){
        return (int) Math.floor(Math.random()*6+1);
    }



    /**
     * Method for changing the image every time a dice is rolled and changing its value in the diceArray
     *
     * @param diceArray List
     * @param index int
     * @param check checkbox
     * @param view ImageView
     * @param dice1 Dice
     * @param dice2 Dice
     * @param dice3 Dice
     * @param dice4 Dice
     * @param dice5 Dice
     * @param dice6 Dice
     *
     * @retun void
     * */
    public static void rollDice(List<Integer> diceArray, int index, CheckBox check, ImageView view, Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5, Dice dice6){
        if (!check.isSelected()){
            switch (randomNumber()) {
                case 1:
                    view.setImage(dice1.getImage());
                    diceArray.set(index, dice1.getValue());

                    break;
                case 2:
                    view.setImage(dice2.getImage());
                    diceArray.set(index, dice2.getValue());
                    break;
                case 3:
                    view.setImage(dice3.getImage());
                    diceArray.set(index, dice3.getValue());
                    break;
                case 4:
                    view.setImage(dice4.getImage());
                    diceArray.set(index, dice4.getValue());
                    break;
                case 5:
                    view.setImage(dice5.getImage());
                    diceArray.set(index, dice5.getValue());
                    break;
                case 6:
                    view.setImage(dice6.getImage());
                    diceArray.set(index, dice6.getValue());


            }

        }


            System.out.println(randomNumber());


    }

    /**Main executing method*/
    public static void main(String[] args) {
        launch(args);
    }

    /**GUI application start*/
    @Override
    public void start(Stage primaryStage) {

        final String dir = System.getProperty("user.dir");
        ArrayList<Integer> diceArray = new ArrayList<>();

        GridPane grid = new GridPane();
        grid.setMinWidth(350);
        grid.setMinHeight(200);
        grid.setGridLinesVisible(false);
        grid.setPadding(new Insets(5,5,5,5));
        grid.setVgap(5);
        grid.setHgap(20);
        grid.setAlignment(Pos.CENTER);

        Text header = new Text("Yahtzee");
        header.setStyle("-fx-font-size: 20");
        HBox resultbox = new HBox();
        Text result = new Text("Rolls left: ");
        Text rollsLeft = new Text("3");

        Button roll = new Button("Roll the dice!");

        CheckBox check1 = new CheckBox();
        CheckBox check2 = new CheckBox();
        CheckBox check3 = new CheckBox();
        CheckBox check4 = new CheckBox();
        CheckBox check5 = new CheckBox();



        Image tempDice1 = null;
        Image tempDice2 = null;
        Image tempDice3 = null;
        Image tempDice4 = null;
        Image tempDice5 = null;
        Image tempDice6 = null;
        try {
            tempDice1 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice1.jpg"), 40, 40, false, false);
            tempDice2 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice2.jpg"), 40, 40, false, false);
            tempDice3 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice3.jpg"), 40, 40, false, false);
            tempDice4 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice4.jpg"), 40, 40, false, false);
            tempDice5 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice5.jpg"), 40, 40, false, false);
            tempDice6 = new Image(new FileInputStream(dir+"/src/exercise_8/img/dice6.jpg"), 40, 40, false, false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final Dice dice1 = new Dice (tempDice1, 1);
        final Dice dice2 = new Dice (tempDice2, 2);
        final Dice dice3 = new Dice (tempDice3, 3);
        final Dice dice4 = new Dice (tempDice4, 4);
        final Dice dice5 = new Dice (tempDice5, 5);
        final Dice dice6 = new Dice (tempDice6, 6);




        ImageView imageView1 = new ImageView(dice1.getImage());
        diceArray.add(dice1.getValue());
        ImageView imageView2 = new ImageView(dice2.getImage());
        diceArray.add(dice2.getValue());
        ImageView imageView3 = new ImageView(dice3.getImage());
        diceArray.add(dice3.getValue());
        ImageView imageView4 = new ImageView(dice4.getImage());
        diceArray.add(dice4.getValue());
        ImageView imageView5 = new ImageView(dice5.getImage());
        diceArray.add(dice5.getValue());

        GridPane.setConstraints(header, 1, 1,2,1);
        GridPane.setConstraints(roll, 1, 1,2,1);
        GridPane.setConstraints(resultbox,1,1,3,2);


        grid.add(header,0,0);

        grid.add(imageView1, 0,1);
        grid.add(imageView2, 1,1);
        grid.add(imageView3, 2,1);
        grid.add(imageView4, 3,1);
        grid.add(imageView5, 4,1);


        grid.add(check1, 0,2);
        grid.add(check2, 1,2);
        grid.add(check3, 2,2);
        grid.add(check4, 3,2);
        grid.add(check5, 4,2);


        grid.add(roll, 0,3);
        resultbox.getChildren().addAll(result,rollsLeft);
        grid.add(resultbox, 2, 3);

        /*
        Event handler for pushing the button.
         */
        roll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {


                    int workingRollsLeft = Integer.parseInt(rollsLeft.getText());
                    if (workingRollsLeft != 0) {
                        rollDice(diceArray, 0, check1, imageView1, dice1, dice2, dice3, dice4, dice5, dice6);
                        rollDice(diceArray, 1, check2, imageView2, dice1, dice2, dice3, dice4, dice5, dice6);
                        rollDice(diceArray, 2, check3, imageView3, dice1, dice2, dice3, dice4, dice5, dice6);
                        rollDice(diceArray, 3, check4, imageView4, dice1, dice2, dice3, dice4, dice5, dice6);
                        rollDice(diceArray, 4, check5, imageView5, dice1, dice2, dice3, dice4, dice5, dice6);


                        workingRollsLeft--;
                        if (workingRollsLeft == 0) {
                            roll.setText("Calculate results");
                        }
                    } else {
                        roll.setText("Game over");
                        Map<Integer, Integer> diceMap = new HashMap<>();
                        for (Integer dice : diceArray) {
                            if (diceMap.containsKey(dice)) {
                                int counts = diceMap.get(dice);
                                diceMap.replace(dice, counts + 1);

                            } else {
                                diceMap.put(dice, 1);
                            }

                        }

                        resultbox.getChildren().remove(1);
                        StringBuilder str = new StringBuilder();
                        str.append("you rolled: ");
                        for (Integer diceValue : diceMap.keySet()) {
                            str.append(diceMap.get(diceValue) + " " + diceValue + "s");
                            str.append(" and ");
                        }
                        str.delete(str.length() - 5, str.length());

                        result.setText(str.toString());

                        System.out.println(diceMap.toString());


                    }


                    rollsLeft.setText("" + workingRollsLeft);
                } catch (Exception e) {
                    System.out.println("Game over...");
                }
            }
        });


        Scene scene = new Scene(grid, 350 , 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Yahtzee");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
