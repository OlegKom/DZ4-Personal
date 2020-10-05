package ru.geekbrains.java_3.home_work_4;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    boolean changeNickName(String login, String pass,String nickname);
    void stop();

}
