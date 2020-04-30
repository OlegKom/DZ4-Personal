package ru.geekbrains.home_work_6;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputStream in;
        OutputStream out;

        Print("file.txt", "file2.txt");
        Print2( "file.txt");

    }

    private static void Print(String s, String x) {
        try {

        FileInputStream fis = new FileInputStream(s);
        FileInputStream fis2 = new FileInputStream(x);

        int bin;
        while ((bin = fis.read()) != -1)
            System.out.print((char) bin);

        int bin2;
        while ((bin2 = fis2.read()) != -1)
            System.out.print((char) bin2);

            fis2.close();
//


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }


    private static void Print2(String k) {
        try {
            FileInputStream fis = new FileInputStream(k);
            Scanner scanner = new Scanner(fis);
                while (scanner.hasNext("like"));
                    System.out.println((scanner.nextLine()));
            fis.close();
            scanner.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }


    }

}


