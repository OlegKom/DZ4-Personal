package ru.geekbrains.java_1.home_work_5;

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat("Котик", 2,200,0);
        Dog d = new Dog("Песик1", 0.5, 500, 10);
        Bird b = new Bird("Птичка", 0.2, 5,0);
        Horse h = new Horse("Лошадка", 3, 1500, 100);

        Animal[] zoo = {c, d, b, h};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].jump(3);
            zoo[i].swim(50);
            zoo[i].run(600);
        }

        System.out.println("------------");
        d.run(100);
        d.jump(100);

        Animal[] dogs = new Animal[]{
                d,
                new Animal("Песик2", 0.5, 450, 10),
                new Animal("Песик3",0.5, 500, 10)
        };

        for (int i = 0; i < dogs.length; i++) {
            dogs[i].run(500);
        }

    }
}
