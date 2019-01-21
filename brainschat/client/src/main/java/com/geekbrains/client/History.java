package com.geekbrains.client;

import java.io.*;

public class History {
    private File fileHistory;

    public History(String nickName) {
        fileHistory = new File("history_"+nickName+".txt");
    }
    public String getLastHistory(int rowsCount){
        if (!(fileHistory.exists()&& rowsCount>0)){
        return null;
        }

        String result="";
        String tmp;
        try {
           BufferedReader bfReader = new BufferedReader(new FileReader(fileHistory));

            try {
                while ((tmp = bfReader.readLine()) != null){
                    result +=tmp+"\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bfReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void writeMsgToHistory(String msg){
        try {
            FileWriter fileWriter= new FileWriter(fileHistory,true);
            fileWriter.append(msg);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
