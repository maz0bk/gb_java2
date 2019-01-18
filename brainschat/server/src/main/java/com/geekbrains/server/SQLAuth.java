package com.geekbrains.server;

import java.sql.*;

public class SQLAuth implements AuthService {
    private static Connection connection;
    private static PreparedStatement psInsert;
    private static PreparedStatement psQuery;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/brains_chat?serverTimezone=UTC", "root", "FlySky128#");

    }
    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        try {
            psQuery = connection.prepareStatement("SELECT nick FROM brains_chat.users where login = ? and password = ?;");
            psQuery.setString(1,login);
            psQuery.setString(2,password);
            ResultSet rs = psQuery.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String setNickname(String login, String newNick) {
        try {
            psQuery = connection.prepareStatement("UPDATE brains_chat.users SET nick = ? where login = ? ;");
            psQuery.setString(1,newNick);
            psQuery.setString(2,login);
            int numberOfUpdatedRows = psQuery.executeUpdate();
            if (numberOfUpdatedRows == 1){
                return newNick;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public SQLAuth() {
        //connection to base
        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
//            disconnect();
        }

    }
    public static void disconnect() {
        try {
            psInsert.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psQuery.close();
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
