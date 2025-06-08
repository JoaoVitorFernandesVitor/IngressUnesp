package pacote.mainapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
public class EventCardController {

    private static String path;
    @FXML private VBox LabelContainer;
    @FXML private Button btnBuy;

    public VBox getLabelContainer() {
        return LabelContainer;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

    public void setPath(String newpath) {
        path = newpath;
    }

    private static String getPath(){
        return path;
    }

    public static void BuyBtn(ActionEvent event) {
        try {
            NavigationController.goTo((Node) event.getSource(),  getPath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
