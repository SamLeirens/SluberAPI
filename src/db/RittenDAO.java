
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Bestuurder;
import models.Rit;

public class RittenDAO extends BaseDAO {
    public RittenDAO() {
    }
    public Bestuurder getBestuurderById(int id) {
    	 Bestuurder b = null;
        Statement st = null;
        Connection c = this.getCon();

        try {
            if (c != null && !c.isClosed()) {
                st = this.getCon().createStatement();
                ResultSet rs = st.executeQuery("select * from Bestuurder where id ='"+id+"'");

                while(rs.next()) {
                   b = new Bestuurder(id,rs.getString("naam"),rs.getString("telefoonnr"));
                    
                }

                return b;
            } else {
                throw new IllegalStateException("error unexpected");
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            return b;
        }
    }

    public ArrayList<Rit> getAll() {
        ArrayList<Rit> lijst = new ArrayList<Rit>();
        Statement st = null;
        Connection c = this.getCon();

        try {
            if (c != null && !c.isClosed()) {
                st = this.getCon().createStatement();
                ResultSet rs = st.executeQuery("select * from Ritten");

                while(rs.next()) {
                	Bestuurder b = getBestuurderById(rs.getInt("bestuurder"));
                    Rit g = new Rit(b, rs.getString("richting"),rs.getString("evenement"), rs.getInt("plaats"));
                    lijst.add(g);
                }

                return lijst;
            } else {
                throw new IllegalStateException("error unexpected");
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            return lijst;
        }
    }
    
    public ArrayList<Rit> getRitByRichting(String event)
    {
    	 ArrayList<Rit> lijst = new ArrayList<Rit>();
    	 Statement st = null;
         Connection c = this.getCon();

         try {
             if (c != null && !c.isClosed()) {
                 st = this.getCon().createStatement();
                 ResultSet rs = st.executeQuery("select * from Ritten where evenement ='"+event+"'");

                 while(rs.next()) {
                	 Bestuurder b = getBestuurderById(rs.getInt("bestuurder"));
                     Rit g = new Rit(b, rs.getString("richting"), rs.getString("evenement"), rs.getInt("plaats"));
                     lijst.add(g);
                 }

                 return lijst;
             } else {
                 throw new IllegalStateException("error unexpected");
             }
         } catch (SQLException var6) {
             var6.printStackTrace();
             return lijst;
         }
    }
    
    public int insert(Rit rit) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO Ritten VALUES(?,?,?,?)";

		try {

			if (getCon().isClosed()) {
				throw new IllegalStateException("error unexpected");
			}
			ps = getCon().prepareStatement(sql);

			ps.setInt(1, rit.getBestuurder().getId());
			ps.setString(2, rit.getRichting());
			ps.setString(3, rit.getEvenement());
			ps.setInt(4, rit.getPlaats());

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				;
				throw new RuntimeException("error.unexpected");
			}
		}
    }

};

