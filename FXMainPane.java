package application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	//student Task #2:
		//  declare five buttons, a label, and a textfield
	Button button1 , button2 , button3 ,button4 ,button5 ;
	Label label;
	TextField textfield;
		//  declare two HBoxes
	HBox hbox1, hbox2;
		//student Task #4:
		//  declare an instance of DataManager
		DataManager dataManager;
		/**
		 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
		 * wait to add a component to its containing component until the container has
		 * been created.  This is the only constraint on the order in which the following 
		 * statements appear.
		 */
		FXMainPane() {
			//student Task #2:
			//  instantiate the buttons, label, and textfield
			 button1 = new Button ("Hello");
			 button1.setOnAction(new ButtonHandler());
			 
			 button2 = new Button ("Howdy");
			 button2.setOnAction(new ButtonHandler());
			 
			 button3 = new Button ("Chinese");
			 button3.setOnAction(new ButtonHandler());
			 
			 button4 = new Button ("Clear");
			 button4.setOnAction(new ButtonHandler());
			 
			 button5 = new Button ("Exit");
			 button5.setOnAction(new ButtonHandler());
			 
			Label label = new Label("Feedback");
			
		 textfield = new TextField();
			
			//  instantiate the HBoxes
			 hbox1 = new HBox();
			 hbox2 = new HBox();
			//student Task #4:
			//  instantiate the DataManager instance
			 dataManager = new DataManager();
			//  set margins and set alignment of the components
			HBox.setMargin(button1, new Insets(10));
			HBox.setMargin(button2, new Insets(10));
			HBox.setMargin(button3, new Insets(10));
			HBox.setMargin(button4, new Insets(10));
			HBox.setMargin(button5, new Insets(10));
			HBox.setMargin(label, new Insets(10));
			
			hbox1.setAlignment(Pos.CENTER);
			hbox2.setAlignment(Pos.CENTER);
			//student Task #3:
			//  add the label and textfield to one of the HBoxes
			 hbox2.getChildren().addAll(label, textfield);
			 
			//  add the buttons to the other HBox
			 hbox1.getChildren().addAll(button1, button2, button3, button4, button5);
			//  add the HBoxes to this FXMainPanel (a VBox)
			 getChildren().addAll(hbox1, hbox2);
		}
		
		//Task #4:
		//  create a private inner class to handle the button clicks
		private class ButtonHandler implements EventHandler<ActionEvent>{
			public void handle(ActionEvent event) {
				Object object = event.getTarget();
				
				
				if (object == button1) {
					String a = dataManager.getHello();
					textfield.setText(a);
				}
				else if (object == button2) {
					String b = dataManager.getHowdy();
					textfield.setText(b);
				}
				else if (object == button3) {
					String c = dataManager.getChinese();
					textfield.setText(c);
				}
				else if (object == button4) {
					textfield.setText("");
				}
				else if(object == button5) {
					Platform.exit();
					System.exit(0);
				}
			}
		}
		
}
