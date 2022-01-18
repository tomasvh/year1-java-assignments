/**JavaFX Norse Gods application
 *
 * @Author Tomas Marx-Raacz von Hidveg
 * @version 1.0
 *
 * */

package exercise_7;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;



public class NorseGodsMain extends Application {


    @Override
    public void start(Stage stage) {
        /* Creator of the godlist */
        NorseGodCreater creator = new NorseGodCreater();

        /* Creating the godlist */
        ObservableList<NorseGod> godList = creator.creator(FXCollections.observableArrayList());

        /* ToggleGroup for the buttons for the gods */
        ToggleGroup godListButtons = new ToggleGroup();


        /* Creation, naming and setting of togglebuttons to group */
        ToggleButton toggleButton0 = new ToggleButton("Odin");
        ToggleButton toggleButton1 = new ToggleButton("Frigg");
        ToggleButton toggleButton2 = new ToggleButton("Thor");
        ToggleButton toggleButton3 = new ToggleButton("Baldr");
        ToggleButton toggleButton4 = new ToggleButton("Loki");
        ToggleButton toggleButton5 = new ToggleButton("Ymir");
        ToggleButton toggleButton6 = new ToggleButton("Mimir");
        ToggleButton toggleButton7 = new ToggleButton("Heimdallr");

        toggleButton0.setToggleGroup(godListButtons);
        toggleButton1.setToggleGroup(godListButtons);
        toggleButton2.setToggleGroup(godListButtons);
        toggleButton3.setToggleGroup(godListButtons);
        toggleButton4.setToggleGroup(godListButtons);
        toggleButton5.setToggleGroup(godListButtons);
        toggleButton6.setToggleGroup(godListButtons);
        toggleButton7.setToggleGroup(godListButtons);


        /* creating section for content text */
        Text contentText = new Text();
        contentText.setWrappingWidth(700);

        /* Main window*/
        VBox mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER_LEFT);
        mainBox.setMinWidth(800);
        mainBox.setMinHeight(600);
        mainBox.setSpacing(10);

        /* Large title */
        Label largeTitle = new Label("Norse God and other Beings");
        largeTitle.setAlignment(Pos.CENTER_LEFT);
        largeTitle.setFont(new Font(24));

        /* Menu and content box */
        HBox menuAndDisplayBox = new HBox();
        menuAndDisplayBox.setMinWidth(800);
        menuAndDisplayBox.setMinHeight(550);
        menuAndDisplayBox.setAlignment(Pos.BOTTOM_CENTER);
        menuAndDisplayBox.setSpacing(10);

        /* menu box */
        VBox menu = new VBox();
        menu.setAlignment(Pos.TOP_LEFT);
        menu.setSpacing(10);
        menu.setMinHeight(550);
        menu.setMinWidth(80);

        /* content box*/
        ScrollPane textpane = new ScrollPane();
        textpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        textpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        textpane.setMinHeight(550);
        textpane.setMinWidth(720);


        /* assignment of various children */
        textpane.setContent(contentText);
        menu.getChildren().addAll(toggleButton0, toggleButton1, toggleButton2, toggleButton3, toggleButton4, toggleButton5, toggleButton6, toggleButton7);
        menuAndDisplayBox.getChildren().addAll(menu, textpane);
        mainBox.getChildren().addAll(largeTitle, menuAndDisplayBox);

        Scene scene = new Scene(mainBox);
        stage.setTitle("Norse Gods");
        stage.setScene(scene);
        stage.show();


        /* eventhandlers to change content text in reference to the togglebuttons */
        toggleButton0.setOnAction(e -> {
            if (toggleButton0.isSelected()) {
                contentText.setText(godList.get(0).getName() + "\n" + godList.get(0).getRace() + "\n\n" + godList.get(0).getDesc());
            }
        });

        toggleButton1.setOnAction(e -> {
            if (toggleButton1.isSelected()) {
                contentText.setText(godList.get(1).getName() + "\n" + godList.get(1).getRace() + "\n" + godList.get(1).getDesc());
            }
        });

        toggleButton2.setOnAction(e -> {
            if (toggleButton2.isSelected()) {
                contentText.setText(godList.get(2).getName() + "\n" + godList.get(2).getRace() + "\n" + godList.get(2).getDesc());
            }
        });

        toggleButton3.setOnAction(e -> {
            if (toggleButton3.isSelected()) {
                contentText.setText(godList.get(3).getName() + "\n" + godList.get(3).getRace() + "\n" + godList.get(3).getDesc());
            }
        });

        toggleButton4.setOnAction(e -> {
            if (toggleButton4.isSelected()) {
                contentText.setText(godList.get(4).getName() + "\n" + godList.get(4).getRace() + "\n" + godList.get(4).getDesc());
            }
        });

        toggleButton5.setOnAction(e -> {
            if (toggleButton5.isSelected()) {
                contentText.setText(godList.get(5).getName() + "\n" + godList.get(5).getRace() + "\n" + godList.get(5).getDesc());
            }
        });

        toggleButton6.setOnAction(e -> {
            if (toggleButton6.isSelected()) {
                contentText.setText(godList.get(6).getName() + "\n" + godList.get(6).getRace() + "\n" + godList.get(6).getDesc());
            }
        });

        toggleButton7.setOnAction(e -> {
            if (toggleButton7.isSelected()) {
                contentText.setText(godList.get(7).getName() + "\n" + godList.get(7).getRace() + "\n" + godList.get(7).getDesc());
            }
        });


    }
    public static void main (String[]args){
        launch(args);
    }
}


