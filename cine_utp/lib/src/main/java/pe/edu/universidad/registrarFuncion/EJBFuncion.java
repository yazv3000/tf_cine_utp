package pe.edu.universidad.registrarFuncion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import cine_utp_jpa.Funcion;
import cine_utp_jpa.Pelicula;
import cine_utp_jpa.Sala;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.universidad.dto.DtoFuncionNueva;
import pe.edu.universidad.dto.DtoPeli;
import pe.edu.universidad.entidades.sala;




@Stateless
@LocalBean
public class EJBFuncion {
	
	@PersistenceContext(unitName = "cine_utp_jpa")
    private EntityManager em;
	
	public EJBFuncion() {
	}
	
	public List<DtoPeli> consultarPeliculaId(String cadena) {
		List<DtoPeli> lst = new ArrayList<DtoPeli>();
		Query query = em.createNamedQuery("Pelicula.consultarPorNombre");
		query.setParameter("cadena", "%" + cadena + "%");
		List<Pelicula> lstPeliculas = query.getResultList();
		for (Pelicula pelicula : lstPeliculas) {
			DtoPeli dtoPeli = new DtoPeli();
			dtoPeli.setCodigo(pelicula.getCodPelicula());
			dtoPeli.setNombre(pelicula.getNomPeli());
			dtoPeli.setDuracion(pelicula.getDuracion());
			lst.add(dtoPeli);
		}
		return lst;
	}

	public List<sala> consultarSalas() {
		List<sala> lst = new ArrayList<sala>();
		Query query = em.createNamedQuery("Sala.findAll");
		List<Sala> lstSalas =query.getResultList();
		for (Sala sal : lstSalas) {
			sala s = new sala();
			s.setCodigo(sal.getCodSala());
			s.setCapacidad(sal.getCapacidad());
			lst.add(s);
		}
		return lst;
	}


	public void insertarFuncion(DtoFuncionNueva f) {
		System.out.println("ya casI xd");
		Funcion funcion = new Funcion();
		funcion.setCodSala(f.getCodSala());
		funcion.setFechaFuncion(f.getFecha());
		funcion.setHoraInicio(f.getHoraInicio());
		funcion.setPelicula(f.getPeli());
		funcion.setPrecio(new BigDecimal(f.getPrecio())); 
		em.persist(funcion);
	}

}
