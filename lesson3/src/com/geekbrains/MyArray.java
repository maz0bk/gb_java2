package com.geekbrains;

import java.util.*;

public class MyArray {
    private String array[];

    public MyArray(int size) {
        array = new String[size];
        fillArray();
    }
    private void fillArray(){
        for(int i=0; i<array.length; i++){
            array[i] ="word_"+(int)(10*Math.random());
        }
    }
    public Set<String> getUniqueWord(){
        return  new HashSet<>(Arrays.asList(array));
    }
    public HashMap<String,Integer> getCountWord(){
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s : array){
            if (hm.containsKey(s)){
                hm.put(s,hm.get(s)+1);
            }
            else hm.put(s,1);
        }
        return hm;
    }
}
