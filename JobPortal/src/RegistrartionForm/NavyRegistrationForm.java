package RegistrartionForm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NavyRegistrationForm {
    // Create the form elements
    private Label nameLabel = new Label("Name:");
    private TextField nameField = new TextField();
    private Label fatherNameLabel = new Label("Father Name:");
    private TextField fatherNameField = new TextField();
    private Label ageLabel = new Label("Age:");
    private TextField ageField = new TextField();
    private Label countryLabel = new Label("Country:");
    private ChoiceBox<String> countryChoice = new ChoiceBox<>();
    private Label phoneLabel = new Label("Phone:");
    private TextField phoneField = new TextField();
    private Label pictureLabel = new Label("Picture:");
    private TextField pictureField = new TextField();
    private Button browse = new Button("Browse");
    private Button submitButton = new Button("Submit");

    public void displayForm(Stage parentStage) {
        // Initialize the form elements
        countryChoice.getItems().add("Pakistan");

        browse.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(parentStage);
            pictureField.setText(file.getAbsolutePath());
        });

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String age = ageField.getText();
            String country = countryChoice.getValue();
            String phone = phoneField.getText();
            String picture = pictureField.getText();

            // Check if all the required fields are filled
            if (name.isEmpty() || fatherName.isEmpty() || age.isEmpty() || country.isEmpty() || phone.isEmpty() || picture.isEmpty()) {
                showErrorDialog("Please fill all the fields");
                return;
            }
            // Check if the age is greater than or equal to 16
            try {
                int ageInt = Integer.parseInt(age);
                if (ageInt < 16) {
                    showErrorDialog("Minimum age for registration is 16");
                    return;
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("Invalid age");
                return;
            }

            // Check if the country is Pakistan
            if (!country.equals("Pakistan")) {
                showErrorDialog("Sorry, currently registration is only open for Pakistan");
                return;
            }

//            // If all the validation checks pass, show the success dialog
//            showSuccessDialog();
//        });
        String data = "Name: " + name + "\nFather Name: " + fatherName + "\nAge: " + age + "\nCountry: " + country + "\nPhone: " + phone + "\nPicture: " + picture;
        try {
            File file = new File("applicant.txt"); 
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

     // If all the validation checks pass, show the success dialog
        showSuccessDialog();
    });
        

        // Create the layout and add the form elements and submit button to it
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(nameLabel, 0, 0);
        layout.add(nameField, 1, 0);
        layout.add(fatherNameLabel, 0, 1);
        layout.add(fatherNameField, 1, 1);
        layout.add(ageLabel, 0, 2);
        layout.add(ageField, 1, 2);
        layout.add(countryLabel, 0, 3);
        layout.add(countryChoice, 1, 3);
        layout.add(phoneLabel, 0, 4);
        layout.add(phoneField, 1, 4);
        layout.add(pictureLabel, 0, 5);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(pictureField,browse);
        hbox.setSpacing(10);
        layout.add(hbox, 1, 5);
        layout.add(submitButton, 0, 6);
        layout.setAlignment(Pos.CENTER);
        
        // Create the scene and show the stage
        Scene scene = new Scene(layout);
        Stage registrationStage = new Stage();
        registrationStage.initModality(Modality.WINDOW_MODAL);
        registrationStage.initOwner(parentStage);
        registrationStage.setTitle("Registration Form");
        registrationStage.setScene(scene);
        registrationStage.show();
        }
    
    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Your application has been submitted successfully. You will be notified about the entry test.");
        alert.showAndWait();
    }
}