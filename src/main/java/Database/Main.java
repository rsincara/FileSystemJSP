package Database;

import Accounts.UserProfile;

import java.sql.*;

public class Main {

    public static final String URL = "jdbc:mysql://localhost:3306/userfiles?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123123";


    public static void main(String[] args) throws ClassNotFoundException {
       getUserByLogin("2");
    }

    public static void registerUser(UserProfile user) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");
            statement.execute(String.format("INSERT INTO users(username, password, email) values ('%s', '%s', '%s')", user.getLogin(), user.getPass(), user.getEmail()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static UserProfile getUserByLogin(String login) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");
            ResultSet resultSet = statement.executeQuery(String.format("select * from users where username = '%s'", login));
            resultSet.last();
            String email = resultSet.getString("email");
            String pass = resultSet.getString("password");
            return new UserProfile(login, pass, email);
        } catch (SQLException e) {
            System.out.println("Пользователь не найден!");
        }
        return null;
    }

    public static UserProfile getUserBySessionId(String key){
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");
            ResultSet resultSet = statement.executeQuery(String.format("select * from users_session where user_session_key = '%s'", key));
            resultSet.last();
            String userId = resultSet.getString("user_id");
            resultSet = statement.executeQuery(String.format("select * from users where id = '%s'", userId));
            resultSet.last();
            String login = resultSet.getString("login");
            String pass = resultSet.getString("password");
            String email = resultSet.getString("email");
            return new UserProfile(login, pass, email);
        } catch (SQLException e) {
            System.out.println("Пользователь не найден!");
        }
        return null;
    }


}
