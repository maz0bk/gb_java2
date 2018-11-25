package com.geekbrains;

public class MyArrayDataException extends Exception {
    private int stringError;
    private int columnError;

    public MyArrayDataException(int stringEror, int columnEror) {
        this.stringError = stringEror;
        this.columnError = columnEror;
    }

    @Override
    public String toString() {
        return "Ошибка преобразования к числу" +
                "stringError=" + stringError +
                ", columnError=" + columnError +
                '}';
    }
}
