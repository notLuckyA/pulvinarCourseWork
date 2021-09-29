module com.alekssh.pulvinarcoursework {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;

    exports com.alekssh.pulvinarcoursework;
    exports com.alekssh.pulvinarcoursework.controllers;
    exports com.alekssh.pulvinarcoursework.tables;
    exports com.alekssh.pulvinarcoursework.functional;
    opens com.alekssh.pulvinarcoursework to javafx.fxml;
    opens com.alekssh.pulvinarcoursework.controllers;
    opens com.alekssh.pulvinarcoursework.tables;
    opens com.alekssh.pulvinarcoursework.functional;
}