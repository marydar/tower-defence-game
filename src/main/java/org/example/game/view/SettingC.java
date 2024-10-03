package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class SettingC implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = Paths.get("src/main/resources/org/example/game/images/speaker.png").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        ImageView imageView = new ImageView(image);
            imageView.setFitHeight(80);
            imageView.setFitWidth(80);
        imageView.setPreserveRatio(true);
        speaker.setGraphic(imageView);
    }

    @FXML
    private JFXButton change;

    @FXML
    private JFXButton changePass;

    @FXML
    private JFXButton changeUser;

    @FXML
    private TextField firstF;

    @FXML
    private TextField secondF;

    @FXML
    private JFXButton speaker;

    @FXML
    private Label username;
    private boolean isPassword=false;

    public void setData(){
        username.setText(PlayerTableManager.loginPlayer);
        secondF.setVisible(false);
        firstF.setVisible(false);
        change.setDisable(false);


    }

    @FXML
    void changeClick(ActionEvent event) {
        if(isPassword){
            if(PlayerTableManager.getUserDatabaseHandler().getPassword().equals(firstF.getText())){
                PlayerTableManager.getUserDatabaseHandler().updatePass(secondF.getText());
            }
            else{
                firstF.setPromptText("your previous password");
                secondF.setPromptText("your new password");
                firstF.setText("");
                secondF.setText("");
            }
        }
        else{
            PlayerTableManager.getUserDatabaseHandler().updateUsername((firstF.getText()));
        }
        username.setText(PlayerTableManager.loginPlayer);
        secondF.setVisible(false);
        firstF.setVisible(false);
        change.setDisable(false);
        firstF.setText("");
        secondF.setText("");


    }

    @FXML
    void changePassClick(ActionEvent event) {
        isPassword=true;
        secondF.setVisible(true);
        firstF.setVisible(true);
        change.setVisible(true);
        firstF.setText("");
        secondF.setText("");
        firstF.setPromptText("your previous password");
        secondF.setPromptText("your new password");
    }

    @FXML
    void changeUserClick(ActionEvent event) {
        isPassword=false;
        secondF.setVisible(false);
        firstF.setVisible(true);
        change.setVisible(true);
        firstF.setText("");
        secondF.setText("");
        firstF.setPromptText("your new username");

    }

    private boolean isMute =false;
    @FXML
    void mute(ActionEvent event) {
        if(isMute){
            isMute=false;
            HelloApplication.getMediaPlayer().setMute(false);
        }else{
            isMute=true;
            HelloApplication.getMediaPlayer().setMute(true);
        }
    }
    @FXML
    void back(ActionEvent event) {
        HelloApplication.setScene(AllPanes.getInstance().getHomePane());
        AllPanes.getInstance().getHomeC().setData();
    }

}
