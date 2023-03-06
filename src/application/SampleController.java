package application;

// javafx imports
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// java imports
import java.util.ArrayList;

public class SampleController {
	@FXML private Label a1;
	@FXML private Label a2;
	@FXML private Label b1;
	@FXML private Label b2;
	@FXML private Label c1;
	@FXML private Label c2;
	
	@FXML private Button a1_button;
	@FXML private Button a2_button;
	@FXML private Button b1_button;
	@FXML private Button b2_button;
	@FXML private Button c1_button;
	@FXML private Button c2_button;
	@FXML private Button reset_button;
	
	@FXML private ImageView a1_img;
	@FXML private ImageView a2_img;
	@FXML private ImageView b1_img;
	@FXML private ImageView b2_img;
	@FXML private ImageView c1_img;
	@FXML private ImageView c2_img;
	@FXML private ImageView out_img;
	
	//InputStream stream = new FileInputStream("empty.jpg");
	@FXML private Image empty_img = new Image(getClass().getResourceAsStream("empty.jpg"));
	@FXML private Image cola_img = new Image(getClass().getResourceAsStream("coca-cola.jpg"));
	@FXML private Image pepsi_img = new Image(getClass().getResourceAsStream("pepsi.jpg"));
	@FXML private Image cheetos_img = new Image(getClass().getResourceAsStream("cheetos.jpg"));
	@FXML private Image cookies_img = new Image(getClass().getResourceAsStream("chips_ahoy.jpg"));

	//load data from file
    private DataFile myData = new DataFile("./src/application/directories/directory1.txt", "./src/application/inputs/input1.txt");
    
    //initialize Vending machine with loaded data
    private ArrayList <String> myVending = myData.loadDirectory();

    private Vending myMachine = new Vending(myVending);
	
	@FXML public void initialize() {
	    // set the amounts left
	    updateAmounts();
	}
	
	public void updateAmounts() {
		a1.setText(Integer.toString(myMachine.getSlotAmounts().get(0)));
		emptyIfEmpty(a1_img, 0);
	    a2.setText(Integer.toString(myMachine.getSlotAmounts().get(1)));
	    emptyIfEmpty(a2_img, 1);
	    b1.setText(Integer.toString(myMachine.getSlotAmounts().get(2)));
	    emptyIfEmpty(b1_img, 2);
	    b2.setText(Integer.toString(myMachine.getSlotAmounts().get(3)));
	    emptyIfEmpty(b2_img, 3);
	    c1.setText(Integer.toString(myMachine.getSlotAmounts().get(4)));
	    emptyIfEmpty(c1_img, 4);
	    c2.setText(Integer.toString(myMachine.getSlotAmounts().get(5)));
	    emptyIfEmpty(c2_img, 5);
	}
	
	public void emptyIfEmpty(ImageView image, Integer index) {
		if (myMachine.getSlotAmounts().get(index) <= 0) {
			image.setImage(empty_img);
		}
	}
	
	public void updateOutImage(ArrayList<Integer> oldAmts) {
		Integer i = 0;
		while (i <= oldAmts.size()) {
			if (i == oldAmts.size()) { i = -1; break; }
			if (oldAmts.get(i) > myMachine.getSlotAmounts().get(i)) { break; }
			i++;
		}
		
		switch(i) {
		  case 0:
		    out_img.setImage(pepsi_img);
		    break;
		  case 1:
		  case 2:
		  case 3:
			out_img.setImage(cola_img);
			break;
		  case 4:
			out_img.setImage(cheetos_img);
			break;
		  case 5:
			out_img.setImage(cookies_img);
			break;
		  default:
			out_img.setImage(empty_img); // everything is empty
		}
	}
	
	@FXML public void resetListener(ActionEvent e) {
		System.out.println("Reset button pressed");
		
		myMachine = new Vending(myVending); // new machine
		
		updateAmounts();
		
		a1_img.setImage(pepsi_img);
		a2_img.setImage(cola_img);
		b1_img.setImage(cola_img);
		b2_img.setImage(cola_img);
		c1_img.setImage(cheetos_img);
		c2_img.setImage(cookies_img);
		out_img.setImage(empty_img);
	}
	
	@FXML public void a1Listener(ActionEvent e) {
		System.out.println("A1 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(0);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	@FXML public void a2Listener(ActionEvent e) {
		System.out.println("A2 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(1);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	@FXML public void b1Listener(ActionEvent e) {
		System.out.println("B1 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(2);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	@FXML public void b2Listener(ActionEvent e) {
		System.out.println("B2 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(3);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	@FXML public void c1Listener(ActionEvent e) {
		System.out.println("C1 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(4);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	@FXML public void c2Listener(ActionEvent e) {
		System.out.println("C2 button pressed");
		ArrayList<Integer> oldAmts = myMachine.getSlotAmounts();
		myMachine.unloadItem(5);
		updateAmounts();
		updateOutImage(oldAmts);
	}
	
	
}
