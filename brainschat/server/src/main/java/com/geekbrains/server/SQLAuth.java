package com.geekbrains.server;

public class SQLAuth implements AuthService {

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return SQLHandler.getNicknameByLoginAndPassword(login,password);
    }

    @Override
    public boolean changeNick(String oldNick, String newNick) {
        return SQLHandler.changeNick(oldNick, newNick);
    }
}
