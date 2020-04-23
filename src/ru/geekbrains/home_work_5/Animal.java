package ru.geekbrains.home_work_5;

public class Animal {
    protected final String name;
    protected double heightJumpMax;
    protected int weightRunMax;
    protected int weightSwimMax;

    public Animal(String name, double heightJumpMax, int weightRunMax, int weightSwimMax) {
        this.name = name;
        this.heightJumpMax = heightJumpMax;
        this.weightRunMax = weightRunMax;
        this.weightSwimMax = weightSwimMax;
    }

//    protected void run(int weightRun) {
//        System.out.println(name + " бежит " + (weightRun <= weightRunMax));
//    }
    protected void run(int weightRun) {
        if (weightRun <= weightRunMax)
            System.out.println( name + " бежит");
        else
            System.out.println( name + " не бежит");
    }


    protected void jump(double heightJump) {
        if (heightJump <= heightJumpMax)
            System.out.println( name + " прыгает ");
        else
            System.out.println( name + " не прыгает");
    }

    protected void swim(int weightSwim) {
        if (weightSwim <= weightSwimMax)
            System.out.println( name + " плывет ");
        else
            System.out.println( name + " не плывет ");
    }

}
