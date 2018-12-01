package com.geekbrains;

public class MainClass {
    public static void main(String[] args) {
        MyArray ma = new MyArray(20);
        System.out.println("Unique words: "+ma.getUniqueWord());
        System.out.println("Count words: "+ma.getCountWord());

        PhoneBook phoneBook = new PhoneBook();
        PhoneBook.testPhoneBook(phoneBook);
    }
}
