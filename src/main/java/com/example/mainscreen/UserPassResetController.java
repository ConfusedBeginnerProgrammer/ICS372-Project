package com.example.mainscreen;

import com.example.mainscreen.Classes.Hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPassResetController implements Initializable {

    // Variable Declaration
    @FXML
    private Button returnToLogin;
    @FXML
    private ComboBox<String> resetBox;
    @FXML
    private TextField reset;
    @FXML
    private Text output;

    // Initialize drop down menu with options
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetBox.getItems().addAll("Username", "Password");
    }

    // Returns to main screen of application upon clicking corresponding button
    public void loadMainScreen(ActionEvent action) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Handles reset button click
    public void onResetButton(ActionEvent action) throws IOException {

        determineResetType();
    }

    // Gets the option the user selected from drop down menu
    @FXML
    public String getResetBox(){

        String string = resetBox.getValue();
        return string;
    }

    // Gets value user entered into the text box
    public String getToReset() {

        String string = reset.getText().toString();
        return string;
    }

    // Determines type of reset user wants
    public void determineResetType() {
        if(!getResetBox().isEmpty()) {
            if (getResetBox().equalsIgnoreCase("password")) {
                resetPassword(getToReset());
            } else {
                resetUsername(getToReset());
            }
        }
    }

    /*
        Handles Username retrieval

        args: toReset is a password given by the User
     */
    public void resetUsername(String password) {
        if (Hospital.get().getUsers().passwordExists(password)) {
            output.setText(Hospital.get().getUsers().getUsername(password));
        }
    }

    /*
        Handles Password retrieval

        args: toReset is a username given by the User
     */
    public void resetPassword(String username) {
        if (Hospital.get().getUsers().usernameExists(username)) {
            output.setText(Hospital.get().getUsers().getPassword(username));
        }
    }
}
