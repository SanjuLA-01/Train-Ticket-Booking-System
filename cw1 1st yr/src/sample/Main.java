package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;

public class Main extends Application {
    static final int SEATING_CAPACITY = 42;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //badulla to colombo details
        HashMap<String,String> nameSeatMap=new HashMap<String, String>(); //using to store customer name and seat number
        ArrayList<String> nameList =new ArrayList<String>(); //using to store customer name

        //colomboto to badulla details
        HashMap<String,String> nameSeatMap_1=new HashMap<String, String>(); //using to store customer name and seat number
        ArrayList<String> nameList_1 =new ArrayList<String>(); //using to store customer name

        File file = new File("slFile.txt"); //using to save and load(badulla to colombo)
        File file1 = new File("slFile1.txt"); //using to save and load(colombo to badulla)

        System.out.println("===== WELCOME TO TRAIN SEAT BOOKING PROGRAM =====");
        System.out.println(" ");
        System.out.println("***** Denuwara Manike A/C Compartment FOR Safe Journey ***** ");
        System.out.println(" ");
        System.out.println(" ");
        console:{
            while(true){
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("================================================================");
                System.out.println("Enter [A/a]----> to add a new customer ");
                System.out.println("Enter [V/v]----> to view all seats ");
                System.out.println("Enter [E/e]----> to view empty seats ");
                System.out.println("Enter [F/f]----> to find a seat by customer ");
                System.out.println("Enter [D/d]----> to delete a seat by customer");
                System.out.println("Enter [O/o]----> to view seats ordered alphabetically by name ");
                System.out.println("Enter [S/s]----> to store the booking details to file ");
                System.out.println("Enter [L/l]----> to load the booking details from file ");
                System.out.println("Enter [Q/q]----> to exit from program ");
                System.out.println("================================================================");
                System.out.println(" ");
                System.out.println(" ");
                Scanner sc= new Scanner(System.in); //Getting user input to recognize what have to do
                System.out.print("Dear Customer, What you want to do: ");
                String userOption= sc.nextLine();
                switch (userOption){
                    case "A":
                    case "a":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer Where is Your Destination---> ");
                        String inputAdd=sc.nextLine();
                        if (inputAdd.equals("1") ){
                            addNewCustomer(nameSeatMap,nameList); //to add a new customer to from badulla to colombo
                        } else if (inputAdd.equals("2")){
                            addNewCustomer(nameSeatMap_1,nameList_1); //to add a new customer colombo to badulla
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "V":
                    case "v":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip Do You Want To View All Seats---> ");
                        String inputView=sc.nextLine();
                        if (inputView.equals("1")){
                            viewAllSeats(nameSeatMap,nameList); //to view available seats and booked seats with different colors (baduula to colombo)
                        } else if (inputView.equals("2")){
                            viewAllSeats(nameSeatMap_1,nameList_1); //to view available seats and booked seats with different colors (colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "E":
                    case "e":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip Do you Want to see Empty Seats---> ");
                        String inputEmpty=sc.nextLine();
                        if (inputEmpty.equals("1")){
                            viewEmptySeats(nameSeatMap,nameList); //to view only empty seats (badulla to colombo)
                        } else if (inputEmpty.equals("2")){
                            viewEmptySeats(nameSeatMap_1,nameList_1); //to view only empty seats (colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "F":
                    case "f":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip We Can Find Your Name---> ");
                        String inputFind=sc.nextLine();
                        if (inputFind.equals("1")){
                            findSeats(nameSeatMap,nameList); //to find a seat by using customer name(badulla to colombo)
                        } else if (inputFind.equals("2")){
                            findSeats(nameSeatMap_1,nameList_1); //to find a seat by using customer name(colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "D":
                    case "d":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip We Can Find Your Name---> ");
                        String inputDelete=sc.nextLine();
                        if (inputDelete.equals("1")){
                            deleteSeats(nameSeatMap,nameList); //to delete a seat by using customer name(badulla to colombo)
                        } else if (inputDelete.equals("2")){
                            deleteSeats(nameSeatMap_1,nameList_1); //to delete a seat by using customer name(colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "O":
                    case "o":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip Do you Want TO See In Alphabetical Order---> ");
                        String inputOrdered=sc.nextLine();
                        if (inputOrdered.equals("1")){
                            viewOrderedList(nameSeatMap,nameList); //to view aplphabetical oreder (badulla to colombo)
                        } else if (inputOrdered.equals("2")){
                            viewOrderedList(nameSeatMap_1,nameList_1); //to view alphabetical order(colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "S":
                    case "s":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip Do You Want To Save---> ");
                        String inputStore=sc.nextLine();
                        if (inputStore.equals("1")){
                            storeFile(nameSeatMap,nameList,file); //to store booking details(badulla to colombo)
                        } else if (inputStore.equals("2")){
                            storeFile(nameSeatMap_1,nameList_1,file1); //to store booking details (colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "L":
                    case "l":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("==== Dear Customer Please Enter 1---->(Badulla to Colombo) ====");
                        System.out.println("==== Dear Customer Please Enter 2---->(Colombo to Badulla) =====");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.print("Dear Customer In Which Trip Do You Want To Load ---> ");
                        String inputLoad=sc.nextLine();
                        if (inputLoad.equals("1")){
                            loadFile(nameSeatMap,nameList,file); //to load booking details(badulla to colombo)
                        } else if (inputLoad.equals("2")){
                            loadFile(nameSeatMap_1,nameList_1,file1); //to load booking details (colombo to badulla)
                        } else {
                            System.out.println("Invalid! Re Enter");
                        }

                        break;
                    case "Q":
                    case "q":
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("====== THANK YOU & GOOD BYE ====== "); //quit from the programme

                        break console;

                    default:
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Invalid! Re enter");
                }
            }
        }
    }

    private void addNewCustomer( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        Stage stage = new Stage();
        stage.setTitle("Welcome to Denuwara Manike A/C compartment");
        BorderPane borderPane=new BorderPane();
        Scene scene = new Scene(borderPane,700,700);
        stage.setScene(scene);

        FlowPane flowPane1= new FlowPane(5,5);                 //get users name
        flowPane1.setPadding(new Insets(10));
        flowPane1.setStyle("-fx-background-color: #dbd335;");
        Label label=new Label("Enter first Name: ");
        TextField textField=new TextField();
        Label label2=new Label("Enter last Name: ");
        TextField textField2=new TextField();
        flowPane1.getChildren().add(label);
        flowPane1.getChildren().add(textField);
        flowPane1.getChildren().add(label2);
        flowPane1.getChildren().add(textField2);
        borderPane.setLeft(flowPane1);

        FlowPane flowPane2=new FlowPane(10,10);                 //prompt 42 seat
        flowPane2.setPadding(new Insets(10));
        flowPane2.setStyle("-fx-background-color: #136e32;");
        for (int i=1;i<= SEATING_CAPACITY;i++){
            Button seatButton=new Button(String.format("%02d",i));
            seatButton.setId(Integer.toString(i));
            seatButton.setStyle("-fx-background-color: \n" +   //CSS to buttons
                    "        #3c7fb1,\n" +
                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                    "    -fx-padding: 3 30 3 30;\n" +
                    "    -fx-font-size: 14px;");
            flowPane2.getChildren().add(seatButton);

            if (nameSeatMap.containsValue(seatButton.getId())){
                seatButton.setDisable(true);
                seatButton.setStyle("-fx-background-color: \n" +
                        "        #b31e26\n" +
                        "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                        "    -fx-padding: 3 30 3 30;\n" +
                        "    -fx-font-size: 14px;");
            }else{
                seatButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (textField.getText().isEmpty() || textField2.getText().isEmpty()){ //checking text field empty or not
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("======To Add a Seat you have to put your first Name first======");
                        }

                        else{
                            String fullName= textField.getText() + " " + textField2.getText();
                            seatButton.setStyle("-fx-background-color: \n" +
                                    "        #413c8f\n" +
                                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                                    "    -fx-padding: 3 30 3 30;\n" +
                                    "    -fx-font-size: 14px;");
                            seatButton.setDisable(true);
                            nameSeatMap.put(fullName,seatButton.getId());
                            nameList.add(fullName);
                            stage.close();
                        }
                    }
                });
            }
        }
        borderPane.setCenter(flowPane2);

        FlowPane flowPane3=new FlowPane();
        flowPane3.setPadding(new Insets(60));
        flowPane3.setStyle("-fx-background-color:#cf5e0e;");
        Label labelTop=new Label("First Put Your Name In TextField After That Select a Seat");
        labelTop.setStyle("-fx-font-size:25px;");
        flowPane3.getChildren().add(labelTop);
        borderPane.setTop(flowPane3);
        stage.showAndWait();
    }

    private void viewAllSeats( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        Stage stage = new Stage();
        stage.setTitle("Welcome to Denuwara Manike A/C compartment");
        BorderPane borderPane=new BorderPane();
        Scene scene = new Scene(borderPane,300,600);
        stage.setScene(scene);

        FlowPane flowPane=new FlowPane(10,10);                 //view booked seats and available seats with different colors
        flowPane.setPadding(new Insets(10));
        flowPane.setStyle("-fx-background-color: #136e32;");
        for (int i=1;i<= SEATING_CAPACITY;i++) {
            Button seatButton = new Button(String.format("%02d", i));
            seatButton.setId(Integer.toString(i));
            seatButton.setStyle("-fx-background-color: \n" +
                    "        #3c7fb1,\n" +
                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                    "    -fx-padding: 3 30 3 30;\n" +
                    "    -fx-font-size: 14px;");
            flowPane.getChildren().add(seatButton);

            if (nameSeatMap.containsValue(seatButton.getId())) {
                seatButton.setDisable(true); //if seat number in hashmap the seat disable
                seatButton.setStyle("-fx-background-color: \n" +
                        "        #b31e26\n" +
                        "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                        "    -fx-padding: 3 30 3 30;\n" +
                        "    -fx-font-size: 14px;");
            }
        }
        borderPane.setCenter(flowPane);
        stage.showAndWait();
    }

    private void viewEmptySeats( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        Stage stage = new Stage();
        stage.setTitle("Welcome to Denuwara Manike A/C compartment");
        BorderPane borderPane=new BorderPane();
        Scene scene = new Scene(borderPane,300,600);
        stage.setScene(scene);

        FlowPane flowPane=new FlowPane(10,10);                 //only view available seats
        flowPane.setPadding(new Insets(10));
        flowPane.setStyle("-fx-background-color: #136e32;");
        for (int i=1;i<= SEATING_CAPACITY;i++) {
            Button seatButton = new Button(String.format("%02d", i));
            seatButton.setId(Integer.toString(i));
            seatButton.setStyle("-fx-background-color: \n" +
                    "        #3c7fb1,\n" +
                    "        linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                    "    -fx-padding: 3 30 3 30;\n" +
                    "    -fx-font-size: 14px;");
            flowPane.getChildren().add(seatButton);

            if (nameSeatMap.containsValue(seatButton.getId())) {
                seatButton.setVisible(false); //if seat number in hashmap then disable seat visible option
            }
        }
        borderPane.setCenter(flowPane);
        stage.showAndWait();
    }

    private void findSeats( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        Scanner sc1=new Scanner(System.in);
        System.out.print("Dear Customer, Please Enter Your full Name: ");
        String userName1=sc1.nextLine();
        if (nameSeatMap.containsKey(userName1)){ //checking the seat by user's name and find from hashmap
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Dear " +userName1+", your seat is "+ nameSeatMap.get(userName1));
            System.out.println("====== THANK YOU ======");
        }else{
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Dear "+userName1+", There is no seat for your name.");
            System.out.println("====== THANK YOU ======");
        }

    }

    private void deleteSeats( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        Scanner sc2= new Scanner(System.in);
        System.out.print("Dear Customer, Please Enter Your full Name: ");
        String userName2=sc2.nextLine();
        if(nameSeatMap.containsKey(userName2)){ //checking the seat by user's name and remove from hashmap
            nameSeatMap.remove(userName2);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Successfully Deleted");
            System.out.println("====== THANK YOU ======");
        }else{
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Dear "+userName2+", There is no seat for your name.");
            System.out.println("====== THANK YOU ======");
        }
    }

    private void viewOrderedList( HashMap<String,String> nameSeatMap,ArrayList<String> nameList) {
        System.out.println("===== Names       AND        Seats =====");
        String temp;
        for(int i=0;i<nameList.size();i++) {
            for (int j = i + 1; j < nameList.size(); j++) {  //used bubble sort method
                if (nameList.get(j).compareTo(nameList.get(i)) < 0) {
                    temp = nameList.get(i);
                    nameList.set(i, nameList.get(j));
                    nameList.set(j, temp);
                }
            }
        }
        for (String listName: nameList){
            for (Object hMapName: nameSeatMap.keySet()){
                if (hMapName.equals(listName)){
                    System.out.println(" ");
                    System.out.println("     "+listName + "       :        "+  nameSeatMap.get(listName));
                }
            }
        }
    }

    private void storeFile( HashMap<String,String> nameSeatMap,ArrayList<String> nameList,File file) throws IOException {
        //write data line by line from hashmap to file
        BufferedWriter writer=new BufferedWriter(new FileWriter(file));
        for(HashMap.Entry<String,String> entry: nameSeatMap.entrySet()){
            writer.write(entry.getKey()+"\n"); writer.write(entry.getValue()+"\n");
        }
        System.out.println("===== Successfully Stored =====");
        writer.close();
    }

    private void loadFile(HashMap<String,String> nameSeatMap, ArrayList<String> nameList,File file) throws IOException {
        //read data from file to hashmap line by line
        BufferedReader reader= new BufferedReader(new FileReader(file));
        String line;
        int x=1;
        String key=null; String value=null;
        while ((line=reader.readLine()) !=null){
            if (x%2==1){
                key=line;
            }else{
                value = line;
                nameSeatMap.put(key,value);
            }
            x=x+1;
        }
        System.out.println(nameSeatMap);
        System.out.println("===== Successfully Loaded =====");
        reader.close();

    }

    public static void main(String[]args){
        launch();
    }
}