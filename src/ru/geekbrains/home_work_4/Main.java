package ru.geekbrains.home_work_4;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    	Personal [] people = new Personal[5];

    	people [0] = new Personal("Иванов Иван Иванович", 15000, 45);

		people [1] = new Personal("Бондаренко Екатерина Алексеевна", 20000, 35);

		people [2] = new Personal("Мамаев Мамай Мамаевич", 25000, 20);

		people [3] = new Personal("Петров Петр Петрович", 30000, 41);

		people [4] = new Personal("Агаев Агай Агаевич", 35000, 50);

		System.out.println("Сотрудники старше 40 лет:");
		for (int i = 0; i < people.length; i++) {
			if (people[i].getAge() > 40){
				people[i].printInfo();
			}
		}

		System.out.println("\nСотрудники ФИО и возраст:");
		for (int i = 0; i < people.length; i++) {
			people[i].printInfo2();
		}

		System.out.println("\nПовысить сотрудникам зп на 5000р");
		for (int i = 0; i < people.length; i++) {
			if (people[i].getAge() >= 45){
				people[i].getSalaryUp();
				people[i].printInfo();
			}


		}

	}

}
