package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;

import java.nio.file.Paths;

public class TowersC {
    public void setImage(String name, boolean reversed, JFXButton button){
        String path = Paths.get("src/main/resources/org/example/game/images/"+name+".png").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        ImageView imageView = new ImageView(image);
        if(reversed){
            imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        }
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }

    @FXML
    void archer(MouseEvent event) {
        if(HelloApplication.getArcherTower().getPrice()<=PlayerTableManager.getUserDatabaseHandler().getCoin()){
            PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*HelloApplication.getArcherTower().getPrice());
            setImage(HelloApplication.getArcherTower().getImageAddress(),false,MapC.getCurrent());
            AllPanes.getInstance().getMapC().setData();
            AllPanes.getInstance().getMapC().buttonsType.put(MapC.getCurrent(),"archer");
        }
        else{
            //error
        }
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());

    }

    @FXML
    void artillery(MouseEvent event) {
        if(HelloApplication.getArtilleryTower().getPrice()<=PlayerTableManager.getUserDatabaseHandler().getCoin()){
            PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*HelloApplication.getArtilleryTower().getPrice());
            setImage(HelloApplication.getArtilleryTower().getImageAddress(),false,MapC.getCurrent());
            AllPanes.getInstance().getMapC().setData();
            AllPanes.getInstance().getMapC().buttonsType.put(MapC.getCurrent(),"artillery");
        }
        else{
            //error
        }
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());

    }

    @FXML
    void close(MouseEvent event) {
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());
    }

    @FXML
    void mages(MouseEvent event) {
        if(HelloApplication.getMagesTower().getPrice()<=PlayerTableManager.getUserDatabaseHandler().getCoin()){
            PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*HelloApplication.getMagesTower().getPrice());
            setImage(HelloApplication.getMagesTower().getImageAddress(),false,MapC.getCurrent());
            AllPanes.getInstance().getMapC().setData();
            AllPanes.getInstance().getMapC().buttonsType.put(MapC.getCurrent(),"mages");
        }
        else{
            //error
        }
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());

    }

    @FXML
    void wizard(MouseEvent event) {
        if(HelloApplication.getWizardTower().getPrice()<=PlayerTableManager.getUserDatabaseHandler().getCoin()){
            PlayerTableManager.getUserDatabaseHandler().updateCoin(-1*HelloApplication.getWizardTower().getPrice());
            setImage(HelloApplication.getWizardTower().getImageAddress(),false,MapC.getCurrent());
            AllPanes.getInstance().getMapC().setData();
            AllPanes.getInstance().getMapC().buttonsType.put(MapC.getCurrent(),"wizard");
        }
        else{
            //error
        }
        AllPanes.getInstance().getMapC().getGame().getChildren().remove(AllPanes.getInstance().getMapC().getPane());

    }

}
