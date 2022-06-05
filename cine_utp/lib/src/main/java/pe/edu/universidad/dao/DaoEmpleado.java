package pe.edu.universidad.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.*;
public class DaoEmpleado extends DaoGenerico{

	public List<Empleado> consultarEmpleados(){
		List<Empleado> lst = new ArrayList<Empleado>();
		String sql = "SELECT E.cod_empleado, E.nom_emp, E.ape_emp, C.nom_cargo, E.email_emp, E.direccion_emp, E.salario "
				+ "FROM empleado E INNER JOIN cargo C "
				+ "ON E.cod_cargo = C.cod_cargo;";
		
		Connection cnx = getConnection();
		ResultSet rs;
		
		try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
            	if(rs.getInt(1)==0)	 continue;
                Empleado emp = new Empleado();
                emp.setCod_empleado(rs.getInt(1));
                emp.setNom_emp(rs.getString(2));
                emp.setApe_emp(rs.getString(3));
                emp.setCargo(rs.getString(4));
                emp.setEmail_emp(rs.getString(5));
                emp.setDireccion_emp(rs.getString(6));
                emp.setSalario(rs.getDouble(7));
                
                lst.add(emp);
            }
            
            cnx.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;

	}
}
