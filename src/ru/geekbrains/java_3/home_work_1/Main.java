package ru.geekbrains.java_3.home_work_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"};
        swap(arr1,1,4);
        swap(arr2,0,2);

        String[] arrayOfStrings = {"A", "B", "C", "D"};
        asList(arrayOfStrings);

        Box<Orange> or = new Box();
        Box<Orange> or1 = new Box();
        Box<Apple> ap = new Box();
        Box<Apple> ap1 = new Box();
        System.out.println("Task 3: ");
        System.out.println("addFruit: ");
        or.addFruit(new Orange(), 12);
        or1.addFruit(new Orange(), 12);
        ap.addFruit(new Apple(), 8);
        ap1.addFruit(new Apple(), 4);
        System.out.println("Box 1: " + or.getWeight());
        System.out.println("Box 2: " + or1.getWeight());
        System.out.println("Box 3: " + ap.getWeight());
        System.out.println("Box 4: " + ap1.getWeight());
        System.out.println("compare: ");
        System.out.println("Box 1 equals box 2: " + or.compare(or1));
        System.out.println("Box 3 equals box 4: " + ap.compare(ap1));
        System.out.println("'pourTo box: ");
        or.pourTo(or1);
        ap.pourTo(ap1);
        System.out.println("getWeight: ");
        System.out.println("Box 1: " + or.getWeight());
        System.out.println("Box 2: " + or1.getWeight());
        System.out.println("Box 3: " + ap.getWeight());
        System.out.println("Box 4: " + ap1.getWeight());
    }

    public static void swap(Object[] arr, int n1, int n2) {
        System.out.println("Task 1: " + Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = sw;
        System.out.println("The result: " + Arrays.toString(arr)+ "\n");
    }

    public static <T> void asList(T[]arr) {
        ArrayList<T> res = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Task 2 and result: " + res + "\n");
    }
}
