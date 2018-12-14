package com.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.Math.abs;

public class MainClass {
    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float [] arr = new float[size];
        for (int i = 0; i < size ; i++) {
            arr [i] =1;
        }
//        countArrayOneThread(arr);
//        countArrayTwoThread(arr,h);
        int [] ar =new int[]{1,2,3,5};
       Integer sum = Arrays.stream(ar).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(sum);
    }
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int at=0,bt=0;
        for(int i =0; i<3; i++){
            if(a.get(i)> b.get(i)) at++;
            else if(a.get(i)< b.get(i)) bt++;
        }
        List<Integer> c = new ArrayList<>();
        c.add(at);
        c.add(bt);
        return c;
    }
    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).reduce((s1, s2) -> s1 + s2).orElse(0);
    }

    static int diagonalDifference(int[][] arr) {
        int leftDiag=0, rightDiag =0;
        for (int i = 0; i < arr.length; i++) {
        leftDiag += arr[i][i];
        rightDiag += arr[i][arr.length-1-i];
            
        }
    return abs(leftDiag-rightDiag);

    }
        private static void countArrayTwoThread(float[] arr, int h) {
        long startTime = System.currentTimeMillis();
        float a1 [] = new float[h];
        float a2 [] = new float[h];
        System.arraycopy(arr,0,a1,0,h);
        System.arraycopy(arr, h, a2,0,h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i]= (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        System.out.println("Running time in two threads "+ (System.currentTimeMillis() - startTime));
    }

    private static void countArrayOneThread(float[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Running time in one thread "+ (System.currentTimeMillis() - startTime));
    }
}
