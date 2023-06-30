package application;
	
import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	Stage stage;
	Scene scene;
	@Override
	public void start(Stage sta) throws Exception {
		this.stage=sta;
	
		Label head = new Label("Welcome To the Job Portal");
		head.setFont(Font.font("Monotype Corsiva",60));
		head.setTextFill(Color.MEDIUMVIOLETRED);
		
		Label l = new Label("First of All Register Yourself To Apply for a job");
		l.setFont(Font.font("Corbel",30));
		l.setStyle("-fx-font-weight: bold");
	 
		Button register = new Button("Register");
		
		GridPane lp = new GridPane();
		
		lp.setHgap(20);
		lp.setVgap(20);
		lp.setAlignment(Pos.CENTER);  
		
		lp.add(head,0,0,2,1);
		lp.add(l, 0, 2);
		lp.add(register,0,3);
		
		Image image = new Image("file:///Users/macbook/Desktop/Desktop/Java-OOP/Eclipse/JobPortal/src/1st.jpeg");

		BackgroundImage backgroundImage = new BackgroundImage(image,
		    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.DEFAULT, null);
		Background background = new Background(backgroundImage);
		lp.setBackground(background);		
		
		
		Scene sl = new Scene(lp,800,600);
		sta.setScene(sl);
		sta.show();
		
		
		
		register.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			
				applicantComponents();		
				
			}
		});	
	}
	void applicantComponents() {
		
		Text txt = new Text("Applicant Registration form");
		txt.setFont(Font.font("Verdana",25));
		Label lfirstname = new Label("First Name");
		TextField txfirstname= new TextField();
		Label llastname = new Label("Last Name");
		TextField txlastname= new TextField();
		Label ldob = new Label("Date of Birth ");
		DatePicker dob = new DatePicker();
		dob.setMinWidth(150);
		Label lcountry = new Label("Select Country ");
		ComboBox<String> cmbcountry = new ComboBox<String>();
		cmbcountry.getItems().addAll("Pakistan","India","China");
		cmbcountry.setMinWidth(150);
		Label lcity = new Label("Select City");
		ComboBox<String> cmbcity = new ComboBox<String>();
//		cmbcity.getItems().addAll("Karachi","Lahore","Islamabad","Hyderabad");
		cmbcity.setMinWidth(150);
		Label lquali = new Label("Qualification");
		ComboBox<String> cmbquali = new ComboBox<String>();
		cmbquali.getItems().addAll("Matriculation","Intermidiate","Graduation","Masters");
		cmbquali.setMinWidth(150);
		Label lintrper=new Label("Percentage");
		TextField txintrper= new TextField();
		Label lgender = new Label("Gender");
		RadioButton r1 = new RadioButton("Male");
		RadioButton r2 = new RadioButton("Fe-male");
		ToggleGroup genderR =new ToggleGroup();
		r1.setToggleGroup(genderR);
		r2.setToggleGroup(genderR);
		Button breg = new Button("Register");
		
		cmbcountry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			if(cmbcountry.getValue().equals("Pakistan")) {
			cmbcity.getItems().clear();
			cmbcity.getItems().addAll("Karachi","Lahore","Islamabad","Hyderabad");
			}
			else if(cmbcountry.getValue().equals("India")) {
			cmbcity.getItems().clear();
			cmbcity.getItems().addAll("Mumbai","Delhi","Bangalore","Kolkata");
			}
			else if(cmbcountry.getValue().equals("China")) {
			cmbcity.getItems().clear();
			cmbcity.getItems().addAll("Beijing","Shanghai","Guangzhou","Shenzhen");
			}
			}
			});
		GridPane jp = new GridPane();
		jp.setHgap(30);
		jp.setVgap(30);
		jp.setAlignment(Pos.CENTER);
		jp.add(txt, 0, 0,2,1);
		jp.add(lfirstname, 0, 1);
		jp.add(llastname, 0, 2);
		jp.add(ldob, 0, 3);
		jp.add(lcountry, 0, 4);
		jp.add(lcity, 0, 5);
		jp.add(lquali, 0, 6);
		jp.add(lintrper, 0, 7);
		jp.add(lgender, 0, 8);
		jp.add(txfirstname, 1, 1);
		jp.add(txlastname, 1, 2);
		jp.add(dob, 1,3);
		jp.add(cmbcountry, 1,4);
		jp.add(cmbcity, 1, 5);
		jp.add(cmbquali, 1, 6);
		jp.add(txintrper, 1, 7);
		HBox genderBox = new HBox();
		genderBox.getChildren().addAll(r1, r2);
		genderBox.setSpacing(10);
		jp.add(genderBox, 1, 8);
		jp.add(breg, 1,9);
		Image image = new Image("file:///Users/macbook/Desktop/Desktop/Java-OOP/Eclipse/JobPortal/src/2nd.jpeg");

		BackgroundImage backgroundImage = new BackgroundImage(image,
		    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.DEFAULT, null);
		Background background = new Background(backgroundImage);
		jp.setBackground(background);

		Scene s = new Scene(jp,800,600);
		stage.setScene(s);
		stage.show(); 
		
 
		breg.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			// check if all required fields are filled
			if (txfirstname.getText().trim().isEmpty() || txlastname.getText().trim().isEmpty() ||
			dob.getValue() == null || txintrper.getText().trim().isEmpty()) {
			// display an error message if any required fields are empty
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Please fill out all required fields");
			alert.showAndWait();
			} else {
			// Check for Date of Birth
		        LocalDate date = dob.getValue();

			if (date.isAfter(LocalDate.now().minusYears(16))) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid Date of Birth");
			alert.showAndWait();
			} else {
			// Check for Percentage
			try {
			int percentage = Integer.parseInt(txintrper.getText().trim());
			if (percentage < 50 ||percentage >=100 ) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid Percentage");
			alert.showAndWait();
			} else {
			// create the ApplicantDetails object and call the DisplayAppcantScreen method if all required fields are filled
			ApplicantDetails ap = new ApplicantDetails(txfirstname.getText() ,
			txlastname.getText() ,dob.getValue() , cmbcountry.getValue(),
			cmbcity.getValue(),cmbquali.getValue(),txintrper.getText());
			ApplicantJobs.DisplayAppcantScreen(ap);
			}
			} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Invalid Percentage");
			alert.showAndWait();
			}
			}
			}
			}
			});

	}
}