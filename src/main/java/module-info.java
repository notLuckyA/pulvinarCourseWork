module com.alekssh.pulvinarcoursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alekssh.pulvinarcoursework to javafx.fxml;
    exports com.alekssh.pulvinarcoursework;
}