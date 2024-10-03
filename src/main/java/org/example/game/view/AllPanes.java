package org.example.game.view;

import javafx.scene.layout.AnchorPane;

public class AllPanes {
    private  static  AllPanes allPanes;
    public static AllPanes getInstance(){
        if(allPanes==null){
            allPanes=new AllPanes();
        }
        return allPanes;
    }

    private AnchorPane loginPane;
    public AnchorPane getLoginPane() {
        return loginPane;
    }
    public void setLoginPane(AnchorPane loginPane) {
        this.loginPane = loginPane;
    }
    private LoginC loginC;
    public LoginC getLoginC() {
        return loginC;
    }
    public void setLoginC(LoginC loginC) {
        this.loginC = loginC;
    }
    /////////////////
    private AnchorPane startPane;
    public AnchorPane getStartPane() {
        return startPane;
    }
    public void setStartPane(AnchorPane startPane) {
        this.startPane = startPane;
    }
    private StartC startC;
    public StartC getStartC() {
        return startC;
    }
    public void setStartC(StartC startC) {
        this.startC = startC;
    }
    ////////////////////
    private AnchorPane homePane;
    public AnchorPane getHomePane() {
        return homePane;
    }
    public void setHomePane(AnchorPane home) {
        this.homePane = home;
    }
    private HomeC homeC;
    public HomeC getHomeC() {
        return homeC;
    }
    public void setHomeC(HomeC homeC) {
        this.homeC = homeC;
    }
    //////////////
    private AnchorPane shopPane;
    public AnchorPane getShopPane() {
        return shopPane;
    }
    public void setShopPane(AnchorPane shopPane) {
        this.shopPane = shopPane;
    }
    private ShopC shopC;
    public ShopC getShopC() {
        return shopC;
    }
    public void setShopC(ShopC shopC) {
        this.shopC = shopC;
    }
    ////////////
    private AnchorPane mapPane;
    public AnchorPane getMapPane() {
        return mapPane;
    }
    public void setMapPane(AnchorPane Map) {
        this.mapPane = Map;
    }
    private MapC mapC;
    public MapC getMapC() {
        return mapC;
    }
    public void setMapC(MapC mapC) {
        this.mapC = mapC;
    }
    ////////////
    private AnchorPane towersPane;
    public AnchorPane getTowersPane() {
        return towersPane;
    }
    public void setTowersPane(AnchorPane towersPane) {
        this.towersPane = towersPane;
    }
    private TowersC towersC;
    public TowersC getTowersC() {
        return towersC;
    }
    public void setTowersC(TowersC towersC) {
        this.towersC = towersC;
    }
    ////////////////
    private AnchorPane spellChoosePane;
    public AnchorPane getSpellChoosePane() {
        return spellChoosePane;
    }
    public void setSpellChoosePane(AnchorPane spellChoose) {
        this.spellChoosePane = spellChoose;
    }
    private SpellChoose spellChooseC;
    public SpellChoose getSpellChooseC() {
        return spellChooseC;
    }
    public void setSpellChooseC(SpellChoose spellChooseC) {
        this.spellChooseC = spellChooseC;
    }

    ///////
    private AnchorPane towerUpdate;
    public AnchorPane getTowerUpdatePane() {
        return towerUpdate;
    }
    public void setTowerUpdatePane(AnchorPane towerUpdate) {
        this.towerUpdate = towerUpdate;
    }
    private TowerUpdateC towerUpdateC;
    public TowerUpdateC getTowerUpdateC() {
        return towerUpdateC;
    }
    public void setTowerUpdateC(TowerUpdateC towerUpdateC) {
        this.towerUpdateC = towerUpdateC;
    }
    //////////////////////
    private AnchorPane towerExtraPane;
    public AnchorPane getTowerExtraPane() {
        return towerExtraPane;
    }
    public void setTowerExtraPane(AnchorPane towerExtraPane) {
        this.towerExtraPane = towerExtraPane;
    }
    private TowerExtraC towerExtraC;
    public TowerExtraC getTowerExtraC() {
        return towerExtraC;
    }
    public void setTowerExtraC(TowerExtraC towerExtraC) {
        this.towerExtraC = towerExtraC;
    }
    //////////////////////
    private AnchorPane settingPane;
    public AnchorPane getSettingPane() {
        return settingPane;
    }
    public void setSettingPane(AnchorPane settingPane) {
        this.settingPane = settingPane;
    }
    private SettingC settingC;
    public SettingC getSettingC() {
        return settingC;
    }
    public void setSettingC(SettingC settingC) {
        this.settingC = settingC;
    }

}
