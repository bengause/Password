package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class Main extends Application {
	
	private String[] months = {"January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November", "December"};
	
	private String[] days1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
			"24", "25", "26", "27", "28", "29", "30", "31"};
	
	

		
	private String[] years = {"2010", "2011", "2012", "2013", "2014", "2015", 
			"2016", "2017", "2018", "2019", "2020"};
	
	private ComboBox<String> monthbox = new ComboBox<>();
	private ComboBox<String> daybox = new ComboBox<>();
	private ComboBox<String> yearbox = new ComboBox<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			
			//Put Labels in each row
			Label month = new Label("Month:");
			Label day = new Label("Day:");
			Label year = new Label("Year:");
			
			root.add(month, 0, 0);
			root.add(day, 0, 1);
			root.add(year, 0, 2);
			root.setVgap(70);
			root.setAlignment(Pos.CENTER);
			
			root.add(monthbox, 1, 0);
			monthbox.setPrefWidth(100);
			monthbox.setValue("January");
			
			ObservableList<String> items = FXCollections.observableArrayList(months);
			monthbox.getItems().addAll(items);
			
			root.add(yearbox, 1, 2);
			yearbox.setPrefWidth(100);
			yearbox.setValue("2015");
			
			ObservableList<String> itemsY = FXCollections.observableArrayList(years);
			yearbox.getItems().addAll(itemsY);
		
			root.add(daybox, 1, 1);
			daybox.setPrefWidth(100);;
			daybox.setValue("1");
			
			ObservableList<String> itemsD1 = FXCollections.observableArrayList(days1);
			daybox.getItems().addAll(itemsD1);
			
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Date Combo Boxes");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
