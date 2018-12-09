package com.geekbrains;

public class MainClass {
    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;
        float [] arr = new float[size];
        for (int i = 0; i < size ; i++) {
            arr [i] =1;
        }
        countArrayOneThread(arr);
        countArrayTwoThread(arr,h);
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
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
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
