package org.example.game.model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class FlyingRaider extends Raider {
    public FlyingRaider(double speed, double loot, int health, ArrayList<String> imgs, ImageView imageView) {
        super(speed,loot,health,true,false,false,false, imgs, imageView);
    }
}
