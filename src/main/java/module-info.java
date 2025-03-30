module it.toni.releaseHistory {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.databind;

    requires org.kordamp.bootstrapfx.core;
    requires static lombok;
    requires org.json;

    opens it.toni.releaseHistory to javafx.fxml;
    exports it.toni.releaseHistory;
    exports it.toni.releaseHistory.model;
}