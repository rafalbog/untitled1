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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.rmi.UnknownHostException;
import java.util.ArrayList;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Add Acces Point");

        Button button = new Button(" button1");
        Button button2 = new Button("button2");


        Button add_new = new Button("add new");

int number_of_stacked_ip_addresess=0;
        ArrayList stack_all_ip_addreses=  new ArrayList();
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
        HBox lets_try_to_add_button_and_text = new HBox();
        FlowPane lets_try_to_add_button_and_text_inflowpane = new FlowPane(4,8);

        lets_try_to_add_button_and_text_inflowpane.setPrefWrapLength(220);

        TextArea textArea = new TextArea();


        textArea.setText("dasdasdsadsadsa");
        HBox  verticalbox = new HBox(textArea);



        HBox  verbox_ipp_added_from_second_window = new HBox();

        Label label = new Label("ipv4 or ipv6");
Label ipvtry = new Label("");

Label ipstatus = new Label(".");
        HBox horizoBox = new HBox();
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
            if (ipv4_innet_check.isReachable(1000)) {
                textField2.setText("alive");
                   Button alive_b = new Button("alive");

            }
            else {
                textField2.setText("no alive");
                Button alive_b = new Button("no alive");
                textArea.getChildrenUnmodifiable().addAll(alive_b) ;

            }

        } catch (UnknownHostException e){e.printStackTrace();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



});
lets_try_to_add_button_and_text.getChildren().addAll(add_new);

add_new.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {

       if (add_new.getText()=="clicked")
           add_new.setText("add new");
               else {
           add_new.setText("clicked");


          String ipv_test= open_window_method(primaryStage);

textField2.setText(ipv_test);


/*


GridPane second_window_grid = new GridPane();
StackPane window_secondo = new StackPane();
window_secondo.getChildren().addAll(second_window_grid);


           Scene window_new = new Scene(window_secondo,400,400);
Stage open_da_window_Stage = new Stage();
open_da_window_Stage.setScene(window_new);

open_da_window_Stage.setTitle("2nd window opened");

Button button_add_2nd_window = new Button("ADD");
Button button_cancel_2nd_window = new Button("CANCEL");
HBox hbox_2nd_window_but= new HBox();
hbox_2nd_window_but.getChildren().addAll(button_add_2nd_window, button_cancel_2nd_window);



Label label_IP_addres_label_2nd_win = new Label("* IP Address");
           Label label_Network_name_2nd_win = new Label("*Network Name:");
Label label_Acces_point_location_2nd_win= new Label("AccessPoint Location");

Label label_Device_name_2nd_win = new Label("Device Name");


TextField text_IP_addres_label_2nd_win  = new TextField();
           TextField text_Network_name_2nd_win  = new TextField();
           TextField   text_Acces_point_location_2nd_win= new TextField();
           TextField  text_Device_name_2nd_win = new TextField();

second_window_grid.setAlignment(Pos.CENTER);
second_window_grid.setPadding(new Insets(15,15,15,15));
second_window_grid.setVgap(15);
second_window_grid.setHgap(30);
second_window_grid.add(label_IP_addres_label_2nd_win, 0,0);
second_window_grid.add(text_IP_addres_label_2nd_win, 1,0);
           second_window_grid.add(label_Network_name_2nd_win, 0,1);
           second_window_grid.add(text_Network_name_2nd_win, 1,1);

           second_window_grid.add(label_Acces_point_location_2nd_win, 0,2);
           second_window_grid.add(text_Acces_point_location_2nd_win, 1,2);
           second_window_grid.add(label_Device_name_2nd_win, 0,3);
           second_window_grid.add(text_Device_name_2nd_win,1,3);
           hbox_2nd_window_but.setAlignment(Pos.CENTER_RIGHT);
second_window_grid.add(hbox_2nd_window_but, 1,4);



           open_da_window_Stage.setY(primaryStage.getY()+50);
           open_da_window_Stage.setX(primaryStage.getX()+50);
           open_da_window_Stage.show();



           button_add_2nd_window.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
if (!text_Network_name_2nd_win.getText().trim().isEmpty()){
if (text_IP_addres_label_2nd_win.getText().trim().isEmpty())
{
text_IP_addres_label_2nd_win.setText("enter value");
    label_IP_addres_label_2nd_win.setTextFill(Color.web("#0076a3"));

}
else {
    InetAddress add_addres_2nd_window = null;
    try {
        add_addres_2nd_window = InetAddress.getByName(text_IP_addres_label_2nd_win.getText());
    } catch (java.net.UnknownHostException e) {
        e.printStackTrace();
    }

    if (!((add_addres_2nd_window instanceof  Inet6Address)||(add_addres_2nd_window instanceof  Inet4Address))){

        text_IP_addres_label_2nd_win.setText(text_IP_addres_label_2nd_win.getText()+" enter valid ip address");
        label_IP_addres_label_2nd_win.setTextFill(Color.web("#0076a3"));


        stack_all_ip_addreses.add(text_IP_addres_label_2nd_win.getText()+";"+text_Network_name_2nd_win);

        try {
            try {



InetAddress ipv4_innet_check_2nd_window =  InetAddress.getByName(text_IP_addres_label_2nd_win.getText());

        if (ipv4_innet_check_2nd_window.isReachable(1000)) {
            textField2.setText("alive");
            Button alive_b = new Button("alive");

        }
        else {
            textField2.setText("no alive");
            Button alive_b = new Button("no alive");
            textArea.getChildrenUnmodifiable().addAll(alive_b) ;

        } } catch (java.net.UnknownHostException e){e.printStackTrace();}
        }
        catch (IOException e){
            e.printStackTrace();

        }


        open_da_window_Stage.close();


    }





}} else label_Network_name_2nd_win.setTextFill(Color.web("#0076a3"));



               }
           });

*/




       }

    }
});

