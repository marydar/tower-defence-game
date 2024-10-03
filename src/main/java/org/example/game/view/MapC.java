package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import org.example.game.HelloApplication;
import org.example.game.controller.PlayerTableManager;
import org.example.game.model.*;

import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class MapC implements Initializable {
    private static int count=0;
    ArrayList<JFXButton> towers;
    private int mapLevel=0;
    private ArrayList<Raider> raiders=new ArrayList<>();
    int wait =2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage("spells",false,spells);
        setImage("run",false,runBtn);
        setImage("back",false,backBtn);
        map.setOnMouseClicked(e->{
            System.out.println("x: "+e.getX()+" y: "+e.getY());
        });


    }
    public void addRaider(int i , String type){
        System.out.println("in add");
        ImageView imageView = new ImageView();
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        String path="";
        double FLYSPEED = 0.3333;
        ArrayList<Image> images=new ArrayList<>();
        if(type.equals("fly")) {
            path = HelloApplication.getFlyRaiderImages().get(0);
            raiders.add(new FlyingRaider(FLYSPEED, 200, 200, HelloApplication.getFlyRaiderImages(), imageView));
            images = HelloApplication.getflyImages();
        }else if(type.equals("shield")) {
            path = HelloApplication.getFlyRaiderImages().get(0);
            raiders.add(new ShieldRaider(FLYSPEED, 200, 200, HelloApplication.getSheildRaiderImages(), imageView));
            images = HelloApplication.getSheildImgs();
        }
        else if(type.equals("speed")) {
            path = HelloApplication.getFlyRaiderImages().get(0);
            raiders.add(new UltraSpeedRaider(FLYSPEED*3, 200, 200, HelloApplication.getSpeedRaiderImages(), imageView));
            images = HelloApplication.getSpeedImages();
        }else if(type.equals("health")) {
            path = HelloApplication.getFlyRaiderImages().get(0);
            raiders.add(new DoubledHealthRaider(FLYSPEED, 200, 200, HelloApplication.getDoubleRaiderImages(), imageView));
            images = HelloApplication.getHealthImages();
        }

        Image image = new Image("file:" + path);
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        if(i%2==0){
            imageView.setTranslateX(dotsX.get(0));
            imageView.setTranslateY(dotsY.get(0));
        }
        else {
            imageView.setTranslateX(dotsX2.get(0));
            imageView.setTranslateY(dotsY2.get(0));
        }
        game.getChildren().add(imageView);
        move(images,raiders.getLast(),i);
    }
    public void move(ArrayList<Image> movement,Raider c, int i){



        final int x = count++;

        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(100),
                (ActionEvent Aevent) -> {
//                    System.out.println("key1 +"+x);
                    if(!c.isDead()) {

                        c.setCurrenImg(c.getCurrenImg() + 1);
                        if (c.getCurrenImg() == c.getImgs().size()) {
                            c.setCurrenImg(0);
                        }

                        c.getImageView().setImage(movement.get(c.getCurrenImg()));
                    }

                    Aevent.consume();

                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),
                (ActionEvent Aevent) -> {
                    if(!c.isDead()) {
//                    System.out.println("key2 +"+x);
                        c.setCurrenImg(c.getCurrenImg() + 1);
                        if (c.getCurrenImg() == c.getImgs().size()) {
                            c.setCurrenImg(0);
                        }

                        c.getImageView().setImage(movement.get(c.getCurrenImg()));
                    }

                    Aevent.consume();

                }
        ));
        t.play();
        c.setCurrentPlace(c.getCurrentPlace()+1);
        if(i%2==0){

            transistion(c,c.getTt(),c.getImageView(),dotsX.get(c.getCurrentPlace()),dotsY.get(c.getCurrentPlace()),i,x);
        }
        else{
            transistionPath2(c,c.getTt(),c.getImageView(),dotsX2.get(c.getCurrentPlace()),dotsY2.get(c.getCurrentPlace()),i);

        }

    }
    public void transistion(Raider c, TranslateTransition tt,ImageView imageView,int x,int y,int i, int d){
//        System.out.println("d"+d);
        checkRange(c, imageView.getTranslateX(),imageView.getTranslateY());
        tt.setFromX(imageView.getTranslateX());
        tt.setFromY(imageView.getTranslateY());
        tt.setToX(x);
        tt.setToY(y);
        double X = imageView.getTranslateX();
        double Y = imageView.getTranslateY();
        double distance = ((X-x)*(X-x))+((Y-y)*(Y-y));
        tt.setDuration(Duration.millis(distance/c.getSpeed()/100.0));
        SequentialTransition seqTransition = new SequentialTransition (
                new PauseTransition(Duration.millis(500*i)), // wait a second
                tt
        );
        c.setSequentialTransition(seqTransition);
        seqTransition.play();
        seqTransition.setOnFinished(e->{
            if(!c.isDead()){
                c.setCurrentPlace(c.getCurrentPlace()+1);
                System.out.println(c.getCurrentPlace());
                if(c.getCurrentPlace()==dotsX.size() ){
                    c.setCurrentPlace(0);
                    game.getChildren().remove(imageView);
                    raiders.remove(c);
                    PlayerTableManager.getUserDatabaseHandler().updateHealth(-1);
                    setData();
                    if(PlayerTableManager.getUserDatabaseHandler().getHealth()==0){
                        endLevel();
                    }
//                    c.getTimeline().stop();
                    if(raiders.isEmpty()){
                        wave++;
                        if(wave==2&& mapLevel>=wave) {
                            wave2();
                        }
                        else if(wave==3&& mapLevel>=wave) {
                            wave3();
                        }
                        else if(wave==4&& mapLevel>=wave) {
                            wave4();
                        }
                        else {
                            endLevel();
                        }
                    }
                }else{
                    transistion(c,tt,imageView,dotsX.get(c.getCurrentPlace()),dotsY.get(c.getCurrentPlace()),0,d);
                }
            }

        });
    }
    public void endLevel(){

        System.out.println("health"+PlayerTableManager.getUserDatabaseHandler().getHealth());
       if(PlayerTableManager.getUserDatabaseHandler().getHealth()>0){
           if(mapLevel==PlayerTableManager.getUserDatabaseHandler().getLevel()) {
               PlayerTableManager.getUserDatabaseHandler().updateLevel(1);
           }
           if(mapLevel==1)
           {

               PlayerTableManager.getUserDatabaseHandler().updateGem(HelloApplication.getMap1().getGems());
           }if(mapLevel==2)
           {
               PlayerTableManager.getUserDatabaseHandler().updateGem(HelloApplication.getMap2().getGems());
           }if(mapLevel==3)
               PlayerTableManager.getUserDatabaseHandler().updateGem(HelloApplication.getMap3().getGems());
           {

           }if(mapLevel==4)
               PlayerTableManager.getUserDatabaseHandler().updateGem(HelloApplication.getMap4().getGems());
           {

           }
          HelloApplication.setScene(AllPanes.getInstance().getHomePane());
          AllPanes.getInstance().getHomeC().setData();
       }
       else{
           PlayerTableManager.getUserDatabaseHandler().updateHealth((int)(PlayerTableManager.getUserDatabaseHandler().getHealth())*-1);
           HelloApplication.setScene(AllPanes.getInstance().getHomePane());
           AllPanes.getInstance().getHomeC().setData();
       }
    }
    public void transistionPath2(Raider c, TranslateTransition tt,ImageView imageView,int x,int y,int i){
        checkRange(c, imageView.getTranslateX(),imageView.getTranslateY());
        tt.setFromX(imageView.getTranslateX());
        tt.setFromY(imageView.getTranslateY());
        tt.setToX(x);
        tt.setToY(y);
        double X = imageView.getTranslateX();
        double Y = imageView.getTranslateY();
        double distance = ((X-x)*(X-x))+((Y-y)*(Y-y));
        tt.setDuration(Duration.millis(distance/c.getSpeed()/100.0));
        SequentialTransition seqTransition = new SequentialTransition (
                new PauseTransition(Duration.millis(500*i)), // wait a second
                tt
        );
        c.setSequentialTransition(seqTransition);
        seqTransition.play();
        seqTransition.setOnFinished(e->{
            if(!c.isDead()){
                c.setCurrentPlace(c.getCurrentPlace()+1);
                System.out.println(c.getCurrentPlace());
                if(c.getCurrentPlace()==dotsX2.size()){
                    c.setCurrentPlace(0);
                    game.getChildren().remove(imageView);
                    raiders.remove(c);
//                    c.getTimeline().stop();
//                    c.getTt().stop();
                    PlayerTableManager.getUserDatabaseHandler().updateHealth(-1);
                    setData();
                    if(PlayerTableManager.getUserDatabaseHandler().getHealth()==0){
                        endLevel();
                    }
                    if(raiders.isEmpty()){
                        wave++;
//                        if(wave==2&& mapLevel>=wave) {
//                            wave2();
//                        }
//                        if(wave==3&& mapLevel>=wave) {
//                            wave3();
//                        }
//                        if(wave==4&& mapLevel>=wave) {
//                            wave4();
//                        }
//                        if(wave==5&& mapLevel>=wave) {
//                            endLevel();
//                        }
                        if(wave==2&& mapLevel>=wave) {
                            wave2();
                        }
                        else if(wave==3&& mapLevel>=wave) {
                            wave3();
                        }
                        else if(wave==4&& mapLevel>=wave) {
                            wave4();
                        }
                        else {
                            endLevel();
                        }
                    }
                }else{
                    transistionPath2(c,tt,imageView,dotsX2.get(c.getCurrentPlace()),dotsY2.get(c.getCurrentPlace()),0);
                }
            }

        });
    }
    ArrayList<Integer> dotsX=new ArrayList<>();
    ArrayList<Integer> dotsY=new ArrayList<>();
    ArrayList<Integer> dotsX2=new ArrayList<>();
    ArrayList<Integer> dotsY2=new ArrayList<>();
    private boolean addRaider=false;
    private int wave =1;
    public int getWave(){
        return wave;
    }
    public int getMapLevel(){
        return mapLevel;
    }
    @FXML
    private Label waveLbl;
    @FXML
    private JFXButton runBtn;
    private boolean inWait=false;
    Timeline t;
    private int hundred=100;
    @FXML
    public void run(ActionEvent event) {
        runBtn.setStyle("-fx-opacity: 0.5");
        runBtn.setDisable(true);
        backBtn.setStyle("-fx-opacity: 0.5");
        backBtn.setDisable(true);
        game.setOnMouseClicked(e->{
            System.out.println("x: "+e.getX()+" y: "+e.getY());
//            checkRange(e.getX(),e.getY());
        });
        t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);
            wave1();




    }
    @FXML
    public void back(ActionEvent event) {
//        t.stop();
//        for(Raider r : raiders){
//            game.getChildren().remove(r);
//        }
        HelloApplication.setScene(AllPanes.getInstance().getHomePane());
        AllPanes.getInstance().getHomeC().setData();
    }
    public void wave2(){
        waveLbl.setText("Wave : 2 / "+mapLevel);
//        for (int i = 0; i < 2; i++) {
//            addRaider(i, "fly");
//        }
        for (int i = 0; i < 2; i++) {
            addRaider(i, "fly");
        }
        for (int i = 2; i < 4; i++) {
            addRaider(i, "shield");
        }
        for (int i = 4; i < 6; i++) {
            addRaider(i, "speed");
        }
        for (int i = 6; i < 8; i++) {
            addRaider(i, "health");
        }
    }
    public void wave3(){
        waveLbl.setText("Wave : 3 / "+mapLevel);
        for (int i = 0; i < 2; i++) {
            addRaider(i, "fly");
        }
//        for (int i = 0; i < 3; i++) {
//            addRaider(i, "fly");
//        }
        for (int i = 2; i < 4; i++) {
            addRaider(i, "shield");
        }
        for (int i = 4; i < 6; i++) {
            addRaider(i, "speed");
        }
        for (int i = 6; i < 8; i++) {
            addRaider(i, "speed");
        }
    }
    public void wave4(){
        waveLbl.setText("Wave : 4 / "+mapLevel);
//        for (int i = 0; i < 2; i++) {
//            addRaider(i, "fly");
//        }
        for (int i = 0; i < 2; i++) {
            addRaider(i, "fly");
        }
        for (int i = 2; i < 4; i++) {
            addRaider(i, "health");
        }
        for (int i = 4; i < 6; i++) {
            addRaider(i, "health");
        }
        for (int i = 6; i < 10; i++) {
            addRaider(i, "speed");
        }
    }
    public void wave1(){
        waveLbl.setText("Wave : 1 / "+mapLevel);
        for (int i = 0; i < 3; i++) {
            addRaider(i, "fly");
        }
        for (int i = 3; i < 6; i++) {
            addRaider(i, "shield");
        }
    }

    public void setImage(String name, boolean reversed, JFXButton button){
        String path = Paths.get("src/main/resources/org/example/game/images/"+name+".png").toAbsolutePath().toString();
        Image image = new Image("file:" + path);
        ImageView imageView = new ImageView(image);
        if(reversed){
            imageView.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        }
        if(name.equals("back")){
            imageView.setFitHeight(60);
            imageView.setFitWidth(60);
        }else {
            imageView.setFitHeight(80);
            imageView.setFitWidth(80);
        }
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }
    public void setData(){
        coins.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getCoin()));
        health.setText(String.valueOf(PlayerTableManager.getUserDatabaseHandler().getHealth()));
    }
    @FXML
    private Label coins;

    @FXML
    private Label health;

    @FXML
    private JFXButton spells;

    @FXML
    private AnchorPane game;

    @FXML
    private ImageView map;
    public ImageView getMap(){
        return map;
    }
    public void setTowers(int map){
        switch (map){
            case 1:
                map1Towers();
                break;
            case 2:
                map2Towers();
                break;
            case 3:
                map3Towers();
                break;
            case 4:
                map4Towers();
                break;
        }
    }
    public Map<JFXButton,String> buttonsType = new HashMap<>();
    public Map<JFXButton,Integer> buttonsLevel = new HashMap<>();
    public Map<JFXButton,Attack> buttonsAttack = new HashMap<>();
    public int currButton=0;
    public Map<JFXButton,Boolean> isEmpty = new HashMap<>();
    @FXML
    private JFXButton backBtn;
    public void buildMap(Map<Double, Double> towerMap ){

        waveLbl.setText("Wave : 0 / "+mapLevel);
        wave=1;
        //debug keyps

        towers = new ArrayList<>();
        game.getChildren().clear();
        game.getChildren().add(runBtn);
        game.getChildren().add(backBtn);
        runBtn.setStyle("-fx-opacity: 1");
        runBtn.setDisable(false);
        backBtn.setStyle("-fx-opacity: 1");
        backBtn.setDisable(false);
        buttonsAttack.clear();
        buttonsType.clear();
        buttonsLevel.clear();
        isEmpty.clear();
//        for(int i=0; i<dotsX.size(); i++){
//            Label label = new Label("1_" + String.valueOf(i));
//            Label label2 = new Label("2_" + String.valueOf(i));
//            label.setTranslateX(dotsX.get(i)+40);
//            label.setTranslateY(dotsY.get(i)+60);
//            label2.setTranslateX(dotsX2.get(i)+40+10);
//            label2.setTranslateY(dotsY2.get(i)+60+10);
//            game.getChildren().add(label);
//            game.getChildren().add(label2);
//        }
        Map.Entry<Double, Double>[] places = towerMap.entrySet().toArray(new Map.Entry[towerMap.size()]);
        for (int i = 0; i < places.length; i++) {

            JFXButton button = new JFXButton();
            button.setLayoutX(places[i].getKey()-30);
            button.setLayoutY(places[i].getValue()-30);
            game.getChildren().add(button);
            setImage("tower",false,button);
            final int a = i;
            buttonsType.put(button,"none");
            isEmpty.put(button,true);
            buttonsLevel.put(button,1);
            buttonsAttack.put(button,new Attack());

            button.setOnAction(e->{
                if(isEmpty.get(button)){
                    isEmpty.put(button,false);
                    current=button;
                    pane = new Pane(AllPanes.getInstance().getTowersPane());
                    pane.setLayoutX(places[a].getKey()-50);
                    pane.setLayoutY(places[a].getValue()-40);
                    game.getChildren().add(pane);
                    ScaleTransition st = new ScaleTransition();
                    st.setNode(pane);
                    st.setFromX(0.1);
                    st.setFromY(0.1);
                    st.setToX(1);
                    st.setToY(1);
                    st.play();
                }
                else{
                    current=button;
                    currButton = a;
//                    deleteTower();
//                    updateTower();
                    pane = new Pane(AllPanes.getInstance().getTowerExtraPane());
                    pane.setLayoutX(current.getLayoutX()-50);
                    pane.setLayoutY(current.getLayoutY()-40);
                    game.getChildren().add(pane);

                }

            });

            towers.add(button);
        }
    }
    public void map1Towers() {
        this.dotsX = HelloApplication.getMap1().getDotsX();
        this.dotsY = HelloApplication.getMap1().getDotsY();
        this.dotsX2 = HelloApplication.getMap1().getDotsX2();
        this.dotsY2 = HelloApplication.getMap1().getDotsY2();
        mapLevel = 1;
        buildMap(HelloApplication.getMap1().getTowers());
        PlayerTableManager.getUserDatabaseHandler().updateCoin(HelloApplication.getMap1().getCoins());
        PlayerTableManager.getUserDatabaseHandler().updateHealth(HelloApplication.getMap1().getHealth());
    }
    public void map3Towers() {
        this.dotsX = HelloApplication.getMap3().getDotsX();
        this.dotsY = HelloApplication.getMap3().getDotsY();
        this.dotsX2 = HelloApplication.getMap3().getDotsX2();
        this.dotsY2 = HelloApplication.getMap3().getDotsY2();
        mapLevel = 3;
        buildMap(HelloApplication.getMap3().getTowers());
        PlayerTableManager.getUserDatabaseHandler().updateCoin(HelloApplication.getMap3().getCoins());
        PlayerTableManager.getUserDatabaseHandler().updateHealth(HelloApplication.getMap3().getHealth());
    }
    public void map4Towers() {
        this.dotsX = HelloApplication.getMap4().getDotsX();
        this.dotsY = HelloApplication.getMap4().getDotsY();
        this.dotsX2 = HelloApplication.getMap4().getDotsX2();
        this.dotsY2 = HelloApplication.getMap4().getDotsY2();
        mapLevel = 4;
        buildMap(HelloApplication.getMap4().getTowers());
        PlayerTableManager.getUserDatabaseHandler().updateCoin(HelloApplication.getMap4().getCoins());
        PlayerTableManager.getUserDatabaseHandler().updateHealth(HelloApplication.getMap4().getHealth());
    }
        public void map2Towers(){
        this.dotsX=HelloApplication.getMap2().getDotsX();
        this.dotsY=HelloApplication.getMap2().getDotsY();
        this.dotsX2=HelloApplication.getMap2().getDotsX2();
        this.dotsY2=HelloApplication.getMap2().getDotsY2();
        mapLevel=2;
        buildMap(HelloApplication.getMap2().getTowers());
            PlayerTableManager.getUserDatabaseHandler().updateCoin(HelloApplication.getMap2().getCoins());
            PlayerTableManager.getUserDatabaseHandler().updateHealth(HelloApplication.getMap2().getHealth());

        /////

//        mapLevel=2;
//        //debug keyps
//
//        towers = new ArrayList<>();
//        game.getChildren().clear();
//        game.getChildren().add(runBtn);
//        for(int i=0; i<dotsX.size(); i++){
//            Label label = new Label("1_" + String.valueOf(i));
//            Label label2 = new Label("2_" + String.valueOf(i));
//            label.setTranslateX(dotsX.get(i)+40);
//            label.setTranslateY(dotsY.get(i)+60);
//            label2.setTranslateX(dotsX2.get(i)+40+10);
//            label2.setTranslateY(dotsY2.get(i)+60+10);
//            game.getChildren().add(label);
//            game.getChildren().add(label2);
//        }
//        Map.Entry<Double, Double>[] places = HelloApplication.getMap1().getTowers().entrySet().toArray(new Map.Entry[HelloApplication.getMap1().getTowers().size()]);
//        for (int i = 0; i < places.length; i++) {
//
//            JFXButton button = new JFXButton();
//            button.setLayoutX(places[i].getKey()-30);
//            button.setLayoutY(places[i].getValue()-30);
//            game.getChildren().add(button);
//            setImage("tower",false,button);
//            final int a = i;
//            buttonsType.put(button,"none");
//            isEmpty.put(button,true);
//            buttonsLevel.put(button,1);
//            buttonsAttack.put(button,new Attack());
//
//            button.setOnAction(e->{
//                if(isEmpty.get(button)){
//                    isEmpty.put(button,false);
//                    current=button;
//                    pane = new Pane(AllPanes.getInstance().getTowersPane());
//                    pane.setLayoutX(places[a].getKey()-50);
//                    pane.setLayoutY(places[a].getValue()-40);
//                    game.getChildren().add(pane);
//                    ScaleTransition st = new ScaleTransition();
//                    st.setNode(pane);
//                    st.setFromX(0.1);
//                    st.setFromY(0.1);
//                    st.setToX(1);
//                    st.setToY(1);
//                    st.play();
//                }
//                else{
//                    current=button;
//                    currButton = a;
////                    deleteTower();
////                    updateTower();
//                    pane = new Pane(AllPanes.getInstance().getTowerExtraPane());
//                    pane.setLayoutX(current.getLayoutX()-50);
//                    pane.setLayoutY(current.getLayoutY()-40);
//                    game.getChildren().add(pane);
//
//                }
//
//            });
//
//            towers.add(button);
//        }
    }
    public void updateTower(){
        pane = new Pane(AllPanes.getInstance().getTowerUpdatePane());
        pane.setLayoutX(current.getLayoutX()-50);
        pane.setLayoutY(current.getLayoutY()-40);
        game.getChildren().add(pane);
        AllPanes.getInstance().getTowerUpdateC().setData(buttonsLevel.get(current));
    }
    public double towerRange(JFXButton b){
        if(b==null){
            b=current;
        }
        double range=0 ;
        switch (buttonsType.get(b)){
            case "none":
                break;
            case "archer":
                range = HelloApplication.getArcherTower().getRange();
                break;
            case "mages":
                range = HelloApplication.getMagesTower().getRange();
                break;
            case "wizard":
                range = HelloApplication.getWizardTower().getRange();
                break;
            case "artillery":
                range = HelloApplication.getArtilleryTower().getRange();
                break;
        }

        return range;
    }

    public void checkRange(Raider r,double x, double y){
        Map.Entry<JFXButton, String>[] AllTowers = buttonsType.entrySet().toArray(new Map.Entry[buttonsType.size()]);
        for (int i = 0; i < AllTowers.length; i++) {
            if(!isEmpty.get(AllTowers[i].getKey())){
//                System.out.println("is not empty");
                double X = AllTowers[i].getKey().getLayoutX()+40;
                double Y = AllTowers[i].getKey().getLayoutY()+40;
                double range = towerRange(AllTowers[i].getKey());
                double distance = ((X-x)*(X-x))+((Y-y)*(Y-y));
//                System.out.println("distance: "+distance+" range: "+range);
                if(!(buttonsType.get(AllTowers[i].getKey()).equals("artillery") && r.isHasFlight())) {

                    if (distance < (range * range)) {
//
                        if(buttonsAttack.get(AllTowers[i].getKey()).towerAttack(AllTowers[i].getKey(), x, y) ){
                            int damage = (int) towerDamge(AllTowers[i].getKey(), r);
                            r.setHealth(r.getHealth() - damage);
                            if (r.getHealth() <= 0) {
                                PlayerTableManager.getUserDatabaseHandler().updateCoin(r.getLoot());
                                setData();
                                game.getChildren().remove(r.getImageView());
                                r.getSequentialTransition().pause();
                                r.setDead(true);
                                raiders.remove(r);
                                if (raiders.isEmpty()) {
                                    wave++;
                                    if (wave == 2 && mapLevel >= wave) {
                                        wave2();
                                    } else if (wave == 3 && mapLevel >= wave) {
                                        wave3();
                                    } else if (wave == 4 && mapLevel >= wave) {
                                        wave4();
                                    } else {
                                        endLevel();
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
    public void freeze(){
        for(Raider r:raiders){
            r.getSequentialTransition().pause();
            SequentialTransition seqTransition = new SequentialTransition (
                    new PauseTransition(Duration.millis(2000))
            );
            seqTransition.play();
            seqTransition.setOnFinished(e->{
                r.getSequentialTransition().play();
            });
        }
    }
    public void littleBoyAttack(){
        for(Raider r:raiders){
            PlayerTableManager.getUserDatabaseHandler().updateCoin(r.getLoot());
            game.getChildren().remove(r.getImageView());
            r.getSequentialTransition().stop();
//            r.getTimeline().stop();
            r.setDead(true);
        }
        raiders.clear();
            wave++;
            if(wave==2) {
                wave2();
            }
            if(wave==3) {
                wave3();
            }
            if(wave==4) {
                wave4();
            }
    }
    public double towerDamge(JFXButton button, Raider r){
        double damage=0;
        switch (buttonsType.get(button)){
            case "none":
                break;
            case "archer":
                damage = HelloApplication.getArcherTower().getDamage();
                if(r instanceof ShieldRaider){
                    damage/=2;
                }
                if(r instanceof DoubledHealthRaider){
                    damage/=2;
                }
                break;
            case "mages":
                damage = HelloApplication.getMagesTower().getDamage();
                if(r instanceof ShieldRaider && r.isHasShield()){
                    r.setHasShield(false);
                    damage =0;
                }
                if(r instanceof DoubledHealthRaider){
                    damage/=2;
                }

                break;
            case "wizard":
                damage = r.getHealth()/2;
                if(r instanceof DoubledHealthRaider){
                    damage/=2;
                }
                break;
            case "artillery":
                damage = HelloApplication.getArtilleryTower().getDamage();
                if(r instanceof DoubledHealthRaider){
                    damage/=2;
                }
                break;
        }
        System.out.println("damage to r:"+r.getId()+" == "+damage);
        return damage;
    }
    public void towerAttack(JFXButton button, double x, double y){
        double X = button.getLayoutX()+40;
        double Y = button.getLayoutY()+40;
        String path="";
        ImageView imageView = new ImageView();
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        switch (buttonsType.get(button)){
            case "none":
                break;
            case "archer":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getArcherTower().getAttackImg()+".png").toAbsolutePath().toString();
                break;
            case "mages":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getMagesTower().getAttackImg()+".png").toAbsolutePath().toString();

                break;
            case "wizard":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getWizardTower().getAttackImg()+".png").toAbsolutePath().toString();

                break;
            case "artillery":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getArtilleryTower().getAttackImg()+".png").toAbsolutePath().toString();

                break;
        }
        Image image = new Image("file:" + path);
        imageView.setImage(image);
        game.getChildren().add(imageView);
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(200));
        tt.setNode(imageView);
        tt.setFromX(X);
        tt.setFromY(Y);
        tt.setToX(x);
        tt.setToY(y);
        tt.play();
        tt.setOnFinished(e->{
            game.getChildren().remove(imageView);
        });

    }
    public void deleteTower(){
        setImage("tower",false,current);
        switch (buttonsType.get(current)){
            case "none":
                System.out.println("0");
                break;
            case "archer":
                System.out.println("1");
                PlayerTableManager.getUserDatabaseHandler().updateCoin((HelloApplication.getArcherTower().getPrice()+(HelloApplication.getArcherTower().getPrice()/2)*HelloApplication.getArcherTower().getLevel())/2);
                break;
            case "mages":
                System.out.println("2");
                PlayerTableManager.getUserDatabaseHandler().updateCoin((HelloApplication.getMagesTower().getPrice()+(HelloApplication.getMagesTower().getPrice()/2)*HelloApplication.getMagesTower().getLevel())/2);
                break;
            case "wizard":
                System.out.println("3");
                PlayerTableManager.getUserDatabaseHandler().updateCoin((HelloApplication.getWizardTower().getPrice()+(HelloApplication.getWizardTower().getPrice()/2)*HelloApplication.getWizardTower().getLevel())/2);
                break;
            case "artillery":
                System.out.println("4");
                PlayerTableManager.getUserDatabaseHandler().updateCoin((HelloApplication.getArtilleryTower().getPrice()+(HelloApplication.getArtilleryTower().getPrice()/2)*HelloApplication.getArtilleryTower().getLevel())/2);
                break;
        }
        buttonsType.put(current,"none");
        setData();
    }
    private Pane pane;
    public Pane getPane(){
        return pane;
    }
    public AnchorPane getGame(){
        return game;
    }
    private static JFXButton current = new JFXButton();
    public static JFXButton getCurrent(){
        return current;
    }
    private boolean spellClicked = false;
    public boolean isSpellClicked(){
        return spellClicked;
    }
    public void setSpellClicked(boolean spellClicked){
        this.spellClicked = spellClicked;
    }

    public JFXButton getSpells(){
        return spells;
    }

    @FXML
    void spellsClick(ActionEvent event) {
        if(!spellClicked) {
            spellClicked = true;
            System.out.println("spell");
            pane = new Pane();
            pane.getChildren().addAll(AllPanes.getInstance().getSpellChoosePane());
            pane.setLayoutX(spells.getLayoutX() - 150);
            pane.setLayoutY(spells.getLayoutY());
            game.getChildren().add(pane);
            AllPanes.getInstance().getSpellChooseC().setData();

            ScaleTransition st = new ScaleTransition();
            st.setNode(pane);
            st.setFromX(0.1);
            st.setFromY(0.1);
            st.setToX(0.6);
            st.setToY(0.6);
            st.play();
            TranslateTransition tt = new TranslateTransition();
            tt.setNode(pane);
            tt.setFromY(0);
            tt.setFromY(-250);
            tt.play();
        }
        else{
            spellClicked = false;
            game.getChildren().remove(pane);
        }
    }

}
