
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Kalman Muller on 4/22/2017.
 */
public class GUI extends Application {



    @Override
    public void start(Stage primaryStage) {
//Login Stage
        VBox loginpane = new VBox();
        loginpane.setAlignment(Pos.CENTER);
        Label user = new Label("Username");
        user.setPadding(new Insets(5));
        TextField userbox = new TextField();
        Label pass = new Label("Password");
        pass.setPadding(new Insets(5));
        PasswordField passbox = new PasswordField();


        loginpane.getChildren().add(user);
        loginpane.getChildren().add(userbox);
        loginpane.getChildren().add(pass);
        loginpane.getChildren().add(passbox);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.BASELINE_CENTER);
        buttons.setSpacing(5);
        buttons.setPadding(new Insets(5));

        Button signup = new Button("Reset Login Information");
        Button login = new Button("Login");

        buttons.getChildren().add(signup);
        buttons.getChildren().add(login);

        loginpane.getChildren().add(buttons);

        Scene scene1 = new Scene(loginpane, 300, 300);
        primaryStage.setTitle("Assignment Distribution Login");
        primaryStage.setScene(scene1);
        primaryStage.show();

//Invalid Login Stage
        VBox invalidLogin = new VBox();
        invalidLogin.setAlignment(Pos.CENTER);
        Label wrongInfo = new Label("Invalid Username or Password");
        wrongInfo.setTextFill(Color.RED);
        invalidLogin.getChildren().add(wrongInfo);
        Scene wrongInfoScene = new Scene(invalidLogin, 200, 100);
        Stage wrongInfoStage = new Stage();
        wrongInfoStage.setScene(wrongInfoScene);
        wrongInfoStage.setTitle("Invalid Login Info");

//Reset Login Stage
        VBox resetpane = new VBox();
        resetpane.setAlignment(Pos.CENTER);
        resetpane.setSpacing(5);
        Label currentuser = new Label("Enter the Current Username (Default Username is user)");
        TextField currentusertext = new TextField();
        Label currentpass = new Label("Enter the Current Password (Default Password is pass)");
        TextField currentpasstext = new TextField();
        Label newUser = new Label("Enter the New Username");
        TextField newUserText = new TextField();
        Label newPass = new Label("Enter the New Password");
        TextField newPassText = new TextField();
        Button loginreset = new Button("Reset Login Info");

        resetpane.getChildren().addAll(currentuser, currentusertext, currentpass, currentpasstext, newUser, newUserText, newPass, newPassText, loginreset);

        Scene resetScene = new Scene(resetpane, 300, 300);
        Stage resetStage = new Stage();
        resetStage.setScene(resetScene);
        resetStage.setTitle("Reset Login Info");

//Create/Load Class Roster Stage
        VBox classRosterPane = new VBox();
        classRosterPane.setAlignment(Pos.CENTER);
        classRosterPane.setSpacing(20);

        Button newClassRoster = new Button("Create a New Class Roster");
        Button loadClassRoster = new Button("Load a Class Roster");

        classRosterPane.getChildren().addAll(newClassRoster, loadClassRoster);
        Scene classRosterScene = new Scene(classRosterPane, 300, 300);
        Stage classRosterStage = new Stage();
        classRosterStage.setTitle("Class Roster");
        classRosterStage.setScene(classRosterScene);

//Class Name Stage
        VBox classNamePane = new VBox(10);
        classNamePane.setAlignment(Pos.CENTER);

        Label className = new Label("Enter a Name for the Class Roster");
        TextField classNameText = new TextField();
        Button setClassName = new Button("Set Class Roster Name");

        classNamePane.getChildren().addAll(className, classNameText, setClassName);

        Scene classNameScene = new Scene(classNamePane, 300, 300);
        Stage classNameStage = new Stage();
        classNameStage.setScene(classNameScene);
        classNameStage.setTitle("Set Class Roster Name");

//Create Class Roster Stage
        VBox studentBasePane = new VBox(5);
        studentBasePane.setAlignment(Pos.CENTER);

        GridPane studentNamePane = new GridPane();
        studentNamePane.setHgap(5);
        studentNamePane.setVgap(5);
        studentNamePane.setAlignment(Pos.CENTER);

        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        TextField firstNameText = new TextField();
        TextField lastNameText = new TextField();

        studentNamePane.add(firstName,0,0);
        studentNamePane.add(firstNameText,0,1);
        studentNamePane.add(lastName,1,0);
        studentNamePane.add(lastNameText,1,1);

        Label studentEmail = new Label("Email");
        TextField studentEmailText = new TextField();

