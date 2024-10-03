package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.game.controller.PlayerTableManager;
import org.example.game.controller.SpellTableManager;

import java.util.Timer;
import java.util.TimerTask;

public class SpellChoose {

    @FXML
    private Label coin;

    @FXML
    private JFXButton coinBtn;

    @FXML
    private Label freeze;

    @FXML
    private JFXButton freezeBtn;

    @FXML
    private Label health;

    @FXML
    private JFXButton healthBtn;

    @FXML
    private Label littleBoy;

    @FXML
    private JFXButton littleBoyBtn;

    private int wait = 5;

    @FXML
    void coinBtn(ActionEvent event) {
        SpellTableManager.getSpellTableManager().updateCoinSpell(-1);
        closeSpell();
        PlayerTableManager.getUserDatabaseHandler().updateCoin(200);
        AllPanes.getInstance().getMapC().setData();
    }

    @FXML
    void freezeBtn(ActionEvent event) {
        SpellTableManager.getSpellTableManager().updateFreezeSpell(-1);
        closeSpell();
        AllPanes.getInstance().getMapC().freeze();
        AllPanes.getInstance().getMapC().setData();

    }

    @FXML
    void healthBtn(ActionEvent event) {
        SpellTableManager.getSpellTableManager().updateHealthSpell(-1);
        closeSpell();
        PlayerTableManager.getUserDatabaseHandler().updateHealth(5);
        AllPanes.getInstance().getMapC().setData();

    }

    @FXML
    void littleBoyBtn(ActionEvent event) {
        SpellTableManager.getSpellTableManager().updateLittleBoySpell(-1);
        closeSpell();
        AllPanes.getInstance().getMapC().littleBoyAttack();
        AllPanes.getInstance().getMapC().setData();

    }
    public void closeSpell(){
        AllPanes.getInstance().getMapC().setSpellClicked(false);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        AllPanes.getInstance().getMapC().getSpells().setDisable(true);
        AllPanes.getInstance().getMapC().getSpells().setStyle("-fx-opacity: 0.3");
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                wait--;
                if (wait == 0) {
                    wait=10;
                    System.out.println("wait");
                    AllPanes.getInstance().getMapC().getSpells().setDisable(false);
                    AllPanes.getInstance().getMapC().getSpells().setStyle("-fx-opacity: 1");
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    public void setData(){
        coin.setText(String.valueOf(SpellTableManager.getSpellTableManager().getCoinSpell()));
        freeze.setText(String.valueOf(SpellTableManager.getSpellTableManager().getFreezeSpell()));
        littleBoy.setText(String.valueOf(SpellTableManager.getSpellTableManager().getLittleBoySpell()));
        health.setText(String.valueOf(SpellTableManager.getSpellTableManager().getHealthSpell()));
    }

}