// radiobuta
button1.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {

        if (textField2.getText().trim().isEmpty()) textField2.setStyle("-fx-background-color: #ff0000; ");
        else label.setText(is_ipv4_ipv6_or_not(textField2.getText()));


        String partial_ipv4 = textField2.getText().substring(0, textField2.getText().lastIndexOf("."));
        String end_ipv4 = textField2.getText().substring(textField2.getText().lastIndexOf(".") + 1);
        String helpfull_string;

        ip_check[] tryna = new ip_check[10];

        for (int i = 0; i < 10; i++) {
            helpfull_string = partial_ipv4 + "." + Integer.toString(Integer.parseInt(end_ipv4) + i);
            tryna[i] = new ip_check(helpfull_string);
            tryna[i].run();
            //   textArea.appendText(tryna[0].getResult());
//ipvtry.setText(tryna[0].getResult());
            Label [] text_with_ip = new Label[10];
            text_with_ip[i]= new Label();

            text_with_ip[i].setText(tryna[i].getResult());
            Button [] aliveabc= new Button[10];
            aliveabc[i]= new Button();


            if (tryna[i].getResult().contains("alive")) {
                aliveabc[i] = new Button("alive");
                lets_try_to_add_button_and_text_inflowpane.getChildren().addAll(text_with_ip[i], aliveabc[i]);

            } else {
                aliveabc[i]  = new Button("ded");
                lets_try_to_add_button_and_text_inflowpane.getChildren().addAll(text_with_ip[i], aliveabc[i]);
            }


//    label.setGraphic();


//}
           // horizoBox.getChildren().addAll(ipvtry);


//// dac koilor jezeli puste jet


        }
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
        gridPane.add(lets_try_to_add_button_and_text, 1,7);
        gridPane.add(lets_try_to_add_button_and_text_inflowpane, 1, 6);
        gridPane.add(verbox_ipp_added_from_second_window, 1,8);
      //  gridPane.add(verticalbox, 1, 4);
//gridPane.add(circle,4,4);

gridPane.add(horizoBox, 1,5);

        primaryStage.setScene(new Scene(gridPane));






    }




    public static void main(String[] args) {
        launch(args);


    }
    public static String open_window_method (Stage primaryStage){

        GridPane second_window_grid = new GridPane();
        StackPane window_secondo = new StackPane();
        window_secondo.getChildren().addAll(second_window_grid);


        Scene window_new = new Scene(window_secondo,400,400);
        Stage open_da_window_Stage = new Stage();
        open_da_window_Stage.setScene(window_new);

        open_da_window_Stage.setTitle("2nd window opened");

        Button button_add_2nd_window = new Button("ADD");
        Button button_cancel_2nd_window = new Button("CANCEL");
        HBox hbox_2nd_window_but= new HBox();
        hbox_2nd_window_but.getChildren().addAll(button_add_2nd_window, button_cancel_2nd_window);



        Label label_IP_addres_label_2nd_win = new Label("* IP Address");
        Label label_Network_name_2nd_win = new Label("*Network Name:");
        Label label_Acces_point_location_2nd_win= new Label("AccessPoint Location");

        Label label_Device_name_2nd_win = new Label("Device Name");


        TextField text_IP_addres_label_2nd_win  = new TextField();
        TextField text_Network_name_2nd_win  = new TextField();
        TextField   text_Acces_point_location_2nd_win= new TextField();
        TextField  text_Device_name_2nd_win = new TextField();

        second_window_grid.setAlignment(Pos.CENTER);
        second_window_grid.setPadding(new Insets(15,15,15,15));
        second_window_grid.setVgap(15);
        second_window_grid.setHgap(30);
        second_window_grid.add(label_IP_addres_label_2nd_win, 0,0);
        second_window_grid.add(text_IP_addres_label_2nd_win, 1,0);
        second_window_grid.add(label_Network_name_2nd_win, 0,1);
        second_window_grid.add(text_Network_name_2nd_win, 1,1);

        second_window_grid.add(label_Acces_point_location_2nd_win, 0,2);
        second_window_grid.add(text_Acces_point_location_2nd_win, 1,2);
        second_window_grid.add(label_Device_name_2nd_win, 0,3);
        second_window_grid.add(text_Device_name_2nd_win,1,3);
        hbox_2nd_window_but.setAlignment(Pos.CENTER_RIGHT);
        second_window_grid.add(hbox_2nd_window_but, 1,4);



        open_da_window_Stage.setY(primaryStage.getY()+50);
        open_da_window_Stage.setX(primaryStage.getX()+50);
        open_da_window_Stage.show();


        final String[] ipv4_innet = new String[1];
        button_add_2nd_window.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!text_Network_name_2nd_win.getText().trim().isEmpty()){
                    if (text_IP_addres_label_2nd_win.getText().trim().isEmpty())
                    {
                        text_IP_addres_label_2nd_win.setText("enter value");
                        label_IP_addres_label_2nd_win.setTextFill(Color.web("#0076a3"));

                    }
                    else {
                        InetAddress add_addres_2nd_window = null;
                        try {
                            add_addres_2nd_window = InetAddress.getByName(text_IP_addres_label_2nd_win.getText());
                        } catch (java.net.UnknownHostException e) {
                            e.printStackTrace();
                        }

                        if (!((add_addres_2nd_window instanceof  Inet6Address)||(add_addres_2nd_window instanceof  Inet4Address))){

                            text_IP_addres_label_2nd_win.setText(text_IP_addres_label_2nd_win.getText()+" enter valid ip address");
                            label_IP_addres_label_2nd_win.setTextFill(Color.web("#0076a3"));




                        }


else {



                            ipv4_innet[0] = text_IP_addres_label_2nd_win.getText();

                        }







                    }} else label_Network_name_2nd_win.setTextFill(Color.web("#0076a3"));



            }
        });


        return ipv4_innet[0];

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


