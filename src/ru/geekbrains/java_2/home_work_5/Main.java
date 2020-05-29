package ru.geekbrains.java_2.home_work_5;

import java.util.Arrays;

public class Main {

    public static long timeToArr1(int size){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    public static long[] timesToArr2(int size){
        long[] times = new long[4];
        float[] arr = new float[size];
        int h = size/2;
        Arrays.fill(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        long finish = System.currentTimeMillis();
        times[0] = finish - start;

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                long start1 = System.currentTimeMillis();
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long finish1 = System.currentTimeMillis();
                times[1] = finish1 - start1;
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                long start2 = System.currentTimeMillis();
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                long finish2 = System.currentTimeMillis();
                times[2] = finish2 - start2;
            }
        };
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start3 = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long finish3 = System.currentTimeMillis();
        times[3] = finish3 - start3;

        return times;
    }

    public static void main(String[] args) {
        System.out.println("Время на работу с массивом в 1 потоке = " + timeToArr1(10000000));
        long[] arr = timesToArr2(10000000);
        System.out.println("Время разбивки массива на два = " + arr[0]);
        System.out.println("Время на просчёт первого массива = " + arr[1]);
        System.out.println("Время на просчёт второго массива = " + arr[2]);
        System.out.println("Время на склейку массивов = " + arr[3]);
    }
}
