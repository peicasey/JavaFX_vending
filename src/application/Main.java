package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import project1.DataFile;
import project1.Vending;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,500,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		// GUI - JavaFX Portion
		launch(args);
		
		// Non-GUI - Vanilla Java Portion
		
//		//load data from file
//	    DataFile myData = new DataFile("./src/project1/directories/directory1.txt", "./src/project1/inputs/input1.txt");
//	    
//	    //initialize Vending machine with loaded data
//	    ArrayList <String> myVending = myData.loadDirectory();
//	    ArrayList <Integer> mySelections = myData.loadSampleInput();
//	    
//	    System.out.println("______________________________");
//
//	    Vending myMachine = new Vending(myVending);
//	    // Test line to show items before removing initially
//	    System.out.println("Items originally there:");
//	    System.out.println(myMachine);
//	    // myMachine.displayItems(); //debug helper function, REALLY NEEDS toString()
//	    
//	    System.out.println("______________________________");
//	    
//	    //remove items
//	    myMachine.unloadItems(mySelections);
//	    System.out.println("Items removed final count: ");
//	    System.out.println(myMachine); //Final output to display after removing
//	    // myMachine.displayItems(); //debug helper function, REALLY NEEDS toString()
//
//	    /*****************/
//	    // Above DisplayItems() call is fine, but the Vending machine's deconstructor 
//	    // should call that function since it's the LAST operation. Notice it could be
//	    // done with a helper function that USES the toString()
//	    // We will NOT call DisplayItems() in testing 
//	    /*****************/
		
	}
}
