module com.alekssh.pulvinarcoursework {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires org.hibernate.orm.core;

    exports com.alekssh.pulvinarcoursework;
    opens com.alekssh.pulvinarcoursework to javafx.fxml;
}