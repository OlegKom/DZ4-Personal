package ru.geekbrains.java_2.home_work_3;

import java.util.*;

public class Main {

    public static TreeSet<String> listWord(String[] wordArr) {
        TreeSet<String> words = new TreeSet<>();
        for (int i = 0; i < wordArr.length; i++) {
            words.add(wordArr[i]);
        }
    return words;
    }

    public static HashMap<String, Integer> countWords(String[] wordArr) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < wordArr.length; i++) {
            String word = wordArr[i];
            for (int j = 0; j < wordArr.length; j++) {
                if (word.equals(wordArr[j])) count++;
            }
            map.put(word, count);
            count = 0;
        }
        return map;
    }



    public static void main(String[] args) {
        String[] wordArr = {"у", "лукоморья", "дуб", "зелёный", "златая", "цепь", "на", "дубе", "том",
                "и", "днём", "и", "ночью", "кот", "учёный", "всё", "ходит", "по", "цепи", "кругом",
                "кот", "дуб"};

        Iterator<String> iterator = listWord(wordArr).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }

        Iterator<Map.Entry<String, Integer>> iterator1 = countWords(wordArr).entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> map = iterator1.next();
            System.out.println("Слово: " + map.getKey() + " , количество раз в тексте - " + map.getValue());
        }

        System.out.println("\n");

        Person man1 = new Person("Петров", "123456", "petrov@mail.ru");
        Person man2 = new Person("Малютин", "234567", "malutin@mail.ru");
        Person man3 = new Person("Иванова", "245879", "ivanova@mail.ru");
        Person man4 = new Person("Фролов", "548548", "frolov@mail.ru");
        Person man5 = new Person("Петров", "111111", "111petrov@mail.ru");

        ArrayList<String> phone = PhoneBook.getPhonesList("Петров");
        for (int i = 0; i < phone.size(); i++) {
            System.out.println("Номер телефона: " + phone.get(i));
        }

        ArrayList<String> emails = PhoneBook.getEmailList("Фролов");
        for (int i = 0; i < emails.size(); i++) {
            System.out.println("E-mail: " + emails.get(i));
        }

    }

}
