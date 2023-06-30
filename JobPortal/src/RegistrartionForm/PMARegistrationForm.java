package RegistrartionForm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PMARegistrationForm {
    public  void display(Stage parentStage) {
        // Create the form elements
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField(); 
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label maritalStatusLabel = new Label("Marital Status:");
        ChoiceBox<String> maritalStatusChoice = new ChoiceBox<>();
        maritalStatusChoice.getItems().addAll("Unmarried", "Married");
        Label educationLabel = new Label("Education:");
        ChoiceBox<String> educationChoice = new ChoiceBox<>();
        educationChoice.getItems().addAll("Intermediate or equivalent", "Graduates", "Serving Armed/Civil Armed Forces Personnel");
    
        // Create the submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String age = ageField.getText();
            String maritalStatus = maritalStatusChoice.getValue();
            String education = educationChoice.getValue();
    
            // Check if all the required fields are filled
            if (name.isEmpty() || fatherName.isEmpty() || age.isEmpty() || maritalStatus == null || education == null) {
                showErrorDialog("Please fill all the fields");
                return;
            }
            // Check if the age is within the given range
            try {
                int ageInt = Integer.parseInt(age);
                if (education.equals("Intermediate or equivalent")) {
                    if (ageInt < 17 || ageInt > 22) {
                        showErrorDialog("Age must be between 17-22 years for Intermediate or equivalent education");
                        return;
                    }
                }
                else if (education.equals("Graduates for PMA Long Course")) {
                    if (ageInt < 17 || ageInt > 23) {
                        showErrorDialog("Age must be between 17-23 years for Graduates for PMA Long Course education");
                        return;
                    }
                }
                else if (education.equals("Serving Armed/Civil Armed Forces Personnel")) {
                    if (ageInt < 17 || ageInt > 23) {
                        showErrorDialog("Age must be between 17-23 years for Serving Armed/Civil Armed Forces Personnel education");
                        return;
                    }
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("Invalid age");
                return;
            }
            // Check if the marital status is unmarried
            if (!maritalStatus.equals("Unmarried")) {
                showErrorDialog("Marital status must be unmarried for PMA Long Course");
                return;
            }
            
            String data = "Name: " + name + "\nFather Name: " + fatherName + "\nAge: " + age + "\nMarital Status: " + maritalStatus + "\nEducation: " + education;
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
        layout.add(maritalStatusLabel, 0, 3);
        layout.add(maritalStatusChoice, 1, 3);
        layout.add(educationLabel, 0, 4);
        layout.add(educationChoice, 1, 4);
        layout.add(submitButton, 1, 5);
        
        // Create the scene and show the stage
        Scene scene = new Scene(layout);
        Stage registrationStage = new Stage();
        registrationStage.initModality(Modality.WINDOW_MODAL);
        registrationStage.initOwner(parentStage);
        registrationStage.setScene(scene);
        registrationStage.setTitle("PMA LLC Registration Form");
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
        alert.setContentText("You have successfully registered for PMA LLC. You will be informed about the entry test.");
        alert.showAndWait();
        }
        }