package org.example.game.model;

public abstract class Tower {
    private double range;
    private double price;
    private int level;
    private double damage;

    public void setAttackImg(String attackImg) {
        this.attackImg = attackImg;
    }

    public String getAttackImg() {
        return attackImg;
    }

    private String attackImg;

    public void setImageAddress(String imageAddress) {
        ImageAddress = imageAddress;
    }

    public String getImageAddress() {
        return ImageAddress;
    }

    private String ImageAddress;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getLevel() {
        return level;
    }

    public double getRange() {
        return range;
    }

    public double getPrice() {
        return price;
    }

    public double getDamage() {
        return damage;
    }

    public Tower(double range, double price, double damage, String imgAddress, String attackImg) {
        this.range = range;
        this.price = price;
        this.damage = damage;
        this.level = 1;
        this.ImageAddress = imgAddress;
        this.attackImg = attackImg;
    }
}
