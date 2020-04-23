package ru.geekbrains.home_work_5;

public class Cat extends Animal {

    public Cat(String name, double heightJumpMax, int weightRunMax, int weightSwimMax) {
        super(name, heightJumpMax, weightRunMax, weightSwimMax);
    }

    @Override
    protected void swim(int weightSwim) {
        System.out.println(name + " не умеет плавать!");
    }
}
