package com.example.mainscreen;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DropDownController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    //Used to test to see if the DropDown worked. If you want to test this you'll need to extend the Application class
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DropDown.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
//        stage.setTitle("MedSched");
//        stage.setScene(scene);
//        stage.show();
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Primary Care", "Covid 19 Treatment", "OB/GYN", "Dermetology", "Physical Therapy");
    }

    @FXML
    public String getComboBox(ActionEvent event){
        return comboBox.getValue();
    }

    public void next(){

    }
}
