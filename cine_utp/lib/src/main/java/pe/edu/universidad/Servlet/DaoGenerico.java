package pe.edu.universidad.Servlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoGenerico {
	public static Connection getConnection() {
        Connection cnx = null;
        try {
            Context ctx = new InitialContext(); 
            DataSource ds = (DataSource)ctx.lookup("java:/jdbc/dbcineutp01"); 
            cnx = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e); 
        }
        return cnx;
    }
}
