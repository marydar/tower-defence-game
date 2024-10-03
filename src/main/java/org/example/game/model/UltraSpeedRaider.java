package org.example.game.model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class UltraSpeedRaider extends Raider{
    public static  void setCoefficient(int coefficient) {
        Coefficient = coefficient;
    }

    private  static  int Coefficient=3;

    public static  int getCoefficient() {
        return Coefficient;
    }

    public UltraSpeedRaider(double speed, double loot, int health, ArrayList<String> imgs, ImageView imageView) {
        super(speed,loot,health,false,false,false,true, imgs, imageView);
    }
}
