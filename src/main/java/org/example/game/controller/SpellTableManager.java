package org.example.game.controller;

import java.sql.*;

public class SpellTableManager {
    private final String Url;
    private final String userId;
    private final String password;

    private SpellTableManager() {
        Url = "jdbc:mysql://localhost/gameD";
        userId = "root";
        password = "maryamSql#!";
    }

    private static SpellTableManager spellTableManager;

    public static SpellTableManager getSpellTableManager() {
        if (spellTableManager == null) {
            spellTableManager = new SpellTableManager();
        }
        return spellTableManager;
    }

    public void addBackPack(String username){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("INSERT INTO `spells`(`playerUsername`) VALUES ('%s')", username);
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCoinSpell(int update){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `spells` SET `coinSpell`= coinSpell+"+update+" WHERE `playerUsername`='"+PlayerTableManager.loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateFreezeSpell(int update){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `spells` SET `freezeSpell`= freezeSpell+"+update+" WHERE `playerUsername`='"+PlayerTableManager.loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateLittleBoySpell(int update){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `spells` SET `littleBoySpell`= littleBoySpell+"+update+" WHERE `playerUsername`='"+PlayerTableManager.loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateHealthSpell(int update){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `spells` SET `healthSpell`= healthSpell+"+update+" WHERE `playerUsername`='"+PlayerTableManager.loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getCoinSpell(){
        int coins=876;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `coinSpell` FROM `spells` WHERE `playerUsername`= '%s'", PlayerTableManager.loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                coins = rs.getInt("coinSpell");
            }
            return coins;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getFreezeSpell(){
        int coins=876;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `freezeSpell` FROM `spells` WHERE `playerUsername`= '%s'", PlayerTableManager.loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                coins = rs.getInt("freezeSpell");
            }
            return coins;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getLittleBoySpell(){
        int coins=876;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `littleBoySpell` FROM `spells` WHERE `playerUsername`= '%s'", PlayerTableManager.loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                coins = rs.getInt("littleBoySpell");
            }
            return coins;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getHealthSpell(){
        int coins=876;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `healthSpell` FROM `spells` WHERE `playerUsername`= '%s'", PlayerTableManager.loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                coins = rs.getInt("healthSpell");
            }
            return coins;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
