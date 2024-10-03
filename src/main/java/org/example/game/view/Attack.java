package org.example.game.view;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.example.game.HelloApplication;

import java.nio.file.Paths;

public class Attack {
    private boolean isShooting;

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public Attack(){

    }
    public boolean towerAttack(JFXButton button, double x, double y){
        double X = button.getLayoutX()+40;
        double Y = button.getLayoutY()+40;
        String path="";
        ImageView imageView = new ImageView();
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);
        switch (AllPanes.getInstance().getMapC().buttonsType.get(button)){
            case "none":
                break;
            case "archer":
                if(!isShooting){
                    path = Paths.get("src/main/resources/org/example/game/images/"+ HelloApplication.getArcherTower().getAttackImg()+".png").toAbsolutePath().toString();
                }
                break;
            case "mages":
                if(!isShooting){
                    path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getMagesTower().getAttackImg()+".png").toAbsolutePath().toString();
                }

                break;
            case "wizard":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getWizardTower().getAttackImg()+".png").toAbsolutePath().toString();

                break;
            case "artillery":
                path = Paths.get("src/main/resources/org/example/game/images/"+HelloApplication.getArtilleryTower().getAttackImg()+".png").toAbsolutePath().toString();

                break;
        }
        if(!isShooting){
            isShooting=true;
            Image image = new Image("file:" + path);
            imageView.setImage(image);
            AllPanes.getInstance().getMapC().getGame().getChildren().add(imageView);
            TranslateTransition tt = new TranslateTransition();
            tt.setDuration(Duration.millis(200));
            tt.setNode(imageView);
            tt.setFromX(X);
            tt.setFromY(Y);
            tt.setToX(x);
            tt.setToY(y);
            tt.play();
            tt.setOnFinished(e->{
                AllPanes.getInstance().getMapC().getGame().getChildren().remove(imageView);
            });
            return true;
        }
        isShooting=false;
        return false;

    }
}
