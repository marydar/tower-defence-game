package org.example.game.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMaps {
    private  int coins ;
    private  int health;
    private  int gems;
    private  Map<Double,Double> towers = new HashMap<>();

    public int getCoins() {
        return coins;
    }

    public int getHealth() {
        return health;
    }

    public int getGems() {
        return gems;
    }

    public Map<Double, Double> getTowers() {
        return towers;
    }
    private ArrayList<Integer> dotsX=new ArrayList<>();
    private ArrayList<Integer> dotsY=new ArrayList<>();
    private ArrayList<Integer> dotsX2=new ArrayList<>();

    public ArrayList<Integer> getDotsX() {
        return dotsX;
    }

    public ArrayList<Integer> getDotsY() {
        return dotsY;
    }

    public ArrayList<Integer> getDotsX2() {
        return dotsX2;
    }

    public ArrayList<Integer> getDotsY2() {
        return dotsY2;
    }

    private ArrayList<Integer> dotsY2=new ArrayList<>();

    public GameMaps(int coins, int health, int gems, Map<Double, Double> towers, ArrayList<Integer> dotsX, ArrayList<Integer> dotsY, ArrayList<Integer> dotsX2, ArrayList<Integer> dotsY2) {
        this.coins = coins;
        this.health = health;
        this.gems = gems;
        this.towers = towers;
        this.dotsX = dotsX;
        this.dotsY = dotsY;
        this.dotsX2 = dotsX2;
        this.dotsY2 = dotsY2;
    }


}
