package ru.geekbrains.java_1.home_work_5;

public class Bird extends Animal{

    public Bird(String name, double heightJumpMax, int weightRunMax, int weightSwimMax) {
        super(name, heightJumpMax, weightRunMax, weightSwimMax);
    }

    @Override
    protected void swim(int weightSwim) {
        System.out.println(name + " не умеет плавать!");
    }

}
