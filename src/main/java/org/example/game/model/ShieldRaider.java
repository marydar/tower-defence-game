package org.example.game.model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ShieldRaider extends Raider {
    public ShieldRaider(double speed, double loot, int health, ArrayList<String> imgs, ImageView imageView) {
        super(speed,loot,health,false,true,false,false, imgs, imageView);
    }
}
