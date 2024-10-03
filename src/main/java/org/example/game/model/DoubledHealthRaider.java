package org.example.game.model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class DoubledHealthRaider extends Raider{
    public DoubledHealthRaider(double speed, double loot, int health, ArrayList<String> imgs, ImageView imageView) {
        super(speed,loot,health,false,false,true,false, imgs, imageView);
    }
}
