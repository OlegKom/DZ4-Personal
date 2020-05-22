package ru.geekbrains.java_2.home_work_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    public static HashMap<String, ArrayList<Person>> map = new HashMap<>();
    private ArrayList<Person> list;

    public void setMap(String surname, Person person) {
        if (map.containsKey(surname)) {
            list = map.get(surname);
            list.add(person);
            map.put(surname, list);
        } else {
            list = new ArrayList<>();
            list.add(person);
            map.put(surname, list);
        }
    }

    public static ArrayList<String> getPhonesList(String surname) {
        ArrayList<Person> mans;
        ArrayList<String> phones = new ArrayList<>();
        if (map.containsKey(surname)) {
            mans = map.get(surname);
            for (int i = 0; i < mans.size(); i++) {
                phones.add(mans.get(i).getPhone());
            }
        }
        return phones;
    }

    public static ArrayList<String> getEmailList(String surname) {
        ArrayList<Person> mans;
        ArrayList<String> emails = new ArrayList<>();
        if (map.containsKey(surname)) {
            mans = map.get(surname);
            for (int i = 0; i < mans.size(); i++) {
                emails.add(mans.get(i).getEmail());
            }
        }
        return emails;
    }

}
