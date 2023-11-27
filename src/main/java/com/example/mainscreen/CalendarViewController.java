package com.example.mainscreen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;

public class CalendarViewController {
    @FXML
    private ListView<String> timeListView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button confirmAppointment;
    @FXML
    private Button returnToLogin;

    public void initialize() {
        String[] times = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM"};
        ObservableList<String> timeList = FXCollections.observableArrayList(times);

        timeListView.setItems(timeList);
        timeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        timeListView.setVisible(false);

        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                timeListView.setVisible(false);
                confirmAppointment.setDisable(true);
            } else {
                timeListView.setVisible(true);
                setUpTimeListView();
                if (timeListView.getSelectionModel().getSelectedItem() != null) {
                    confirmAppointment.setDisable(false);
                }
            }
        });

       timeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
               if (newValue != null) {
                   confirmAppointment.setDisable(false);
               }
       });

        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(LocalDate.now()) || item.isEqual(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        });
    }

    private void setUpTimeListView() {
        for (int i = 0; i < timeListView.getItems().size(); i++) {
            ListCell<String> cell = getListCell(timeListView, i);
            cell.setAlignment(Pos.CENTER);
        }
    }

    public ListCell getListCell(ListView list, int index) { //found this nice method at https://stackoverflow.com/questions/20936101/get-listcell-via-listview
        Object[] cells = list.lookupAll(".cell").toArray();
        return (ListCell)cells[index];
    }

    public void appointmentSuccess() {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setContentText("Appointment Confirmed");
        successAlert.show();
    }

    public void loadMainScreen(ActionEvent action) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
