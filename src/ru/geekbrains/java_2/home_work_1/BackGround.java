package ru.geekbrains.java_2.home_work_1;

import java.awt.*;

public class BackGround {

    Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255));
    Color newColor;
    long lastTime;


    BackGround() {
        lastTime = System.nanoTime();
    }

    public Color getNewColor() {
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastTime) * 0.000000001f;
        if (deltaTime > 15) {
            lastTime = currentTime;
            newColor = new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255));
            color = newColor;
            return newColor;
        }
        else return color;
    }

}
