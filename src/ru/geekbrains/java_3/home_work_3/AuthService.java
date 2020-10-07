package ru.geekbrains.java_3.home_work_3;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    boolean changeNickName(String login, String pass,String nickname);
    void stop();
}
