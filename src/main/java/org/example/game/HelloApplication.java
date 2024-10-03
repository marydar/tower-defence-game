package org.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.game.controller.PlayerTableManager;
import org.example.game.model.*;
import org.example.game.view.AllPanes;
import org.example.game.view.PaneCollector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import  javafx.scene.media.Media;
import  javafx.scene.media.MediaPlayer;

public class HelloApplication extends Application {
    private static Media media;
    private static MediaPlayer mediaPlayer;
    public static MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }


    private static Scene scene;
    public static void setScene(Parent p){
        scene.setRoot(p);
    }
    private static GameMaps map4;
    public static GameMaps getMap4() {
        Map<Double,Double> towers = new HashMap<>();
        towers.put(360.0,95.0);
        towers.put(481.0,65.0);
        towers.put(473.0,214.0);
        towers.put(598.0,195.0);
        towers.put(723.0,195.0);
        towers.put(675.0,344.0);
        towers.put(525.0,485.0);
        towers.put(404.0,421.0);
        towers.put(285.0,379.0);
        towers.put(184.0,535.0);
        towers.put(375.0,598.0);
        towers.put(796.0,573.0);

        ArrayList<Integer> dotsX=new ArrayList<>();
        ArrayList<Integer> dotsY=new ArrayList<>();
        ArrayList<Integer> dotsX2=new ArrayList<>();
        ArrayList<Integer> dotsY2=new ArrayList<>();
        dotsX.add(880);
        dotsX.add(400);
        dotsX.add(300);
        dotsX.add(650);
        dotsX.add(550);
        dotsX.add(200);
        dotsX.add(20);
        ///////
        dotsY.add(130-35-15);
        dotsY.add(40+35);
        dotsY.add(200);
        dotsY.add(430-20);
        dotsY.add(500);
        dotsY.add(400-35);
        dotsY.add(400-35);

        /////

        dotsX2.add(885);
        dotsX2.add(450);
        dotsX2.add(300);
        dotsX2.add(650);
        dotsX2.add(550);
        dotsX2.add(200);
        dotsX2.add(20);
        ///////
        dotsY2.add(200+35);
        dotsY2.add(200);
        dotsY2.add(200);
        dotsY2.add(430-20);
        dotsY2.add(500);
        dotsY2.add(400-35);
        dotsY2.add(400-35);
        map4 = new GameMaps(900,50,1500,towers,dotsX,dotsY,dotsX2,dotsY2);
        return map4;
    }
    private static GameMaps map1;
    public static GameMaps getMap1() {
        Map<Double,Double> towers = new HashMap<>();
        towers.put(537.0,45.0);
        towers.put(300.0 ,181.0);
        towers.put(316.0 ,421.0);
        towers.put(135.0,473.0);
        towers.put(203.0 , 575.0);
        towers.put(781.0,556.0);
        towers.put(564.0,443.0);
//        towers.put(404.0,421.0);
//        towers.put(285.0,379.0);
//        towers.put(184.0,535.0);
//        towers.put(375.0,598.0);
//        towers.put(796.0,573.0);

        ArrayList<Integer> dotsX=new ArrayList<>();
        ArrayList<Integer> dotsY=new ArrayList<>();
        ArrayList<Integer> dotsX2=new ArrayList<>();
        ArrayList<Integer> dotsY2=new ArrayList<>();
        dotsX.add(400);
        dotsX.add(350);
        dotsX.add(190);
        dotsX.add(200);
        dotsX.add(460);
        dotsX.add(610);
        dotsX.add(750);
        ///////
        dotsY.add(1);
        dotsY.add(160);
        dotsY.add(270);
        dotsY.add(440);
        dotsY.add(440);
        dotsY.add(480);
        dotsY.add(370);

        /////
        dotsX2.add(400);
        dotsX2.add(390);
        dotsX2.add(190);
        dotsX2.add(200);
        dotsX2.add(460);
        dotsX2.add(610);
        dotsX2.add(750);
        ///////
        dotsY2.add(1);
        dotsY2.add(160);
        dotsY2.add(270);
        dotsY2.add(440);
        dotsY2.add(440);
        dotsY2.add(480);
        dotsY2.add(370);


        map1 = new GameMaps(900,50,1500,towers,dotsX,dotsY,dotsX2,dotsY2);
        return map1;
    }
    private static GameMaps map3;
    public static GameMaps getMap3() {
        Map<Double,Double> towers = new HashMap<>();
        towers.put(376.0 ,611.0);
        towers.put(238.0 ,406.0);
        towers.put(447.0 , 455.0);
        towers.put(348.0, 269.0);
        towers.put(501.0 , 233.0);
        towers.put(116.0,199.0);
        towers.put(295.0,105.0);
        towers.put( 520.0,64.0);
        towers.put(728.0 ,227.0);
        towers.put(646.0,416.0);
        towers.put(838.0,484.0);

        ArrayList<Integer> dotsX=new ArrayList<>();
        ArrayList<Integer> dotsY=new ArrayList<>();
        ArrayList<Integer> dotsX2=new ArrayList<>();
        ArrayList<Integer> dotsY2=new ArrayList<>();
        dotsX.add(470);
        dotsX.add(450);
        dotsX.add(270);
        dotsX.add(116);
        dotsX.add(110);
        dotsX.add(270);
        dotsX.add(550);
        dotsX.add(620);
        ///////
        dotsY.add(620);
        dotsY.add(520);
        dotsY.add(440);
        dotsY.add(400);
        dotsY.add(250);
        dotsY.add(100);
        dotsY.add(90);
        dotsY.add(1);

        /////
        dotsX2.add(860);
        dotsX2.add(710);
        dotsX2.add(715);
        dotsX2.add(530);
        dotsX2.add(625);
        ///////
        dotsY2.add(530);
        dotsY2.add(500);
        dotsY2.add(320);
        dotsY2.add(110);
        dotsY2.add(1);


        map3 = new GameMaps(900,50,1500,towers,dotsX,dotsY,dotsX2,dotsY2);
        return map3;
    }
    private static GameMaps map2;
    public static GameMaps getMap2() {
        Map<Double,Double> towers = new HashMap<>();
        towers.put(584.0  ,157.0);
        towers.put(387.0  ,140.0);
        towers.put(326.0  , 305.0);
        towers.put(119.0 , 272.0);
        towers.put(238.0  , 453.0);
        towers.put(487.0 ,449.0);
        towers.put(508.0 ,619.0);
        towers.put( 684.0 ,482.0);


        ArrayList<Integer> dotsX=new ArrayList<>();
        ArrayList<Integer> dotsY=new ArrayList<>();
        ArrayList<Integer> dotsX2=new ArrayList<>();
        ArrayList<Integer> dotsY2=new ArrayList<>();
        dotsX.add(908-50);
        dotsX.add(696-50);
        dotsX.add(660-50);
        dotsX.add(513-50);
        dotsX.add(483-50);
        dotsX.add(227-50);
        dotsX.add(250-50);
        dotsX.add(563-50);
        dotsX.add(606-50);
        dotsX.add(406-50);
        dotsX.add(405-50);
        ///////
        dotsY.add(222-65);
        dotsY.add(218-65);
        dotsY.add(58-65);
        dotsY.add(53-65);
        dotsY.add(215-65);
        dotsY.add(245-65);
        dotsY.add(395-65);
        dotsY.add(361-65);
        dotsY.add(494-65);
        dotsY.add(550-65);
        dotsY.add(674-65);
        /////
        dotsX2.add(908-50);
        dotsX2.add(696-50);
        dotsX2.add(660-50);
        dotsX2.add(513-50);
        dotsX2.add(483-50);
        dotsX2.add(227-50);
        dotsX2.add(250-50);
        dotsX2.add(563-50);
        dotsX2.add(606-50);
        dotsX2.add(406-50);
        dotsX2.add(405-50);
        ///////
        dotsY2.add(222-65);
        dotsY2.add(218-65);
        dotsY2.add(58-65);
        dotsY2.add(53-65);
        dotsY2.add(215-65);
        dotsY2.add(245-65);
        dotsY2.add(395-65);
        dotsY2.add(361-65);
        dotsY2.add(494-65);
        dotsY2.add(550-65);
        dotsY2.add(674-65);


        map2 = new GameMaps(900,10,1500,towers,dotsX,dotsY,dotsX2,dotsY2);
        return map2;
    }
    private  static ArcherTower archerTower;
    public static ArcherTower getArcherTower() {
        archerTower = new ArcherTower(100,2,100,"archer","arrow");
        return archerTower;
    }
    private  static ArtilleryTower artilleryTower;
    public static ArtilleryTower getArtilleryTower() {
        artilleryTower = new ArtilleryTower(500,2,100,"dwarvan","bomb");
        return artilleryTower;
    }
    private  static MagesTower magesTower;
    public static MagesTower getMagesTower() {
        magesTower = new MagesTower(100,2,100,"mages","fire");
        return magesTower;
    }
    private  static WizardTower wizardTower;
    public static WizardTower getWizardTower() {
        wizardTower = new WizardTower(100,2,100,"arcane","fire");
        return wizardTower;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxmls/start.fxml"));
        PaneCollector.getInstance().collect();
        scene = new Scene(AllPanes.getInstance().getStartPane());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    private static ArrayList<Image> flyImages = new ArrayList<>();
    public static ArrayList<Image> getflyImages() {
        if(flyImages.size()==0){
            for (String s :flyRaiderImages){
                flyImages.add(new Image("file:" + s));
            }
        }

        return flyImages;
    }
    private static ArrayList<Image> sheildImgs = new ArrayList<>();
    public static ArrayList<Image> getSheildImgs() {
        if(sheildImgs.size()==0){
            for (String s :sheildRaiderImages){
                sheildImgs.add(new Image("file:" + s));
            }
        }

        return sheildImgs;
    }
    private static ArrayList<Image> speedImages = new ArrayList<>();
    public static ArrayList<Image> getSpeedImages() {
        if(speedImages.size()==0){
            for (String s :speedRaiderImages){
                speedImages.add(new Image("file:" + s));
            }
        }

        return speedImages;
    }
    private static ArrayList<Image> healthImages = new ArrayList<>();
    public static ArrayList<Image> getHealthImages() {
        if(healthImages.size()==0){
            for (String s :doubleRaiderImages){
                healthImages.add(new Image("file:" + s));
            }
        }

        return healthImages;
    }
    private static ArrayList<String> flyRaiderImages = new ArrayList<>();
    public static ArrayList<String> getFlyRaiderImages() {
        String path1 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000.png").toAbsolutePath().toString();
        String path2 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_001.png").toAbsolutePath().toString();
        String path3 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_002.png").toAbsolutePath().toString();
        String path4 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_003.png").toAbsolutePath().toString();
        String path5 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_004.png").toAbsolutePath().toString();
        String path6 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_005.png").toAbsolutePath().toString();
        String path7 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_006.png").toAbsolutePath().toString();
        String path8 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_007.png").toAbsolutePath().toString();
        String path9 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_008.png").toAbsolutePath().toString();
        String path10 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_009.png").toAbsolutePath().toString();
        String path11 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_010.png").toAbsolutePath().toString();
        String path12= Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_011.png").toAbsolutePath().toString();
        flyRaiderImages = new ArrayList<>();
        flyRaiderImages.add(path1);
        flyRaiderImages.add(path2);
        flyRaiderImages.add(path3);
        flyRaiderImages.add(path4);
        flyRaiderImages.add(path5);
        flyRaiderImages.add(path6);
        flyRaiderImages.add(path7);
        flyRaiderImages.add(path8);
        flyRaiderImages.add(path9);
        flyRaiderImages.add(path10);
        flyRaiderImages.add(path11);
        flyRaiderImages.add(path12);
        return flyRaiderImages;
    }
    private static ArrayList<String> sheildRaiderImages = new ArrayList<>();
    public static ArrayList<String> getSheildRaiderImages() {

        String path1 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (1).png").toAbsolutePath().toString();
        String path2 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (3).png").toAbsolutePath().toString();
        String path3 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (4).png").toAbsolutePath().toString();
        String path4 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (5).png").toAbsolutePath().toString();
        String path5 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (6).png").toAbsolutePath().toString();
        String path6 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (7).png").toAbsolutePath().toString();
        String path7 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (8).png").toAbsolutePath().toString();
        String path8 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (9).png").toAbsolutePath().toString();
        String path9 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (10).png").toAbsolutePath().toString();
        String path10 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (11).png").toAbsolutePath().toString();
        String path11 = Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (12).png").toAbsolutePath().toString();
        String path12= Paths.get("src/main/resources/org/example/game/images/0_Golem_Running_000 (13).png").toAbsolutePath().toString();
        sheildRaiderImages = new ArrayList<>();
        sheildRaiderImages.add(path1);
        sheildRaiderImages.add(path2);
        sheildRaiderImages.add(path3);
        sheildRaiderImages.add(path4);
        sheildRaiderImages.add(path5);
        sheildRaiderImages.add(path6);
        sheildRaiderImages.add(path7);
        sheildRaiderImages.add(path8);
        sheildRaiderImages.add(path9);
        sheildRaiderImages.add(path10);
        sheildRaiderImages.add(path11);
        sheildRaiderImages.add(path12);
        return sheildRaiderImages;
    }
    private static ArrayList<String> speedRaiderImages = new ArrayList<>();
    public static ArrayList<String> getSpeedRaiderImages() {
        String path1 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (1).png").toAbsolutePath().toString();
        String path2 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (2).png").toAbsolutePath().toString();
        String path3 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (3).png").toAbsolutePath().toString();
        String path4 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (4).png").toAbsolutePath().toString();
        String path5 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (5).png").toAbsolutePath().toString();
        String path6 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (6).png").toAbsolutePath().toString();
        String path7 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (7).png").toAbsolutePath().toString();
        String path8 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (8).png").toAbsolutePath().toString();
        String path9 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (9).png").toAbsolutePath().toString();
        String path10 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (10).png").toAbsolutePath().toString();
        String path11 = Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (11).png").toAbsolutePath().toString();
        String path12= Paths.get("src/main/resources/org/example/game/images/1_Golem_Running_000 (12).png").toAbsolutePath().toString();
        speedRaiderImages = new ArrayList<>();
        speedRaiderImages.add(path1);
        speedRaiderImages.add(path2);
        speedRaiderImages.add(path3);
        speedRaiderImages.add(path4);
        speedRaiderImages.add(path5);
        speedRaiderImages.add(path6);
        speedRaiderImages.add(path7);
        speedRaiderImages.add(path8);
        speedRaiderImages.add(path9);
        speedRaiderImages.add(path10);
        speedRaiderImages.add(path11);
        speedRaiderImages.add(path12);
        return speedRaiderImages;
    }
    private static ArrayList<String> doubleRaiderImages = new ArrayList<>();
    public static ArrayList<String> getDoubleRaiderImages() {
        String path1 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (1).png").toAbsolutePath().toString();
        String path2 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (2).png").toAbsolutePath().toString();
        String path3 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (3).png").toAbsolutePath().toString();
        String path4 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (4).png").toAbsolutePath().toString();
        String path5 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (5).png").toAbsolutePath().toString();
        String path6 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (6).png").toAbsolutePath().toString();
        String path7 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (7).png").toAbsolutePath().toString();
        String path8 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (8).png").toAbsolutePath().toString();
        String path9 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (9).png").toAbsolutePath().toString();
        String path10 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (10).png").toAbsolutePath().toString();
        String path11 = Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (11).png").toAbsolutePath().toString();
        String path12= Paths.get("src/main/resources/org/example/game/images/2_Golem_Running_000 (12).png").toAbsolutePath().toString();
        doubleRaiderImages = new ArrayList<>();
        doubleRaiderImages.add(path1);
        doubleRaiderImages.add(path2);
        doubleRaiderImages.add(path3);
        doubleRaiderImages.add(path4);
        doubleRaiderImages.add(path5);
        doubleRaiderImages.add(path6);
        doubleRaiderImages.add(path7);
        doubleRaiderImages.add(path8);
        doubleRaiderImages.add(path9);
        doubleRaiderImages.add(path10);
        doubleRaiderImages.add(path11);
        doubleRaiderImages.add(path12);
        return doubleRaiderImages;
    }

    public static void main(String[] args) {
        File file = new File("E:\\Programming\\finalproject-game-marydar\\game\\src\\main\\resources\\org\\example\\game\\images\\01. Main Theme.mp3");
                media = new Media(file.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
                mediaPlayer.play();
            }
        });

        launch();

    }
}