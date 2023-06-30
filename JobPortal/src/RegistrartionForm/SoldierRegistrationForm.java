package RegistrartionForm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SoldierRegistrationForm {
public  void display(Stage parentStage) {
    // Create the form elements
    Label nameLabel = new Label("Name:");
    TextField nameField = new TextField();
    Label fatherNameLabel = new Label("Father Name:");
    TextField fatherNameField = new TextField();
    Label ageLabel = new Label("Age:");
    TextField ageField = new TextField();
    Label educationLabel = new Label("Education:");
    ChoiceBox<String> educationChoice = new ChoiceBox<>();
    educationChoice.getItems().addAll("Matriculation or equivalent", "Intermediate","Graduates");
    Label nationalityLabel = new Label("Nationality:");
    ChoiceBox<String> nationalityChoice = new ChoiceBox<>();
    nationalityChoice.getItems().addAll("Pakistan");
    Label maritalStatusLabel = new Label("Marital Status:");
    ChoiceBox<String> maritalStatusChoice = new ChoiceBox<>();
    maritalStatusChoice.getItems().addAll("Unmarried", "Married");
    Label criminalRecordLabel = new Label("Criminal Record:");
    TextField criminalRecordField = new TextField();
    Label interviewLabel = new Label("Interview:");
    TextField interviewField = new TextField();
    Label medicalLabel = new Label("Medical Examination:");
    TextField medicalField = new TextField();
    Label trainingLabel = new Label("Training:");
    ChoiceBox<String> trainingChoice = new ChoiceBox<>();
    trainingChoice.getItems().addAll("Willing", "Not Willing");

    Button submitButton = new Button("Submit");
    submitButton.setOnAction(e -> {
    	String name = nameField.getText();
        String fatherName = fatherNameField.getText();
        String age = ageField.getText();
        String education = educationChoice.getValue();
        String nationality = nationalityChoice.getValue();
        String maritalStatus = maritalStatusChoice.getValue();
        String criminalRecord = criminalRecordField.getText();
        String interview = interviewField.getText();
        String medical = medicalField.getText();
        String training = trainingChoice.getValue();
        
     // Check if all the required fields are filled
        if (name.isEmpty() || fatherName.isEmpty() || age.isEmpty() || maritalStatus == null || education == null) {
            showErrorDialog("Please fill all the fields");
            return;
        }

    //Check if all the required fields are filled
    if (age.isEmpty() || education.isEmpty() || nationality == null || maritalStatus == null || criminalRecord.isEmpty() || interview.isEmpty() || medical.isEmpty() || training == null) {
        showErrorDialog("Please fill all the fields");
        return;
    }
    //Check if the age is within the given range
    try {
        int ageInt = Integer.parseInt(age);
        if (ageInt < 17 || ageInt > 23) {
            showErrorDialog("Age must be between 17-23 years for Soldier");
            return;
        }
    } catch (NumberFormatException ex) {
        showErrorDialog("Invalid age");
        return;
    }
    //Check if the candidate has completed at least Matriculation or equivalent level of education
//    if (!education.isEmpty()) {
//        showErrorDialog("Candidate must have completed at least Matriculation or equivalent level of education");
//        return;
//        }

        // Check if the candidate is a citizen of Pakistan
        if (!nationality.equals("Pakistan")) {
        showErrorDialog("Candidate must be a citizen of Pakistan");
        return;
        }
        // Check if the candidate is unmarried at the time of enlistment
        if (!maritalStatus.equals("Unmarried")) {
        showErrorDialog("Candidate must be unmarried at the time of enlistment");
        return;
        }
        // Check if the candidate has a clean criminal record
        if (criminalRecord.isEmpty()) {
        showErrorDialog("Please provide information about criminal record");
        return;
        }
        // Check if the candidate passes the interview
        if (interview.isEmpty()) {
        showErrorDialog("Please provide information about the interview");
        return;
        }
        // Check if the candidate passes the medical examination
        if (medical.isEmpty()) {
        showErrorDialog("Please provide information about the medical examination");
        return;
        }
        // Check if the candidate is willing to undergo training
        if (!training.equals("Willing")) {
        showErrorDialog("Candidate must be willing to undergo training as per Pakistan Army's schedule");
        return;
        }
        
        String data = "Name: " + name + "\nFather Name: " + fatherName + "\nAge: " + age + "\nMarital Status: " + maritalStatus + "\nEducation: " + education + "\nNationality: " + nationality + "\nCriminal Record: " + criminalRecord + "\nInterview: " + interview + "\nMedical Examination: " + medical + "\nTraining: " + training;
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
        layout.add(educationLabel, 0, 3);
        layout.add(educationChoice, 1, 3);
        layout.add(nationalityLabel, 0, 4);
        layout.add(nationalityChoice, 1, 4);
        layout.add(maritalStatusLabel, 0, 5);
        layout.add(maritalStatusChoice, 1, 5);
        layout.add(criminalRecordLabel, 0, 6);
        layout.add(criminalRecordField, 1, 6);
        layout.add(interviewLabel, 0, 7);
        layout.add(interviewField, 1, 7);
        layout.add(medicalLabel, 0, 8);
        layout.add(medicalField, 1, 8);
        layout.add(trainingLabel, 0, 9);
        layout.add(trainingChoice, 1, 9);
        layout.add(submitButton, 1, 10);
        layout.setAlignment(Pos.CENTER);
        
        // Create the scene and display the stage
        Scene scene = new Scene(layout);
        Stage stage = new Stage();
        stage.setTitle("Soldier Registration Form");
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.show();
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(errorMessage);
        alert.show();
    }

    private void showSuccessDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Registration Successful");
        alert.setHeaderText("Soldier Registration");
        alert.show();
    }
}