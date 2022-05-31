package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.*;
public class DaoPelicula extends DaoGenerico{

	public List<Pelicula> consultarPeliculas(){
		List<Pelicula> lst = new ArrayList<Pelicula>();
		String sql = "SELECT P.cod_pelicula, P.nom_peli,  P.descripcion, TP.nom_tipopeli, P.cod_calific, P.duracion, P.poster "
				+ "FROM pelicula P "
				+ "INNER JOIN tipo_pelicula TP ON P.cod_tipopeli = TP.cod_tipopeli";
		
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				Pelicula p = new Pelicula();
				p.setCod_pelicula(rs.getInt(1));
				p.setNom_peli(rs.getString(2));			
				p.setDescripcion(rs.getString(3));
				p.setTipo(rs.getString(4));
				p.setCalificacion(rs.getString(5));
				int min = rs.getInt(6);
				p.setDuracion(min/60+":"+min%60);
				p.setPoster(rs.getBytes(7));
				lst.add(p);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
}