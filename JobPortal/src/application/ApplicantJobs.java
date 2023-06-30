package application;

import java.io.IOException;
import java.time.LocalDate;

import RegistrartionForm.ITTechnicianRegistrationForm;
import RegistrartionForm.NavyRegistrationForm;
import RegistrartionForm.PMARegistrationForm;
import RegistrartionForm.SoldierRegistrationForm;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicantJobs {
    Stage stage;

    @SuppressWarnings("unchecked")
	static void DisplayAppcantScreen(ApplicantDetails ap) {
        Stage stage = new Stage();

        TableView<ApplicantDetails> table = new TableView<>();

        TableColumn<ApplicantDetails, String> fnameCol = new TableColumn<>("First Name");
        fnameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));

        TableColumn<ApplicantDetails, String> lnameCol = new TableColumn<>("Last Name");
        lnameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));

        TableColumn<ApplicantDetails, LocalDate> dobCol = new TableColumn<>("Date of Birth");
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));

        TableColumn<ApplicantDetails, String> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<ApplicantDetails, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<ApplicantDetails, String> qualiCol = new TableColumn<>("Qualification");
        qualiCol.setCellValueFactory(new PropertyValueFactory<>("quali"));

        TableColumn<ApplicantDetails, String> intrperCol = new TableColumn<>("Percentage");
        intrperCol.setCellValueFactory(new PropertyValueFactory<>("intrper"));

        table.getColumns().addAll(fnameCol, lnameCol, dobCol, countryCol, cityCol, qualiCol, intrperCol);
        table.getItems().add(ap);
        Button btseeJobs = new Button("SEE JOBS");
        VBox v = new VBox(20,table, btseeJobs);
        Scene s = new Scene(v, 500, 500);  
        v.setAlignment(Pos.CENTER);
        v.setBackground(new Background(new BackgroundFill(Color.web("DARKTURQUOISE"),  null, null)));
        stage.setScene(s);
        stage.show();
        btseeJobs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Filing.filename = "applicant.txt";
                try {
                    Filing.writeData(ap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                seeJobs();
            }
        });

    }

    static void seeJobs() {

        Text t = new Text("Online Job Portal");
        t.setFont(Font.font("Monotype Corsiva", 60));
        t.setFill(Color.MEDIUMVIOLETRED);
        Label l1 = new Label("Following are the Catagory of Jobs you want to Apply");
        l1.setFont(Font.font("Calibri", 25));

        Button army = new Button("Army Jobs");
        Button IT = new Button("IT Jobs");
        Button rail = new Button("Pakistan Railway");
        Button navy = new Button("Pakistan Navy");


        GridPane grip = new GridPane();
        grip.setVgap(20);
        grip.setHgap(20);
        grip.setAlignment(Pos.CENTER);

        grip.add(t, 0, 0, 2, 1);
        grip.add(l1, 0, 1);
        grip.add(army, 0, 2);
        grip.add(IT, 0, 3);
        grip.add(rail, 0, 4);
        grip.add(navy, 0, 5);

        grip.setBackground(new Background(new BackgroundFill(Color.web("DARKTURQUOISE"), null, null)));

        Scene s = new Scene(grip, 800, 600);
        Stage stg = new Stage();

        stg.setScene(s);
        stg.show();

        //army button code
        army.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Label tarym1 = new Label("PMA Long Course\n" +
            			"Eligibility Conditions: 121 PMA Long Course\n" +
            			"\n" +
            			"Age on 01 May 2021:\n" +
            			"\n" +
            			"Civilians:\n" +
            			"• Intermediate or equivalent-17-22 years.\n" +
            			"• Graduates for PMA Long Course-17-23 years.\n" +
            			"• Serving Armed/Civil Armed Forces Personnel-17-23 years Forces Personnel\n" +
            			"Marital Status:\n" +
            			"Unmarried (serving personnel of the Armed Forces over 20 years of age are eligible, even if married).\n"
            			+
            			"Training Period:\n" +
            			"2 years at PMA.\n" +
            			"Educational Qualifications:\n" +
            			"Intermediate with minimum 50% marks. Candidates with domicile and having actually been studying in Balochistan, FATA, District Kohistan, Chitral, Dir, Tehsil Bala Kot (Kaghan, Naran) of District Mansehara in NWFP, Tharparker and Tehsil UmerKot in Sind, District Rajanpur, area of Cholistan, Desert Drawer Fort, Salamsar, Mojgarh, Dingarh of Punjab and Northern Areas, can appear with 45% marks.\n"
            			+
            			"Selection Procedure for PMA Long Course:\n" +
            			"Intelligence/personality tests and Academics written test based on multiple choice questions from English, Maths, Pak-Studies, Islamiat, and general knowledge are conducted at AS&RCs. Candidates declared successful in written/intelligence tests will undergo physical, medical tests, and preliminary interview at AS&RCs. Candidates qualifying preliminary selection will be sent to ISSB for further tests. Medical examination of ISSB recommended candidates will be carried out at nearby CMHs. Final selection is made at GHQ based on overall merit prepared.");
                Button applypma = new Button("Apply PMA LLC");
                tarym1.setWrapText(true);

                Label lsolder = new Label("Soldier Criteria:\n" +
                        "Age: Candidates must be between 17-23 years of age on the date of enlistment.\r\n"
                        + "Educational Qualifications: Candidates must have completed at least Matriculation or equivalent level of education.\r\n"
                        + "Physical Standards: Candidates must meet the physical and medical standards set by the Pakistan Army.\r\n"
                        + "Nationality: Candidates must be citizens of Pakistan.\r\n"
                        + "Marital Status: Candidates must be unmarried at the time of enlistment.\r\n"
                        + "Criminal Record: Candidates must have a clean criminal record.\r\n"
                        + "Psychological and Intelligence Tests: Candidates must pass the psychological and intelligence tests conducted by the Army.\r\n"
                        + "Interview: Candidates must pass an interview with a selection board.\r\n"
                        + "Medical Examination: Candidates must pass a medical examination to ensure that they meet the physical and medical standards set by the Pakistan Army.\r\n"
                        + "Training: Candidates must be willing to undergo training for the required period as per the Pakistan Army's training schedule");
                Button applysoldier = new Button("Apply for Soldier");
                lsolder.setWrapText(true);


                VBox vbox = new VBox();
                vbox.getChildren().addAll(tarym1, applypma, lsolder, applysoldier);
                vbox.setSpacing(20);
                vbox.setAlignment(Pos.CENTER);

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(vbox);
                scrollPane.setFitToWidth(true);
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

                Scene scene = new Scene(scrollPane, 800, 600);
                Stage stage = new Stage();
                scene.setFill(Color.LIGHTBLUE);
                stage.setScene(scene);
                stage.show();

                PMARegistrationForm registrationFormPMA = new PMARegistrationForm();
                applypma.setOnAction(new EventHandler<ActionEvent>() {
                private Stage parentStage;

				@Override
                public void handle(ActionEvent event) {
                	registrationFormPMA.display(parentStage);
                }
                }); 

                applysoldier.setOnAction(new EventHandler<ActionEvent>() {

                	private Stage parentStage;

					@Override
                	public void handle(ActionEvent event) {
                	SoldierRegistrationForm soldierRegistrationForm = new SoldierRegistrationForm();
                	soldierRegistrationForm.display(parentStage);
                	}
                });
            }
        });
        
        
        //IT button code
        IT.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label lIT = new Label("Age: Candidates must be between 18-30 years of age.\r\n"
                		+ "Educational Qualifications: Candidates must have completed at least Diploma in IT or equivalent level of education.\r\n"
                		+ "Technical Skills: Candidates must have knowledge of various programming languages, operating systems, and hardware.\r\n"
                		+ "Work Experience: Candidates with relevant work experience will be preferred.\r\n"
                		+ "Communication Skills: Candidates must have good verbal and written communication skills.\r\n"
                		+ "Problem-Solving Skills: Candidates must have the ability to troubleshoot and solve technical issues.\r\n"
                		+ "Attention to Detail: Candidates must be able to pay attention to details and ensure accuracy in their work.\r\n"
                		+ "Teamwork: Candidates must be able to work well in a team.\r\n"
                		+ "Adaptability: Candidates must be able to adapt to new technologies and processes quickly.\r\n"
                		+ "Certification: Candidates with relevant IT certifications will be preferred.");

                Button applyIt = new Button("Apply for IT Technician");

                GridPane jp = new GridPane();
                jp.setVgap(20);
                jp.setHgap(20);
                jp.setAlignment(Pos.BASELINE_RIGHT);

                jp.add(lIT, 0, 1);
                jp.add(applyIt, 0, 2);

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(jp);
                scrollPane.setFitToWidth(true);
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

                Scene scene = new Scene(scrollPane, 800, 600);
                Stage stage = new Stage();
                scene.setFill(Color.LIGHTBLUE);
                stage.setScene(scene);
                stage.show();

                applyIt.setOnAction(new EventHandler<ActionEvent>() {

                	private Stage parentStage;

					@Override
                	public void handle(ActionEvent event) {
						ITTechnicianRegistrationForm ITTechnicianRegistrationForm = new ITTechnicianRegistrationForm();
						ITTechnicianRegistrationForm.display(parentStage);
                	}
                });

            }
        });

        
        //railways button code
        rail.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("No jobs Announced by Pakistan Railway");
                alert.setHeaderText(null);
                alert.show();
            }
        });

        
        //nay button code
        navy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Label lnavy = new Label(" TRAINING SCHEME\r\n"
                		+ "Recruitment of sailors in Pakistan Navy is carried out twice a year. 1st Batch joins PNS HIMALIYA in the first week of May and 2nd Batch in the first week of November every year.\r\n"
                		+ "After enrolment in the navy as a sailor, they join boot camp training in the New Entry School at PNS HIMALIYA. Upon successful completion of initial training, they are allocated different branches and sent for subsequent Technical training. This forms the basis of their technical base, which is consolidated with subsequent professional and technical training at respective schools.\r\n"
                		+ "PROMOTION PROSPECTS\r\n"
                		+ "The promotion prospects of PN Sailors are as under: • Ordinary Rate/Able Rate • Leading • Petty Officer • Chief Petty Officer • Fleet Chief Petty Officer • Master Chief Petty Officer\r\n"
                		+ "Those who excel in their profession are also afforded the opportunity to rise in the service in Officer ranks upon qualification of pre-requisite courses.\r\n"
                		+ "BENEFITS\r\n"
                		+ "•	Diploma in Engineering\r\n"
                		+ "•	Free Messing, accommodation and uniform\r\n"
                		+ "•	Free Medical treatment of self, family and parents after marriage\r\n"
                		+ "•	Ample opportunities of going abroad on cruises/courses/deputation\r\n"
                		+ "•	In addition to normal pay of Naval Officers 40% extra pay and rations for Officers of Submarine service and SSG(N)\r\n"
                		+ "•	Subsidized education of children in English Medium Schools and Professional Institutions\r\n"
                		+ "•	50% Concession on travel by Air/Railway\r\n"
                		+ "•	Two months leave and one free train voucher from service place of residence in a year\r\n"
                		+ "RECRUITMENT PROCEDURE\r\n"
                		+ "WHO CAN APPLY?\r\n"
                		+ "•	Nationality: Male citizens of Pakistan\r\n"
                		+ "•	Age: For all categories except for MTD and Naib Khateeb is 16 to 20 Years, for MTD branch 16 to 24 Years, for Naib Khateeb not more than 35 Years\r\n"
                		+ "•	Marital Status: Unmarried. However, not applicable to MTD branch and Naib Khateeb candidates\r\n"
                		+ "•	Height 162.5( 5'-4\" ) cm for all branches except for NP/Marine, for PTI & Music branch is 170 cm ( 5'-7\" ).For Female Technician 152.4 cm (5 ft)\r\n"
                		+ "EDUCATIONAL QUALIFICATION\r\n"
                		+ "•	Operation/Aviation/Marine Engineering/Logistic: Matric with 65% marks in aggregate.\r\n"
                		+ "•	Special Branch: Matric Science with 60% marks in aggregate.\r\n"
                		+ "•	MTD: Matric with 50% marks in aggregate.\r\n"
                		+ "•	Naib Khateeb: Matric with 50% marks in aggregate.\r\n"
                		+ "•	PTI: Matric with 50% marks in aggregate.\r\n"
                		+ "•	Music: Matric with 50% marks in aggregate.\r\n"
                		+ "•	Female Technician: Matric with 60% marks in aggregate.\r\n"
                		+ "SELECTION PROCEDURE\r\n"
                		+ "•	Intelligence test\r\n"
                		+ "•	Physical Test\r\n"
                		+ "•	Medical Examination\r\n"
                		+ "•	Interview\r\n"
                		+ "Note: The selection procedure may vary depending on the branch applied for.\r\n"
                		+ "APPLICATION PROCEDURE\r\n"
                		+ "•	Candidates can apply online through the official website of Pakistan Navy or through designated AS&RCs.\r\n"
                		+ "•	Candidates will be required to bring original documents at the time of written test and interview.\r\n"
                		+ "•	Final selection will be based on merit.\r\n"
                		+ "*Note that the information provided above is subject to change and may vary depending on the recruitment process and regulations at the time of the application.\r\n"
                		+ "\r\n"
                		+ "");
                
                Button applysailor = new Button("Apply for Sailor Pak Navy");

                lnavy.setWrapText(true);
//                lnavy.setMaxWidth(value);

                GridPane jp = new GridPane();
                jp.setVgap(20);
                jp.setHgap(20);
                jp.setAlignment(Pos.BASELINE_RIGHT);
                jp.add(lnavy, 0, 1);
                jp.add(applysailor, 0, 2);
                 
                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(jp);
                scrollPane.setFitToWidth(true);
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

                Scene scene = new Scene(scrollPane, 800, 600);
                Stage stage = new Stage();
                scene.setFill(Color.LIGHTBLUE);
                stage.setScene(scene);
                stage.show();
                
                NavyRegistrationForm registrationForm = new NavyRegistrationForm();


                applysailor.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        registrationForm.displayForm(stage); //pass the stage object to the method
                    }
                });

            }
        });

    }
}