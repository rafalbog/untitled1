package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Hello World");
        Button button = new Button(" button1");
        Button button2 = new Button();
Label label = new Label("example label");
        RadioButton rb1 = new RadioButton();
        rb1.setText("hello");
        RadioButton rb2 = new RadioButton("calendar");
final ToggleGroup group = new ToggleGroup();
rb1.setToggleGroup(group);
rb1.setSelected(true);
rb2.setToggleGroup(group);
RadioButton rb3 = new RadioButton("contacs");
rb3.setToggleGroup(group);

        TilePane pane =new TilePane();
pane.getChildren().add(label);
        pane.getChildren().add(rb1);
        pane.getChildren().add(rb2);
        pane.getChildren().add(rb3);

        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();



    }




    public static void main(String[] args) {
        launch(args);
    }
}

