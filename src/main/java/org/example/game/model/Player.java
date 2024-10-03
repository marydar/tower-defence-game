package org.example.game.model;

import java.util.ArrayList;

public class Player {
    private String username;
    private String password;
    private int level;
    private long gem;
    private long health;
    private long coin;
    private ArrayList backPack;
    public Player(String username, String password, int level, long gem, long health,long coin, ArrayList backPack) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.gem = gem;
        this.health = health;
        this.coin = coin;
        this.backPack = backPack;
    }
}
