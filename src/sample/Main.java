package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Hello World");

        Button button = new Button(" button1");
        Button button2 = new Button("button2");

        HBox hbox = new HBox(button, button2);
HBox.setHgrow(button, Priority.ALWAYS);


        Button button1 = new Button("radiobuta");

        Text text1 = new Text("some test");
        Text text2 = new Text("test2");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button buttona = new Button("Submit");
        Button buttonb = new Button("Clear");



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

buttona.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {


    if (textField1.getText().equals(""))
      textField1.setText("fill some data");
        try {try {
            InetAddress ipv4_innet_check = InetAddress.getByName(textField1.getText());
            if (ipv4_innet_check.isReachable(1000)) textField2.setText("alive");
            else textField2.setText("no alive");
        } catch (UnknownHostException e){e.printStackTrace();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



});
// radiobuta
button1.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {

//// dac koilor jezeli puste jet

    }
});






// gridpane w opisie aplikacji okienek, do grida dodajemy buttony, hboxy, vboxy calosc ladnie widoczna
        primaryStage.show();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 300);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);
        gridPane.add(buttona, 0, 2);
        gridPane.add(buttonb, 1, 2);
        gridPane.add(button1, 1,3);
        gridPane.add(rb1, 2,3);
        gridPane.add(rb2, 3,3);
        gridPane.add(hbox, 4,4);
        primaryStage.setScene(new Scene(gridPane));




    }




    public static void main(String[] args) {
        launch(args);


    }
}