        HBox rosterButtons = new HBox(5);
        rosterButtons.setAlignment(Pos.CENTER);

        Button nextStudent = new Button("Next Student");
        Button finalize = new Button("Finalize Roster");

        rosterButtons.getChildren().addAll(nextStudent,finalize);

        studentBasePane.getChildren().add(studentNamePane);
        studentBasePane.getChildren().add(studentEmail);
        studentBasePane.getChildren().add(studentEmailText);
        studentBasePane.getChildren().add(rosterButtons);

        Scene studentInfoScene = new Scene(studentBasePane,300,300);
        Stage studentInfoStage = new Stage();
        studentInfoStage.setTitle("Create Class Roster");
        studentInfoStage.setScene(studentInfoScene);

//Set Problems Stage

        VBox problemPane = new VBox(5);
        problemPane.setAlignment(Pos.CENTER);

        Label instructions  = new Label("Enter the problems from the chapter you wish to assign separated by a space below ");
        Label example = new Label("(Ex:1.1 1.2 1.3 1.4 ...) If their are more students then problems assigned, problems my be assigned to multiple students");

        TextField problemSetText = new TextField();



        Button problemDone = new Button("Done");

        problemPane.getChildren().addAll(instructions,example,problemSetText,problemDone);

        Scene problemScene = new Scene(problemPane, 700, 300);
        Stage problemStage = new Stage();
        problemStage.setTitle("Enter The Problem Set");
        problemStage.setScene(problemScene);


//Problems Assigned

        VBox assignedBasePane = new VBox(5);
        assignedBasePane.setAlignment(Pos.CENTER);
        Label assignedLabel = new Label("Problems have Been Assigned");



        Button assignedTxt = new Button("Generate Assigned Problems File (file called receipt.txt)");
        Button assignedEmail = new Button("Email Students Assigned Problems");


        assignedBasePane.getChildren().addAll(assignedLabel,assignedTxt,assignedEmail);

        Scene assignedScene = new Scene(assignedBasePane, 400, 300);
        Stage assignedStage = new Stage();
        assignedStage.setTitle("Assigned Problems");
        assignedStage.setScene(assignedScene);


//Email info Stage

        VBox emailPane = new VBox(5);
        emailPane.setAlignment(Pos.CENTER);
        Label email = new Label("Email Address to send from");
        TextField emailText = new TextField();
        Label emailUser = new Label("Email Username");
        TextField emailUserText = new TextField();
        Label emailPass = new Label("Email Password");
        PasswordField emailPassText = new PasswordField();
        Button send = new Button("Send");

        emailPane.getChildren().addAll(email,emailText,emailUser,emailUserText,emailPass,emailPassText,send);

        Scene emailScene = new Scene(emailPane,300,300);
        Stage emailStage = new Stage();
        emailStage.setScene(emailScene);
        emailStage.setTitle("Email Information");

//Final Stage
        VBox finalPane = new VBox(5);
        finalPane.setAlignment(Pos.CENTER);

        Label sent = new Label("Emails have been sent.");

        finalPane.getChildren().add(sent);

        Scene finalScene = new Scene(finalPane, 200, 200);
        Stage finalStage = new Stage();
        finalStage.setScene(finalScene);
        finalStage.setTitle("Email Sent");






//Login Button Events
        login.setOnAction(e -> {
            try {
                if (loginCheck(userbox.getText(), passbox.getText())) {
                    primaryStage.close();
                    classRosterStage.show();
                } else {
                    wrongInfoStage.show();
                }

            } catch (FileNotFoundException ex) {
                System.out.println("login check page error: login.txt not Found");
            }
        });


        signup.setOnAction(event -> resetStage.show());

//Reset Login Events
        loginreset.setOnAction(event -> {
            try {
                if (loginCheck(currentusertext.getText(), currentpasstext.getText())) {
                    PrintWriter resetInfo = new PrintWriter(new FileOutputStream("login.txt", false));
                    resetInfo.print(newUserText.getText() + " " + newPassText.getText());
                    resetInfo.close();
                    resetStage.close();
                } else {
                    wrongInfoStage.show();
                }

            } catch (FileNotFoundException ex) {
                System.out.println("login check page error: login.txt not Found");
            }
        });


//New Class Roster Events
        newClassRoster.setOnAction(event -> {
            classRosterStage.close();
         classNameStage.show();
         });


