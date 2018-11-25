package com.geekbrains;

public class MyArraySizeException extends Exception {
    @Override
    public String toString() {
        return "Размер массива превышает 4х4";
    }
}
