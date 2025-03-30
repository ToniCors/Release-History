package it.toni.releaseHistory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BasicFXMLController {

    public Button button;
    @FXML
    private Label label;

    public void initialize() {
        button.setText("Click");
        // TODO

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        label.setText("Hello World!");
    }
}