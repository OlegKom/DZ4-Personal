package ru.geekbrains.home_work_4;

public class Personal {

    private String fio;
    private int salary;
    private int age;
    private static final int UP_SALARY = 5000;

    public Personal(String fio, int salary, int age) {
        this.fio = fio;
        this.salary = salary;
        this.age = age;
    }


    public int getSalaryUp() {
        return salary + UP_SALARY;
    }


    public int getAge() {
        return age;
    }

    void printInfo() {
        System.out.println("ФИО: " + fio + "   Зарплата: " + salary + "   Возраст: " + age);
    }

    void printInfo2() {
        System.out.println("ФИО: " + fio + "   Возраст: " + age);
    }

}

