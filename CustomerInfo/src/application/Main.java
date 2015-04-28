package application;
	


import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
			"Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
			"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
			"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
			"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
			"Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
			"New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
			"Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
			"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
			"Washington", "West Virginia", "Wisconsin", "Wyoming"};
	
	private ComboBox<String> stateBox = new ComboBox<>();
	
	Button btSAVE = new Button("SAVE");
	Button btCLEAR = new Button("CLEAR");
	
	TextField firstField = new TextField();
	TextField middleField = new TextField();
	TextField lastField = new TextField();
	TextField addressField = new TextField();
	TextField cityField = new TextField();
	
	final ToggleGroup genderGroup = new ToggleGroup();
    RadioButton maleButton = new RadioButton("Male");

    
    RadioButton femaleButton = new RadioButton("Female");
   
	
	PasswordField zipField = new PasswordField();
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Border Pane
			BorderPane root = new BorderPane();
			//GridPanes and Labels
			GridPane grid = new GridPane();
			Label first = new Label("First Name:");
			Label middle = new Label("Middle Initial:");
			Label last = new Label("Last Name:");
			Label gender = new Label("Gender:");
			Label address = new Label("Address:");
			Label city = new Label("City:");
			Label state = new Label("State:");
			Label zip = new Label("Zip:");
			
			grid.add(first, 0, 0);
			grid.add(middle, 0, 1);
			grid.add(last, 0, 2);
			grid.add(gender, 0, 3);
			grid.add(address, 0, 4);
			grid.add(city, 0, 5);
			grid.add(state, 0, 6);
			grid.add(zip, 0, 7);
			
			//Various controls
			HBox box = new HBox();
			
		
			ObservableList<String> statesList = FXCollections.observableArrayList(states);
			stateBox.getItems().addAll(statesList);
			stateBox.setValue(null);
		
			maleButton.setToggleGroup(genderGroup);
			femaleButton.setToggleGroup(genderGroup);
		    
		    box.getChildren().addAll(maleButton, femaleButton);
		    
		    grid.add(firstField, 1, 0);
			grid.add(middleField, 1, 1);
			grid.add(lastField, 1, 2);
			grid.add(box, 1, 3);
			grid.add(addressField, 1, 4);
			grid.add(cityField, 1, 5);
			grid.add(stateBox, 1, 6);
			grid.add(zipField, 1, 7);
			
			grid.setVgap(20);
			grid.setAlignment(Pos.CENTER);
			root.setCenter(grid);
			
			//Buttons in HBox
			HBox buttonBox = new HBox();
			buttonBox.getChildren().addAll(btSAVE, btCLEAR);
			buttonBox.setAlignment(Pos.CENTER);
			buttonBox.setPadding(new Insets(10, 0, 20, 0));
			root.setBottom(buttonBox);
			
			
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			btCLEAR.setOnAction(e -> CLEARHandler());
			btSAVE.setOnAction(e -> SAVEHandler());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	private Object SAVEHandler() {
		
		try{
			String userFirst = firstField.getText();
			String userMiddle = middleField.getText();
			String userLast = lastField.getText();
			String userAddress = addressField.getText();
			String userCity = cityField.getText();
			String userZip = zipField.getText();
			String userState = stateBox.getValue();
			
			boolean userGender;
			if (maleButton.isSelected()){
				userGender = true;
			}else{
				userGender = false;
			}
			
			Customer customer = new Customer(userFirst, userMiddle, userLast, 
					userGender, userAddress, userCity, userState, userZip);
			
			ArrayList<Object> customerList = new ArrayList<>();
			
			customerList.add(customer);
			
			Stage SAVEDPopup = new Stage();
			Label SaveMessage = new Label("Entry has been saved.");
			Scene scene = new Scene(SaveMessage, 250, 50);
			SAVEDPopup.setTitle("Success");
			SAVEDPopup.setScene(scene);
			SAVEDPopup.show();
		}catch(Exception e){
			e.printStackTrace();
			Stage NOTSAVEDPopup = new Stage();
			Label notSaveMessage = new Label("There was an error.  Try again.");
			Scene scene = new Scene(notSaveMessage, 250, 50);
			NOTSAVEDPopup.setTitle("Success");
			NOTSAVEDPopup.setScene(scene);
			NOTSAVEDPopup.show();
		}
		
		
		
		return null;
	}



	private Object CLEARHandler() {
		firstField.setText(null);
		middleField.setText(null);
		lastField.setText(null);;
		addressField.setText(null);
		cityField.setText(null);
		zipField.setText(null);
		stateBox.setValue(null);
		
		genderGroup.selectToggle(null);
		
		return null;
	}



	public static void main(String[] args) {
		launch(args);
	}
}
