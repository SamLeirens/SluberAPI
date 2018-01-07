
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton ref;

    private DatabaseSingleton() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException var2) {
            var2.printStackTrace();
        }

    }

    public static DatabaseSingleton getDatabaseSingleton() {
        if (ref == null) {
            ref = new DatabaseSingleton();
        }

        return ref;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Connection getConnection(boolean autoCommit) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/JAVA036", "JAVA036", "Vergeet1");
        } catch (SQLException var4) {
            System.out.println("SQLException: " + var4.getMessage());
            System.out.println("SQLState: " + var4.getSQLState());
            System.out.println("VendorError: " + var4.getErrorCode());
        }

        return conn;
    }
}
