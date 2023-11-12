package com.example.mainscreen;

import com.example.mainscreen.Classes.Hospital;
import com.example.mainscreen.Classes.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Button returnToLogin;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField address;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField verifyPassword;
    private Hospital hospital;
    public void loadMainScreen(ActionEvent action) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void register() throws IOException {
        String validator = RegistrationValidator.validate(username.getText(), password.getText(), verifyPassword.getText(), firstName.getText(), lastName.getText(), email.getText(), address.getText());
        if (validator.isEmpty()) {
            if (Hospital.get().registerPatient(firstName.getText(), lastName.getText(), username.getText(), password.getText(), email.getText(), address.getText())) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setContentText("Registration successful!");
                successAlert.show();
                Stage stage;
                Parent root;

                stage = (Stage) returnToLogin.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setContentText("That username is already in use!");
                errorAlert.show();
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText(validator);
            errorAlert.show();
        }
    }

    public Hospital getHospital(){
        return this.hospital;
    }

    private void error(){

    }
}
