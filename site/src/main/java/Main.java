import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db = DatabaseConnection.getInstance();
        try {
            db.connect("users.db");
            insert("Oleh", "Koval123");
            select();
            db.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void select() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT *  FROM account";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("ID: " + id + " NAME: " + name + " PASSWORD: " + password);
        }
    }
    public static void insert(String name, String password) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "INSERT INTO account (username, password) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("CREATED ID: " + id);
        }
    }
}