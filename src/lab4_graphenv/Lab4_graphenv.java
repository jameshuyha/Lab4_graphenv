package lab4_graphenv;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Git Repository: https://github.com/jameshuyha/Lab4_graphenv.git
 * @author 6324151
 */
public class Lab4_graphenv extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create BorderPane and GridPane
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        root.setCenter(gridPane);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // Create labels
        Label daysLabel = new Label("Days on the Trip: ");
        Label airfareLabel = new Label("Airfare ($): ");
        Label carFeesLabel = new Label("Car Rental Fees ($): ");
        Label milesLabel = new Label("Miles Driven (Private Vehicle Only): ");
        Label parkingLabel = new Label("Parking Fees ($): ");
        Label taxiLabel = new Label("Taxi Charges ($): ");
        Label conferenceLabel = new Label("Conference/Seminar Registration Fees ($): ");
        Label lodgingLabel = new Label("Lodging Charges ($/night): ");
        
        // Add labels to GridPane
        gridPane.add(daysLabel, 0, 0);
        gridPane.add(airfareLabel, 0, 1);
        gridPane.add(carFeesLabel, 0, 2);
        gridPane.add(milesLabel, 0, 3);
        gridPane.add(parkingLabel, 0, 4);
        gridPane.add(taxiLabel, 0, 5);
        gridPane.add(conferenceLabel, 0, 6);
        gridPane.add(lodgingLabel, 0, 7);
        
        // Create text fields
        TextField daysField = new TextField();
        TextField airfareField = new TextField();
        TextField carFeesField = new TextField();
        TextField milesField = new TextField();
        TextField parkingField = new TextField();
        TextField taxiField = new TextField();
        TextField conferenceField = new TextField();
        TextField lodgingField = new TextField();
        
        // Add text fields to GridPane
        gridPane.add(daysField, 1, 0);
        gridPane.add(airfareField, 1, 1);
        gridPane.add(carFeesField, 1, 2);
        gridPane.add(milesField, 1, 3);
        gridPane.add(parkingField, 1, 4);
        gridPane.add(taxiField, 1, 5);
        gridPane.add(conferenceField, 1, 6);
        gridPane.add(lodgingField, 1, 7);
        
        // Create buttons
        Button calculateButton = new Button("Calculate");
        Button clearButton = new Button("Clear");

        // Add buttons to GridPane
        gridPane.add(calculateButton, 0, 8);
        gridPane.add(clearButton, 1, 8);
        
         // Disable calculate by default
        calculateButton.setDisable(true);
        

        // Disable register if clear is clicked
        clearButton.setOnMouseClicked(e -> {
            daysField.clear();
            airfareField.clear();
            carFeesField.clear();
            milesField.clear();
            parkingField.clear();
            taxiField.clear();
            conferenceField.clear();
            lodgingField.clear();
            calculateButton.setDisable(true);
            carFeesField.setDisable(false);
            milesField.setDisable(false);
        });
        
        // Enable calculate once days field is filled
        EventHandler textFieldHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (!daysField.getText().isEmpty()) {
                    calculateButton.setDisable(false);
                } else {
                    calculateButton.setDisable(true);
                }
                
                if (!carFeesField.getText().isEmpty()) {
                    milesField.setDisable(true);
                } else {
                    milesField.setDisable(false);
                }
                
                if (!milesField.getText().isEmpty()) {
                    carFeesField.setDisable(true);
                } else {
                    carFeesField.setDisable(false);
                }
            }
        };
        
        EventHandler calculateHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
            }
        };
        
        // Enable textFieldHandler & calculateHandler on all text fields and register
        daysField.setOnKeyReleased(textFieldHandler);
        carFeesField.setOnKeyReleased(textFieldHandler);
        milesField.setOnKeyReleased(textFieldHandler);
        calculateButton.setOnMouseClicked(calculateHandler);
        
        // Add and show scene
        Scene scene = new Scene(root, 450, 350);
        primaryStage.setTitle("Business Travel Expenses Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
