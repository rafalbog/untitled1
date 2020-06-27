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
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Add Acces Point");

        Button button = new Button(" button1");
        Button button2 = new Button("button2");

        HBox hbox = new HBox(button, button2);
HBox.setHgrow(button, Priority.ALWAYS);

        Button button1 = new Button("radiobuta");

        Text text1 = new Text("IP Address");
        Text text2 = new Text("Network Name");
Text Acces_point_location = new Text("Acces point location");
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button buttona = new Button("Submit");
        Button buttonb = new Button("Clear");

        TextArea textArea = new TextArea();

        textArea.setText("dasdasdsadsadsa");
        HBox  verticalbox = new HBox(textArea);
String dot=".";
        Label label = new Label("ipv4 or ipv6");
Label ipvtry = new Label("");

Label ipstatus = new Label(".");
        VBox verticalBox = new VBox(ipvtry, ipstatus);

        RadioButton rb1 = new RadioButton();
        rb1.setText("hello");
        RadioButton rb2 = new RadioButton("calendar");
final ToggleGroup group = new ToggleGroup();
rb1.setToggleGroup(group);
rb1.setSelected(true);
rb2.setToggleGroup(group);
RadioButton rb3 = new RadioButton("contacs");
rb3.setToggleGroup(group);
        Circle circle = new Circle(4,4,4);


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

        if(textField2.getText()=="")            textField2.setStyle("-fx-background-color: #ff0000; ");
 else   label.setText( is_ipv4_ipv6_or_not(textField2.getText()));
//String addres4 = textField2.getText();
 //InetAddress some = new InetAddress.getByName(addres4);

        String partial_ipv4=textField2.getText().substring(0, textField2.getText().lastIndexOf("."));
        String end_ipv4=  textField2.getText().substring(textField2.getText().lastIndexOf(".")+1);
String helpfull_string;

ip_check[] tryna= new  ip_check [10];
ipstatus.setFont(Font.font(300));
for (int i=0; i<10;i++){
    helpfull_string= partial_ipv4+"."+Integer.toString(Integer.parseInt(end_ipv4)+i);

    tryna[i]= new ip_check(helpfull_string);
    tryna[i].run();
    textArea.appendText(tryna[i].getResult());
ipvtry.setText(ipvtry.getText()+"\r\n"+tryna[i].getResult());
if (tryna[i].alive_not)
{

    ipstatus.setStyle("-fx-text-fill: green");
ipstatus.setText(".");
}
else {
    ipstatus.setStyle("-fx-text-fill: red");
    ipstatus.setText(".");

}

//    label.setGraphic();



}





//// dac koilor jezeli puste jet



    }
});









// gridpane w opisie aplikacji okienek, do grida dodajemy buttony, hboxy, vboxy calosc ladnie widoczna
        primaryStage.show();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(300, 900);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.TOP_CENTER);
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
        gridPane.add( label, 4,1);
        gridPane.add(verticalbox, 1, 4);
//gridPane.add(circle,4,4);

gridPane.add(verticalBox, 1,5);

        primaryStage.setScene(new Scene(gridPane));




    }




    public static void main(String[] args) {
        launch(args);


    }

public static String is_ipv4_ipv6_or_not (String addres){


    try {
        InetAddress address2 = InetAddress.getByName(addres);


        if(address2 instanceof Inet4Address) {addres="ipv4";}
        else if (address2 instanceof Inet6Address)
        {

            addres="ipv6";


        }

    } catch (java.net.UnknownHostException e) {
        {  addres= "not valid";}
    }



    return addres;

    }



}




class ip_check extends Thread {



    String result="";




    public String getIpv4() {
        return ipv4;
    }
    public String getResult() {return result;}
    public ip_check(String ipv4){
        this.ipv4 =ipv4;
    }
    //  public void setIpv4(String ipv4) {
    //     this.ipv4 = ipv4;
    // }
    String ipv4;
 boolean alive_not=false;

    public boolean get_circle_result(){
   return  alive_not;


 }

    public ip_check() { ipv4 = ""; }

    public void run() {
        try { InetAddress ipv4_innet_check = InetAddress.getByName(ipv4);

            if (ipv4_innet_check.isReachable(1000))
            {  alive_not=true;
                result="\r\n address " + ipv4 + " is alive ";}

              else{ alive_not=false;
                  result=" \r\n address " + ipv4 + " is ded  ";}

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}