        final File[] classRoster = new File[1];

//Set new Class Roster Name Event
        final PrintWriter[] newRoster = new PrintWriter[1];
        setClassName.setOnAction(event -> {
            try {
                newRoster[0] = new PrintWriter(new FileOutputStream(classNameText.getText()+".txt",false));

                classRoster[0] = new File(classNameText.getText()+".txt");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            classNameStage.close();
            studentInfoStage.show();
        });

//Create Class Roster Events
        nextStudent.setOnAction(event -> {
            if(firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() || studentEmailText.getText().isEmpty()) {
                System.out.println("Student info missing");
            }else{
                newRoster[0].println(firstNameText.getText() + " " + lastNameText.getText() + " " + studentEmailText.getText());
            }
            firstNameText.setText("");
            lastNameText.setText("");
            studentEmailText.setText("");

        });

        finalize.setOnAction(event -> {
            if (firstNameText.getText().isEmpty() && lastNameText.getText().isEmpty() && studentEmailText.getText().isEmpty()){

            }else {
                if (firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() || studentEmailText.getText().isEmpty()) {
                    System.out.println("Student info missing: last Student was not added, verify Roster File");
                } else {
                    newRoster[0].println(firstNameText.getText() + " " + lastNameText.getText() + " " + studentEmailText.getText());
                }
            }


            newRoster[0].close();
            studentInfoStage.close();
            problemStage.show();
            studentInfoStage.close();

        });



//Load Class Roster Events


        loadClassRoster.setOnAction(event -> {
            FileChooser loadRoster = new FileChooser();
            loadRoster.setTitle("Open Roster File");
            classRoster[0] = loadRoster.showOpenDialog(classRosterStage);

            classRosterStage.close();
            problemStage.show();
        });


//Problems Event
        ArrayList<String> problems = new ArrayList<>();
        final String[][][] assigned = new String[1][1][1];
        final int[] lines = new int[1];

        problemDone.setOnAction(event -> {
            String rawProblems = problemSetText.getText();
          try {
              while (rawProblems != null) {

                  if (rawProblems.contains(" ")) {

                      problems.add(rawProblems.substring(0, rawProblems.indexOf(" ")));
                      rawProblems = rawProblems.substring(rawProblems.indexOf(" ") + 1);
                  } else {
                      problems.add(rawProblems);
                      rawProblems = null;
                  }

              }


          }catch (IndexOutOfBoundsException ex){
              System.out.println("Problem set input error: Do not put a space at the Start or End of the Problem Set");
          }

            Collections.shuffle(problems);
            try {

                Scanner in = new Scanner(classRoster[0]);
              lines[0] = countLines(classRoster[0]);
                 assigned[0] = new String[lines[0]][4];

                 for (int i = 0; i< lines[0]; i++){
                     for(int j = 0; j<4;j++){
                         if(j<3){
                             assigned[0][i][j] =  in.next();

                         }else{
                             assigned[0][i][j] = nextProblem(problems);
                         }
                     }

                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
            problemStage.close();
            assignedStage.show();


        });

//Assigned Event
        assignedTxt.setOnAction(event -> {
            try {
                PrintWriter receipt = new PrintWriter(new FileOutputStream("receipt.txt",false));

                for (int i = 0;i<lines[0];i++){
                    receipt.println(assigned[0][i][0]+" "+assigned[0][i][1]+" "+assigned[0][i][2]+" "+assigned[0][i][3]);
                }
                receipt.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        });

        assignedEmail.setOnAction(event -> {
            assignedStage.close();
            emailStage.show();

        });

//Email info events
        send.setOnAction(event -> {
            if (emailText.getText().isEmpty() || emailUserText.getText().isEmpty() || emailPassText.getText().isEmpty()){
                System.out.println("Email Login Info Missing");
            }else {
                Emailer sendEmails = new Emailer(emailUserText.getText(),emailPassText.getText());

                for (int i = 0;i<lines[0];i++){

                    sendEmails.sendEmail(emailText.getText(),assigned[0][i][2],"CSC Homework Assignment",assigned[0][i][0] + " " + assigned[0][i][1] + ", You have been Assigned Problem " +assigned[0][i][3]);
                }
                emailStage.close();
                finalStage.show();
            }

        });

    }

    private Boolean loginCheck(String username, String password) throws FileNotFoundException {

        Scanner checkpass = new Scanner(new File("login.txt"));

        while (checkpass.hasNext()) {
            if (checkpass.next().equals(username)) {
                if (checkpass.next().equals(password)) {
                    return true;
                }

            } else {
                checkpass.next();
            }
        }
        return false;


    }

    private int countLines(File file) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }
    private int listRef = 0;
    private String nextProblem(ArrayList<String> list){
        if (listRef<list.size()){
            listRef = listRef+1;
            return list.get(listRef-1);

        }else{
            listRef = 0;
            return list.get(listRef);

        }
    }




}
