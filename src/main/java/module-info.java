module com.example.mainscreen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.mainscreen to javafx.fxml;
    exports com.example.mainscreen;
    exports com.example.mainscreen.AbstractClasses;
    opens com.example.mainscreen.AbstractClasses to javafx.fxml;
    exports com.example.mainscreen.Classes;
    opens com.example.mainscreen.Classes to javafx.fxml;
    exports com.example.mainscreen.Interfaces;
    opens com.example.mainscreen.Interfaces to javafx.fxml;
}