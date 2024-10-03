package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.game.HelloApplication;

public class StartC {

    @FXML
    private JFXButton exitBtn;

    @FXML
    private JFXButton startBtn;

    @FXML
    void exitClick(ActionEvent event) {

    }

    @FXML
    void startClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getLoginPane());
    }

}
