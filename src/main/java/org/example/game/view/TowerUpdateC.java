package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;

import java.nio.file.Paths;

public class TowerUpdateC {

    @FXML
    private JFXButton level1;

    @FXML
    private JFXButton level2;

    @FXML
    private JFXButton level3;

    @FXML
    private JFXButton level4;
    private String baseCss ="-fx-background-color: transparent; -fx-border-color: white; -fx-text-fill: white; -fx-border-radius: 10;";

    public void setData(int Tlevel){
        int Plevel = PlayerTableManager.getUserDatabaseHandler().getLevel();
        System.out.println("TLevel: "+Tlevel+"Plevel: "+Plevel);
        if(Tlevel  >1){
            level1.setDisable(true);
            level1.setStyle("-fx-opacity: 0.5;"+baseCss);
            if(Tlevel > 2){
                level2.setDisable(true);
                level2.setStyle("-fx-opacity: 0.5;"+baseCss);
                if(Tlevel > 3){
                    level3.setDisable(true);
                    level3.setStyle("-fx-opacity: 0.5;"+baseCss);
                    level4.setDisable(false);
                    level4.setStyle("-fx-opacity: 1;"+baseCss);

                }
                else{
                    level3.setDisable(false);
                    level3.setStyle("-fx-opacity: 1;"+baseCss);
                    if(Plevel ==3){
                        level4.setDisable(true);
                        level4.setStyle("-fx-opacity: 0.5;"+baseCss);
                    }
                    if(Plevel ==4){
                        level4.setDisable(false);
                        level4.setStyle("-fx-opacity: 1;"+baseCss);
                    }
                }
            }
            else{
                level2.setDisable(false);
                level2.setStyle("-fx-opacity: 1;"+baseCss);
                if(Plevel ==2){
                    level3.setDisable(true);
                    level3.setStyle("-fx-opacity: 0.5;"+baseCss);
                    level4.setDisable(true);
                    level4.setStyle("-fx-opacity: 0.5;"+baseCss);
                }
                if(Plevel ==3){
                    level3.setDisable(false);
                    level3.setStyle("-fx-opacity: 1;"+baseCss);
                    level4.setDisable(true);
                    level4.setStyle("-fx-opacity: 0.5;"+baseCss);
                }
                if(Plevel ==4){
                    level3.setDisable(false);
                    level3.setStyle("-fx-opacity: 1;"+baseCss);
                    level4.setDisable(false);
                    level4.setStyle("-fx-opacity: 1;"+baseCss);
                }
            }
        }
        else{
            level1.setDisable(false);
            level1.setStyle("-fx-opacity: 1;"+baseCss);
            if(Plevel ==1){
                level2.setDisable(true);
                level2.setStyle("-fx-opacity: 0.5;"+baseCss);
                level3.setDisable(true);
                level3.setStyle("-fx-opacity: 0.5;"+baseCss);
                level4.setDisable(true);
                level4.setStyle("-fx-opacity: 0.5;"+baseCss);
            }
            if(Plevel ==2){
                level2.setDisable(false);
                level2.setStyle("-fx-opacity: 1;"+baseCss);
                level3.setDisable(true);
                level3.setStyle("-fx-opacity: 0.5;"+baseCss);
                level4.setDisable(true);
                level4.setStyle("-fx-opacity: 0.5;"+baseCss);
            }
            if(Plevel ==3){
                level2.setDisable(false);
                level2.setStyle("-fx-opacity: 1;"+baseCss);
                level3.setDisable(false);
                level3.setStyle("-fx-opacity: 1;"+baseCss);
                level4.setDisable(true);
                level4.setStyle("-fx-opacity: 0.5;"+baseCss);
            }
            if(Plevel ==4){
                level2.setDisable(false);
                level2.setStyle("-fx-opacity: 1 ;"+baseCss);
                level3.setDisable(false);
                level3.setStyle("-fx-opacity: 1;"+baseCss);
                level4.setDisable(false);
                level4.setStyle("-fx-opacity: 1;"+baseCss);
            }


        }

    }
    @FXML
    void level1Click(ActionEvent event) {
        AllPanes.getInstance().getMapC().buttonsLevel.put(MapC.getCurrent(),1);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        buy(1);


    }

    @FXML
    void level2Click(ActionEvent event) {
        AllPanes.getInstance().getMapC().buttonsLevel.put(MapC.getCurrent(),2);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        buy(2);

    }

    @FXML
    void level3Click(ActionEvent event) {
        AllPanes.getInstance().getMapC().buttonsLevel.put(MapC.getCurrent(),3);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        buy(3);

    }

    @FXML
    void level4Click(ActionEvent event) {
        AllPanes.getInstance().getMapC().buttonsLevel.put(MapC.getCurrent(),4);
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
        buy(4);

    }
    public void buy(int level){
        switch (AllPanes.getInstance().getMapC().buttonsType.get(MapC.getCurrent())){
            case "none":
                break;
            case "archer":
                PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*level*(HelloApplication.getArcherTower().getPrice()/2));
                break;
            case "mages":
                PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*level*(HelloApplication.getMagesTower().getPrice()/2));

                break;
            case "wizard":
                PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*level*(HelloApplication.getWizardTower().getPrice()/2));

                break;
            case "artillery":
                PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*level*(HelloApplication.getArtilleryTower().getPrice()/2));

                break;
        }
        AllPanes.getInstance().getMapC().setData();
    }

}
