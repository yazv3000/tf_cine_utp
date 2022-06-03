package pe.edu.universidad.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.*;

public class DaoCliente extends DaoGenerico{
	public List<cliente> consultarClientes() {
        List<cliente> lst = new ArrayList<cliente>();
        String sql = "select * from cliente";
        Connection cnx = getConnection();
        ResultSet rs;
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
            	cliente c = new cliente();
                c.setIdClie(rs.getInt(1));
                c.setNomClie(rs.getString(2));
                c.setApeClie(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setDireccion(rs.getString(5));
                lst.add(c);
            }
            cnx.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}
