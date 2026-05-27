package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection instance = null;

    public static DatabaseConnection getInstance(){
        if(instance==null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);
    }

    public void disconnect() throws SQLException{
        connection.close();
    }

}
