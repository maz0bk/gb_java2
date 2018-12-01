package com.geekbrains;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String,HashSet<String>> phoneBook;
    public PhoneBook(){
        phoneBook = new HashMap<>();
    }
    public void add(String surname, String phone){
        if (phoneBook.containsKey(surname)){
            HashSet<String> hs = phoneBook.get(surname);
            hs.add(phone);
            phoneBook.put(surname,hs);
        }
        else {
            HashSet<String> hs = new HashSet<String>();
            hs.add(phone);
            phoneBook.put(surname,hs);
        }
    }
    public String get(String surname){
       HashSet<String> hs = phoneBook.get(surname);
       return surname +" "+ hs;
    }
    public static void testPhoneBook(PhoneBook phoneBook){
        phoneBook.add("Ivanov","88007900000");
        phoneBook.add("Ivanov","88007900001");
        phoneBook.add("Ivanov","88007900002");
        phoneBook.add("Petrov","88007900007");
        phoneBook.add("Sidorow","88007900011");
        phoneBook.add("Sidorow","88007900011");

        System.out.println(phoneBook.get("Ivanov"));
        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Sidorow"));
    }
}
