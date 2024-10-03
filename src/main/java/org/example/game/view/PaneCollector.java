package org.example.game.view;

import javafx.fxml.FXMLLoader;
import org.example.game.HelloApplication;

import java.io.IOException;

public class PaneCollector {
//    private PaneCollector(){
//
//    }
    private static PaneCollector paneCollector;
    public static PaneCollector getInstance() {
        if (paneCollector == null) {
            paneCollector = new PaneCollector();
        }
        return paneCollector;
    }
    private PaneCollector() {}
    public void collect() {
        FXMLLoader fxmlLoader ;
        /////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/start.fxml"));
        try {
            AllPanes.getInstance().setStartPane(fxmlLoader.load());
            AllPanes.getInstance().setStartC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        ///////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/login.fxml"));
        try {
            AllPanes.getInstance().setLoginPane(fxmlLoader.load());
            AllPanes.getInstance().setLoginC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        ////////////////
        /////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/home.fxml"));
        try {
            AllPanes.getInstance().setHomePane(fxmlLoader.load());
            AllPanes.getInstance().setHomeC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        /////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/shop.fxml"));
        try {
            AllPanes.getInstance().setShopPane(fxmlLoader.load());
            AllPanes.getInstance().setShopC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/map.fxml"));
        try {
            AllPanes.getInstance().setMapPane(fxmlLoader.load());
            AllPanes.getInstance().setMapC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        //////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/towers.fxml"));
        try {
            AllPanes.getInstance().setTowersPane(fxmlLoader.load());
            AllPanes.getInstance().setTowersC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        //////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/spellChoose.fxml"));
        try {
            AllPanes.getInstance().setSpellChoosePane(fxmlLoader.load());
            AllPanes.getInstance().setSpellChooseC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        // ////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/towerUpdate.fxml"));
        try {
            AllPanes.getInstance().setTowerUpdatePane(fxmlLoader.load());
            AllPanes.getInstance().setTowerUpdateC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        // ////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/towerExtra.fxml"));
        try {
            AllPanes.getInstance().setTowerExtraPane(fxmlLoader.load());
            AllPanes.getInstance().setTowerExtraC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////
        // ////////////////
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/setting.fxml"));
        try {
            AllPanes.getInstance().setSettingPane(fxmlLoader.load());
            AllPanes.getInstance().setSettingC(fxmlLoader.getController());
        }
        catch (IOException e) {}
        //////////////////

    }
}
