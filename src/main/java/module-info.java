module com.example.pulvinar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens com.example.pulvinar to javafx.fxml;
    exports com.example.pulvinar;
}