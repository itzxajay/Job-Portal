package RegistrartionForm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ITTechnicianRegistrationForm {
    public void display(Stage parentStage) {
        // Create the form elements
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label educationLabel = new Label("Education:");
        ChoiceBox<String> educationChoice = new ChoiceBox<>();
        educationChoice.getItems().addAll("Matriculation or equivalent", "Diploma in IT", "Bachelors in IT");
        Label workExperienceLabel = new Label("Work Experience (in years):");
        TextField workExperienceField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label phoneLabel = new Label("Phone:");
        TextField phoneField = new TextField();
        Label skillsLabel = new Label("Skills (comma separated):");
        TextField skillsField = new TextField();
        Label referencesLabel = new Label("References (comma separated):");
        TextField referencesField = new TextField();
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String age = ageField.getText();
            String education = educationChoice.getValue();
            String workExperience = workExperienceField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String skills = skillsField.getText();
            String references = referencesField.getText();

            // Check if all the required fields are filled
            if (name.isEmpty() || age.isEmpty() || education == null || workExperience.isEmpty()
                    || email.isEmpty() || phone.isEmpty() || skills.isEmpty() || references.isEmpty()) {
                showErrorDialog("Please fill all the fields");
                return;
            }
            // Check if the age is greater than or equal to 18
            try {
                int ageInt = Integer.parseInt(age);
                if (ageInt < 18) {
                    showErrorDialog("Minimum age for IT Technician registration is 18");
                    return;
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("Invalid age");
                return;
            }
            // Check if the education is IT related
            if (education.isEmpty()) {
                showErrorDialog("Education must be IT related for IT Technician registration");
                return;
            }
            // Check if the candidate has experience in IT field
            if (workExperience.isEmpty()) {
                showErrorDialog("Please enter your experience in IT field");
                return;
            }
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                showErrorDialog("Invalid email address");
                return;
            }

            // Check if the phone number is valid
            if (phone.isEmpty()) {
                showErrorDialog("Invalid phone number. Must be of format: +923xxxxxxxxx or 03xxxxxxxxx");
                return;
            }

            // Check if the candidate has valid skills in IT field
            if (skills.isEmpty()) {
                showErrorDialog("Please enter your valid skills in IT field");
                return;
            }

            // Write the application data to a file
            String data = "Name: " + name + "\nAge: " + age + "\nEmail: " + email
                    + "\nPhone: " + phone + "\nEducation: " + education + "\nSkils: " + skills;
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
        layout.add(ageLabel, 0, 2);
        layout.add(ageField, 1, 2);
        layout.add(educationLabel, 0, 3);
        layout.add(educationChoice, 1, 3);
        layout.add(workExperienceLabel, 0, 4);
        layout.add(workExperienceField, 1, 4);
        layout.add(emailLabel, 0, 5);
        layout.add(emailField, 1, 5);
        layout.add(phoneLabel, 0, 6);
        layout.add(phoneField, 1, 6);
        layout.add(skillsLabel, 0, 7);
        layout.add(skillsField, 1, 7);
        layout.add(referencesLabel, 0, 8);
        layout.add(referencesField, 1, 8);
        layout.add(submitButton, 1, 9);

        // Create the scene and add the layout to it
        Scene scene = new Scene(layout, 800, 600);

        // Create the stage and set its properties
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration Form - IT Technician");
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Your application has been submitted successfully");
        alert.showAndWait();
    }
}