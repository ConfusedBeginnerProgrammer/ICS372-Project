package com.example.mainscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.example.mainscreen.Classes.Hospital;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Button register;
    @FXML
    private Button forgot;



    public void handleLogInClick() throws IOException {
        if (Hospital.get().logIn(usernameField.getText(),passwordField.getText())) {
            System.out.println("success");
            Stage stage;
            Parent root;

            stage = (Stage) register.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("DropDown.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Incorrect username or password");
            errorAlert.show();
        }
    }

    public void loadRegistrations(ActionEvent action) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) register.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Registration.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
