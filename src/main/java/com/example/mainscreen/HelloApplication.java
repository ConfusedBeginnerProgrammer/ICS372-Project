package com.example.mainscreen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import com.example.mainscreen.Classes.Hospital;
import com.example.mainscreen.Classes.Patient;
import org.controlsfx.control.action.Action;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Patient newPatient = new Patient("Jane","Doe","user1","pass1","jd@email.com","123 main st");
        Hospital.get().addPatient(newPatient);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("MedSched");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}