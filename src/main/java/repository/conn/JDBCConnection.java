package repository.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static final String CONN_STRING = "jdbc:sqlite:C:\\Users\\pc\\OneDrive\\Desktop\\DBMS\\mysqlite.db";
    private static Connection connection = null;

    public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(CONN_STRING);
        }

        return connection;
    }

}
