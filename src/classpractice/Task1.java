package classpractice;
/*
* File: Task1.java
* Author: Jalen Brown
* Course: CISC230
* Lab: Lab5
* Date: 11/4/2026
* 
* Description:
* Program is an interactive campus explorer that displays 
* multiple different landmark locations at the University of
* St.Thomas. Uses different functions like the flowPane borderPane
* and buttons as well. Uses various flowPanes to organize my objects
* then uses borderPane to display these panes in designated zones.
* Attaches methods to button calls to display different images.
*/
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;

public class Task1 extends Application{

	//creating instance variables
	private final TextArea one = new TextArea();
	private Label label = new Label();
	private Label label2 = new Label();
	private ImageView view = new ImageView();
		
	public void start(Stage ps) {
		
		//setting width, height, and ratio, of imgView
		view.setFitWidth(420);
		view.setFitHeight(260);
		view.setPreserveRatio(true);
		
		//wraps text to other line if line exceeds width
		one.setWrapText(true);
		//sets count of how many rows of text can be used
		one.setPrefRowCount(4);
		//makes it so text in scene can not be edited
		one.setEditable(false);	
				
		//creating buttons and calling methods using setOnAction function
		Button a = new Button("Campus Entrance");
		a.setOnAction(this::showEntrance);
		Button b = new Button("Student Center");
		b.setOnAction(this::showStudentCenter);
		Button c = new Button("Stadium");
		c.setOnAction(this::showStadium);
		Button d = new Button("Clear Image");
		d.setOnAction(this::clearDisplay);
		
		//creating flowPane that contains imgView as well as text labels
		FlowPane contentPane = new FlowPane(view, label, label2, one);
		//setting vertical and horizontal gaps of Pane
		contentPane.setHgap(10);
		contentPane.setVgap(10);
		//setting alignment of the pane to the center
		contentPane.setAlignment(Pos.CENTER);

		//creating flowPane that contains buttons
		FlowPane buttonPane = new FlowPane(a, b, c, d);
		//setting vertical and horizontal gaps of Pane
		buttonPane.setHgap(10);
		buttonPane.setVgap(10);
		//setting alignment of the pane to the center
		buttonPane.setAlignment(Pos.CENTER);

		//creating borderPane and setting flowPanes to different
		//positions on borderPane
		BorderPane pane = new BorderPane();
		pane.setCenter(contentPane);
		pane.setBottom(buttonPane);
		
		//setting entrance to not contain anything
		showEntrance(null);

		//displaying scene
		Scene scene = new Scene(pane, 650, 650);
		ps.setTitle("campus");
		ps.setScene(scene);
		ps.show();
	}
	
	//creating methods that shows different landmarks as well as their information
	
	public void showEntrance(ActionEvent event) {
		
		//creating image object
		Image entranceImage = new Image("file:arcs.png");
		
		//setting image object to be visible
		view.setImage(entranceImage);
		
		//creating labels
		label.setText("The Arches");
		label2.setText("Description: A defining landmark that was built over 75 years ago.");
		
		//setting text in textArea
		one.setText("The Arches \nThe arches serve as a structure that connect both"
				+ " Aquinas Hall and the John R. Roach Center.\nOnce a year, new freshman students"
				+ " walk these arches signifying their new enrollment at St. Thomas. ");
	}
	
	public void showStudentCenter(ActionEvent event) {
		
		//creating image object
		Image studentCenterImage = new Image("file:anderson.png");
		
		//setting image object to be visible
		view.setImage(studentCenterImage);
		
		//creating labels
		label.setText("Anderson Student Center");
		label2.setText("Description: A campus gathering center for students, "
				+ "visitors and faculty.");
		//setting text in textArea
		one.setText("Anderson Student Center \nIt is home to many different eateries "
				+ " such as The View, Scooters, and more." + "\nIn this building, many different"
						+ " activites and events take place.");
	}
	
	public void showStadium(ActionEvent event) {
		
		//creating image object
		Image stadiumImage = new Image("file:field.png");
		
		//setting image object to be visible
		view.setImage(stadiumImage);
		
		//setting text in textArea
		label.setText("O'Shaughnessy Stadium");
		label2.setText("Description: Home to the Tommies football team");
		one.setText("O'Shaughnessy Stadium \nHere the Tommies play their home"
				+ " football games. \nIt is also used by many students for recreational "
				+ " activities and clubs.");
	}
	
	//method that clear all scene content
	public void clearDisplay(ActionEvent event) {
		one.clear();
		view.setImage(null);
		label.setText(null);
		label2.setText(null);
	}
}