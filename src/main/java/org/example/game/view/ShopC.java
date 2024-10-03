package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;
import org.example.game.controller.SpellTableManager;
import org.example.game.model.CoinSpell;
import org.example.game.model.FreezeSpell;
import org.example.game.model.HealthSpell;
import org.example.game.model.LittleboySpell;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShopC implements Initializable {
    ArrayList<Image> spellsImgs = new ArrayList<>();
    int index = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path;
        path = Paths.get("src/main/resources/org/example/game/images/coinSpell.jpg").toAbsolutePath().toString();
        spellsImgs.add(new Image("file:" + path));
        path = Paths.get("src/main/resources/org/example/game/images/fatBoy.jpg").toAbsolutePath().toString();
        spellsImgs.add(new Image("file:" + path));
        path = Paths.get("src/main/resources/org/example/game/images/freeze.jpg").toAbsolutePath().toString();
        spellsImgs.add(new Image("file:" + path));
        path = Paths.get("src/main/resources/org/example/game/images/health.jpg").toAbsolutePath().toString();
        spellsImgs.add(new Image("file:" + path));
    }
    public void setData(){
        gems.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getGem()));
        coinCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getCoinSpell()));
        feezeCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getFreezeSpell()));
        littleBoyCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getLittleBoySpell()));
        healthCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getHealthSpell()));
        index =0;
        board.setImage(spellsImgs.get(index));
    }

    @FXML
    private ImageView board;

    @FXML
    private JFXButton buy;

    @FXML
    private Label coinCount;

    @FXML
    private Label feezeCount;

    @FXML
    private Label gems;

    @FXML
    private Label healthCount;

    @FXML
    private Label littleBoyCount;

    @FXML
    private JFXButton next;

    @FXML
    void buyClick(ActionEvent event) {
        switch (index){
            case 0://coin
                if(PlayerTableManager.getUserDatabaseHandler().getGem()<CoinSpell.getP()){
                    //error
                }
                else {
                    SpellTableManager.getSpellTableManager().updateCoinSpell(1);
                    PlayerTableManager.getUserDatabaseHandler().updateGem(-1 * CoinSpell.getP());
                }
                 break;
            case 1://littleboy
                if(PlayerTableManager.getUserDatabaseHandler().getGem()<LittleboySpell.getP()){
                    //error
                }
                else {
                    SpellTableManager.getSpellTableManager().updateLittleBoySpell(1);
                    PlayerTableManager.getUserDatabaseHandler().updateGem(-1 * LittleboySpell.getP());
                }
                break;
            case 2://freeze
                if(PlayerTableManager.getUserDatabaseHandler().getGem()<FreezeSpell.getP()){
                    //error
                }
                else {
                    SpellTableManager.getSpellTableManager().updateFreezeSpell(1);
                    PlayerTableManager.getUserDatabaseHandler().updateGem(-1 * FreezeSpell.getP());
                }
                break;
            case 3://health
                if(PlayerTableManager.getUserDatabaseHandler().getGem()<HealthSpell.getP()){
                    //error
                }
                else {
                    SpellTableManager.getSpellTableManager().updateHealthSpell(1);
                    PlayerTableManager.getUserDatabaseHandler().updateGem(-1 * HealthSpell.getP());
                }
                break;
        }
        gems.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getGem()));
        coinCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getCoinSpell()));
        feezeCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getFreezeSpell()));
        littleBoyCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getLittleBoySpell()));
        healthCount.setText(String.valueOf(SpellTableManager.getSpellTableManager().getHealthSpell()));

    }
    @FXML
    void doneClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getHomePane());
        AllPanes.getInstance().getHomeC().setData();
    }

    @FXML
    void nextClick(ActionEvent event) {
        index++;
        if(index == spellsImgs.size()) {
            index = 0;
        }
        board.setImage(spellsImgs.get(index));
    }

}
