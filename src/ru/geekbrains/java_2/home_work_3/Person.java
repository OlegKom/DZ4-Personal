package ru.geekbrains.java_2.home_work_3;

public class Person {
    private String surname;
    private String phone;
    private String email;
    private static final PhoneBook book = new PhoneBook();

    public Person(String surname, String phone, String email) {
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        book.setMap(this.surname, this);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
