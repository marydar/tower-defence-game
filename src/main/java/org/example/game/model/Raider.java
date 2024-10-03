package org.example.game.model;

import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Raider {
    private static int counter = 0;
    private int id;
    private double speed;
    private double loot;
    private int health;
    private boolean hasFlight;
    private boolean hasShield;
    private boolean hasDoubleHealth;

    public void setCurrenImg(int currenImg) {
        this.currenImg = currenImg;
    }

    public int getCurrenImg() {
        return currenImg;
    }

    private int currenImg;

    public double getSpeed() {
        return speed;
    }

    public double getLoot() {
        return loot;
    }

    public int getHealth() {
        return health;
    }

    public boolean isHasFlight() {
        return hasFlight;
    }

    public boolean isHasShield() {
        return hasShield;
    }

    public boolean isHasDoubleHealth() {
        return hasDoubleHealth;
    }

    public boolean isHasUltraSpeed() {
        return hasUltraSpeed;
    }

    public ArrayList<String> getImgs() {
        return imgs;
    }

    public ImageView getImageView() {
        return imageView;
    }

    private boolean hasUltraSpeed;
    private ArrayList<String> imgs;
    private ImageView imageView;
    private TranslateTransition tt;

    public TranslateTransition getTt() {
        return tt;
    }
    private Timeline timeline;

    public Timeline getTimeline() {
        return timeline;
    }

    public void setCurrentPlace(int currentPlace) {
        this.currentPlace = currentPlace;
    }

    public int getCurrentPlace() {
        return currentPlace;
    }

    private int currentPlace;
    private SequentialTransition sequentialTransition;

    public void setSequentialTransition(SequentialTransition sequentialTransition) {
        this.sequentialTransition = sequentialTransition;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public void setTt(TranslateTransition tt) {
        this.tt = tt;
    }

    public void setImgs(ArrayList<String> imgs) {
        this.imgs = imgs;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setHasUltraSpeed(boolean hasUltraSpeed) {
        this.hasUltraSpeed = hasUltraSpeed;
    }

    public void setHasDoubleHealth(boolean hasDoubleHealth) {
        this.hasDoubleHealth = hasDoubleHealth;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    public void setHasFlight(boolean hasFlight) {
        this.hasFlight = hasFlight;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLoot(double loot) {
        this.loot = loot;
    }

    public SequentialTransition getSequentialTransition() {
        return sequentialTransition;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    private boolean isDead;

    public int getId() {
        return id;
    }

    public Raider(double speed, double loot, int health, boolean hasFlight, boolean hasShield, boolean hasDoubleHealth, boolean hasUltraSpeed, ArrayList<String> imgs, ImageView imageView) {
        this.speed = speed;
        counter++;
        this.id = counter;
        this.loot = loot;
        this.health = health;
        this.hasFlight = hasFlight;
        this.hasShield = hasShield;
        this.hasDoubleHealth = hasDoubleHealth;
        this.hasUltraSpeed = hasUltraSpeed;
        this.imgs = imgs;
        this.imageView = imageView;
        currenImg=0;
        currentPlace=0;
        tt = new TranslateTransition();
        tt.setInterpolator(Interpolator.LINEAR);
        tt.setNode(imageView);
//        timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
        isDead =false;
    }

}
