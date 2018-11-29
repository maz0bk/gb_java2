package com.geekbrains;

public class MyArrayDataException extends NumberFormatException {
    private int stringError;
    private int columnError;

    public MyArrayDataException(int stringError, int columnError) {
        this.stringError = stringError;
        this.columnError = columnError;
    }

    @Override
    public String toString() {
        return "Ошибка преобразования к числу. Строка: " + stringError +
                ", колонка: " + columnError;
    }
}
