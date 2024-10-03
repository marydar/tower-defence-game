package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomeC implements Initializable {

    @FXML
    private ImageView coin;

    @FXML
    private Label gem;

    @FXML
    private ImageView gems;

    @FXML
    private JFXButton settting;

    @FXML
    private JFXButton shop;

    @FXML
    private Label stars;


    @FXML
    private JFXButton outSkist;

    @FXML
    private JFXButton pagras;


    @FXML
    private JFXButton silver;

    @FXML
    private JFXButton southport;


    @FXML
    void outSkirtClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getMapPane());
        AllPanes.getInstance().getMapC().setData();
        String path = Paths.get("src/main/resources/org/example/game/images/MiniLevel_0003_Pagras.jpg").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        AllPanes.getInstance().getMapC().getMap().setImage(image);
        AllPanes.getInstance().getMapC().setTowers(4);

    }

    @FXML
    void pagrasClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getMapPane());
        AllPanes.getInstance().getMapC().setData();
        String path = Paths.get("src/main/resources/org/example/game/images/MiniLevel_0002_Outskirts.jpg").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        AllPanes.getInstance().getMapC().getMap().setImage(image);
        AllPanes.getInstance().getMapC().setTowers(2);
    }

    @FXML
    void silverClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getMapPane());
        AllPanes.getInstance().getMapC().setData();
        String path = Paths.get("src/main/resources/org/example/game/images/MiniLevel_0005_Silveroak.jpg").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        AllPanes.getInstance().getMapC().getMap().setImage(image);
        AllPanes.getInstance().getMapC().setTowers(3);

    }

    @FXML
    void southportClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getMapPane());
        AllPanes.getInstance().getMapC().setData();
        String path = Paths.get("src/main/resources/org/example/game/images/MiniLevel_0001_Southport.jpg").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        AllPanes.getInstance().getMapC().getMap().setImage(image);
        AllPanes.getInstance().getMapC().setTowers(1);

    }

    @FXML
    void settingClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getSettingPane());
        AllPanes.getInstance().getSettingC().setData();
    }

    @FXML
    void shopClick(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getShopPane());
        AllPanes.getInstance().getShopC().setData();
    }
    public void setData(){
        try {
            stars.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getCoin()));
            gem.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getGem()));
            setMap();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("eh");
        }
    }
    public void setMap(){
        southport.setVisible(false);
        pagras.setVisible(false);
        outSkist.setVisible(false);
        silver.setVisible(false);
        int level = PlayerTableManager.getUserDatabaseHandler().getLevel();
        if(level > 1){
            setImage("iron",false,southport);
            southport.setVisible(true);
            if(level>2) {
                setImage("iron",true,pagras);
                pagras.setVisible(true);
                if(level>3){
                    setImage("iron",false,silver);
                    setImage("red",true,outSkist);
                    silver.setVisible(true);
                    outSkist.setVisible(true);
                }
                else {
                    setImage("red",false,silver);
                    silver.setVisible(true);
                }
            }
            else{
                setImage("red",false,pagras);
                pagras.setVisible(true);
            }
        }
        else{
            setImage("red",false,southport);
            southport.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage("shop",false,shop);
        setImage("setting",false,settting);


    }
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
}
