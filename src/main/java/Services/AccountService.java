package Services;

import Accounts.UserProfile;

import java.sql.*;

public class AccountService {
    public static final String URL = "jdbc:mysql://localhost:3306/userfiles?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123123";


    public static void addNewUser(UserProfile user) {
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

    public static UserProfile getUserBySessionId(String key) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");
            ResultSet resultSet = statement.executeQuery(String.format("select * from users_session where user_session_key = '%s'", key));
            resultSet.last();
            String userId = resultSet.getString("user_id");
            ResultSet newResultSet = statement.executeQuery(String.format("select * from users where id = '%s'", userId));
            newResultSet.last();
            String login = newResultSet.getString("username");
            String pass = newResultSet.getString("password");
            String email = newResultSet.getString("email");
            return new UserProfile(login, pass, email);
        } catch (SQLException e) {
            System.out.println("Пользователь с session id не найден!");
        }
        return null;
    }

    public static void addSession(String sessionId, UserProfile userProfile) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");

            ResultSet resultSet = statement.executeQuery(String.format("select * from users where username = '%s'", userProfile.getLogin()));
            resultSet.last();

            String userId = resultSet.getString("id");
            statement.execute(String.format("INSERT INTO users_session(user_session_key, user_id) values ('%s', '%s')", sessionId, userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSession(String sessionId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Соединение установлено");
            statement.execute(String.format("delete from users_session where user_session_key = '%s'", sessionId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}