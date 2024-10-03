package org.example.game.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.example.game.HelloApplication;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerTableManager {
    private final String Url;
    private final String userId;
    private final String password;
    public static String loginPlayer;

    private PlayerTableManager() {
        Url = "jdbc:mysql://localhost/gameD";
        userId = "root";
        password = "maryamSql#!";
    }

    private static PlayerTableManager playerTableManager;

    public static PlayerTableManager getUserDatabaseHandler() {
        if (playerTableManager == null) {
            playerTableManager = new PlayerTableManager();
        }
        return playerTableManager;
    }
    public boolean checkUsername(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("SELECT `username` FROM `player`");
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return true;
                }

            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
     public boolean checkPassword(String password)  {
        String regex = "(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])[A-Za-z0-9]{5,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean signup(String username, String password) {
        if (!checkPassword(password)) {
            throw new RuntimeException("password is invalid!");
        }
        if (checkUsername(username)) {
            throw new RuntimeException("username  already exist!");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("INSERT INTO `player`(`username`,`password`) VALUES ('%s','%s')", username, password);
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
            loginPlayer = username;
            SpellTableManager.getSpellTableManager().addBackPack(username);
            updateCoin(HelloApplication.getMap1().getCoins());
            updateGem(HelloApplication.getMap1().getGems());
            updateHealth(HelloApplication.getMap1().getHealth());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean findPassword(String password, String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("SELECT `password` FROM `player` WHERE `username`= '%s'", username);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return true;
                }

            }
            return false;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String getPassword() {
        String pass="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("SELECT `password` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pass = rs.getString("password");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pass;
    }
    public String getUsername() {
        String user="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("SELECT `username` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user = rs.getString("username");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public boolean loginUser(String username, String password) {
        if (!checkUsername(username)) {
            throw new RuntimeException("user not found");
        }
        if (!findPassword(password, username)) {
            throw new RuntimeException("password is incorrect");
        }
//        System.out.println("mk");
        loginPlayer = username;
        return true;
    }
    public long getCoin(){
        int coins=876;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `coin` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                coins = rs.getInt("coin");
            }
            return coins;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getGem(){
        int gems=90;
        System.out.println("in gem");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `gem` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                gems = rs.getInt("gem");
            }
            return gems;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public long getHealth(){
        long health=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `health` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                health = rs.getLong("health");
            }
            return health;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public int getLevel(){
        int level=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, password);
            String sql = String.format("SELECT `level` FROM `player` WHERE `username`= '%s'", loginPlayer);
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                level = rs.getInt("level");
            }
            return level;
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGem(int amount){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `gem`= gem+"+amount+" WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateCoin(double amount){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `coin`= coin+"+amount+" WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateHealth(int amount){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `health`= health+"+amount+" WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateLevel(int amount){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `level`= level+"+amount+" WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUsername(String newName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `username` = '"+newName+"' WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updatePass(String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Url, userId, this.password);
            String sql = String.format("UPDATE `player` SET `password`= '"+pass+"' WHERE `username`='"+loginPlayer+"'");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
