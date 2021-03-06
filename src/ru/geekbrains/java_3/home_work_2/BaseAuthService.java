package ru.geekbrains.java_3.home_work_2;

import java.sql.*;


public class BaseAuthService implements AuthService {
    /*
    private class Entry {
        private String login;
        private String pass;
        private String nick;
        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }
     */
    private static final String DATABASE_NAME = "chatsrv.s3db";
    //public static Statement statmt;
    //public static ResultSet resSet;

    private Connection connection;

    //private List<Entry> entries;

    @Override
    public void start() {
        try {
            this.connect();
            System.out.println("Сервис аутентификации запущен");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        disconnect();
        System.out.println("Сервис аутентификации остановлен");
    }


    public BaseAuthService() {
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT nickname FROM users WHERE login = ? AND pass = ? LIMIT 1");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return rs.getString(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public boolean changeNickName(String login, String pass,String nickname){
        boolean res=false;
        try {
            String sql = "UPDATE users SET nickname = ? WHERE login = ? and pass = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, login);
            ps.setString(3, pass);
            res =  ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }



    private void disconnect() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:" + BaseAuthService.DATABASE_NAME;
        this.connection = DriverManager.getConnection(url);
    }
}
