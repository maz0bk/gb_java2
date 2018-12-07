package sample;

import javafx.fxml.FXML;

import javafx.scene.control.*;

public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField writeMsgField;

    public void textFieldEnter() {
        textArea.appendText(writeMsgField.getText() + "\n");
        writeMsgField.clear();
        writeMsgField.requestFocus();
    }
}
