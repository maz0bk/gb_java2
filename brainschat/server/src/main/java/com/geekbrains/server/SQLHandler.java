package com.geekbrains.server;

import java.sql.*;

public class SQLHandler {
    private static Connection connection;
    private static PreparedStatement psChangeNick;
    private static PreparedStatement psGetNickByLoginAndPassword;

    public static boolean connect()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/brains_chat?serverTimezone=UTC", "root", "FlySky128#");
            psGetNickByLoginAndPassword = connection.prepareStatement("SELECT nick FROM brains_chat.users where login = ? and password = ?;");
            psChangeNick = connection.prepareStatement("UPDATE brains_chat.users SET nick = ? where nick = ? ;");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String getNicknameByLoginAndPassword(String login, String password) {
        try {

            psGetNickByLoginAndPassword.setString(1,login);
            psGetNickByLoginAndPassword.setString(2,password);
            ResultSet rs = psGetNickByLoginAndPassword.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean changeNick(String oldNick, String newNick) {
        try {

            psChangeNick.setString(1,newNick);
            psChangeNick.setString(2,oldNick);
            psChangeNick.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public static void disconnect() {
        try {
            psChangeNick.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psGetNickByLoginAndPassword.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
