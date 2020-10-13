package ru.geekbrains.java_3.home_work_7;

public class Hw7 {
    public static void main(String[] args) {


        Class cs = TestClass1.class;
        try {
            TestRunner.start(cs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

