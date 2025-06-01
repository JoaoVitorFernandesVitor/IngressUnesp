package pacote.mainapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    protected String nextStage = "PaneX.fxml";


    @FXML
    public void setStage(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource(nextStage));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(this.scene);
        stage.show();
    }

}