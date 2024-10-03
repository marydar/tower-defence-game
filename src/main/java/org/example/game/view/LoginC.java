package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;

public class LoginC {

    @FXML
    private JFXButton loginBtn;
    @FXML
    private Label error;

    @FXML
    private JFXButton loginOrSignup;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    public boolean isSignup=true;

    @FXML
    void logSigClick(ActionEvent event) {
        if(isSignup){
            loginBtn.setText("login");
            loginOrSignup.setText("dont you have an account? signup");
            isSignup = false;
        }
        else{
            loginBtn.setText("signup");
            loginOrSignup.setText("already have an account? login");
            isSignup = true;
        }
    }

    @FXML
    public void loginClick(ActionEvent event) {
        if(isSignup){
            try {
                PlayerTableManager.getUserDatabaseHandler().signup(username.getText(), password.getText());
                HelloApplication.setScene(AllPanes.getInstance().getHomePane());
                AllPanes.getInstance().getHomeC().setData();
            }catch (Exception e){
                error.setText(e.getMessage());
            }

        }
        else{
            try {
                PlayerTableManager.getUserDatabaseHandler().loginUser(username.getText(), password.getText());
                HelloApplication.setScene(AllPanes.getInstance().getHomePane());
                AllPanes.getInstance().getHomeC().setData();
            }catch (Exception e){
                error.setText(e.getMessage());
            }

        }
    }

}
