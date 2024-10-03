package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TowerExtraC {

    @FXML
    private JFXButton level1;

    @FXML
    private JFXButton level2;

    @FXML
    void delete(ActionEvent event) {
        AllPanes.getInstance().getMapC().deleteTower();
        AllPanes.getInstance().getMapC().isEmpty.put(MapC.getCurrent(),true);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
    }

    @FXML
    void updata(ActionEvent event) {
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        AllPanes.getInstance().getMapC().updateTower();
//        AllPanes.getInstance().getTowerUpdateC().setData();
    }

}
