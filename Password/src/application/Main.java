package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;



public class Main extends Application {
	
	private PasswordField textfield = new PasswordField();
	
	//Create Buttons
	Button btOK = new Button("OK");
	Button btHELP = new Button("HELP");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Create border pane
			BorderPane root = new BorderPane();
			//Create a VBox
			VBox vbox = new VBox(0);
			
			vbox.getChildren().add(btOK);
			vbox.getChildren().add(btHELP);
			vbox.setPadding(new Insets(50,10,10,50));
			//Set the VBox to the right side of the borderpane
			root.setRight(vbox);
			
			//Create a label and textfield
			Label label = new Label("Enter Password:");
			
			
			btOK.setOnAction(e -> OKHandler());
			btHELP.setOnAction(e -> HELPHandler());
			textfield.setOnAction(e -> OKHandler());
			root.setLeft(label);
			root.setCenter(textfield);
			
			
			
			Scene scene = new Scene(root,400,150);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("PasswordDemo");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object HELPHandler() {
		Stage HelpPopup = new Stage();
		Label HelpMessage = new Label("Help was clicked");
		Scene scene = new Scene(HelpMessage, 200, 50);
		HelpPopup.setTitle("Help");
		HelpPopup.setScene(scene);
		HelpPopup.show();
		return null;
	}

	private Object OKHandler() {
		
		String userPassword = (String)textfield.getText();
		
		if (userPassword.equals("bugaboo")){
			Stage OKPopup = new Stage();
			Label PassMessage = new Label("Correct password was entered");
			Scene scene = new Scene(PassMessage, 250, 50);
			OKPopup.setTitle("Success");
			OKPopup.setScene(scene);
			OKPopup.show();
		}
		else {
			Stage notOKPopup = new Stage();
			Label FailMessage = new Label("Try again.");
			Scene scene = new Scene(FailMessage, 250, 50);
			notOKPopup.setTitle("Fail");
			notOKPopup.setScene(scene);
			notOKPopup.show();
		}
		
		
		return null;
	}

	
	

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
