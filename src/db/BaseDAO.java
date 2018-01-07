

package db;

import java.sql.Connection;

public class BaseDAO {
    Connection con = null;

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public BaseDAO() {
        this.setCon(DatabaseSingleton.getDatabaseSingleton().getConnection(true));
    }
}
