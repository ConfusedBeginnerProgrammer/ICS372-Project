package com.example.mainscreen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.time.LocalDate;

public class CalendarViewController {
    @FXML
    private ListView<String> timeListView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button confirmAppointment;

    public void initialize() {
        String[] times = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM"};
        ObservableList<String> timeList = FXCollections.observableArrayList(times);

        timeListView.setItems(timeList);
        timeListView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
        timeListView.setVisible(false);

        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                timeListView.setVisible(false);
            } else {
                timeListView.setVisible(true);
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
}
