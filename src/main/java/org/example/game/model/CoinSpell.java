package org.example.game.model;


public class CoinSpell implements spell {
    private static int price = 10;
    public static int getP(){
        return price;
    }


    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop() {

    }
}
