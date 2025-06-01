package pacote.mainapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends MainController {

    @FXML private TextField username;
    @FXML private PasswordField password;

    public void loginValider(ActionEvent actionEvent) throws IOException {
        if(username.getText().equals("abacaxi") || password.getText().equals("1234")){
            nextStage = "PaneX.fxml";
            setStage(actionEvent);
        }
    }
}
