package pe.edu.universidad.ejb;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cine_utp_jpa.Funcion;
import cine_utp_jpa.Pelicula;
import cine_utp_jpa.Sala;
import pe.edu.universidad.dto.DtoFuncionNueva1;
import pe.edu.universidad.dto.DtoPelicula;
import pe.edu.universidad.dto.DtoSala;
import pe.edu.universidad.dto.DtoSi;

/**
 * Session Bean implementation class EJBGestionarFunciones
 */
@Path("EJBGestionarFunciones")
@Stateless
@LocalBean
public class EJBGestionarFunciones {

	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBGestionarFunciones() {
        // TODO Auto-generated constructor stub
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPeliculasTodos")
    public List<DtoPelicula> consultarPeliculasTodos() {
    	Query query = em.createNamedQuery("Pelicula.findAll");
    	List<Pelicula> lst = query.getResultList();
    	List<DtoPelicula> lstDto = new ArrayList<DtoPelicula>();
    	for (Pelicula pelicula : lst) {
    		DtoPelicula dto = new DtoPelicula();
    		dto.setId(pelicula.getCodPelicula());
    		dto.setNombre(pelicula.getNomPeli());
    		lstDto.add(dto);
		}
    	
    	return lstDto;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPeliculasPorNombre")
	public List<DtoPelicula> consultarPeliculasPorNombre(String cadenaPelicula) {
		Query query = em.createNamedQuery("Pelicula.consultarPorNombre");
		query.setParameter("cadena", "%" + cadenaPelicula + "%");
    	List<Pelicula> lst = query.getResultList();
    	List<DtoPelicula> lstDto = new ArrayList<DtoPelicula>();
    	for (Pelicula pelicula : lst) {
    		DtoPelicula dto = new DtoPelicula();
    		dto.setId(pelicula.getCodPelicula());
    		dto.setNombre(pelicula.getNomPeli());
    		lstDto.add(dto);
		}
    	return lstDto;
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPeliculas")
	public List<DtoSi> consultarPeliculas(){
		Query query = em.createNamedQuery("Pelicula.findAll");
    	List<Pelicula> lst = query.getResultList();
    	List<DtoSi> lstDto = new ArrayList<DtoSi>();
    	for (Pelicula pelicula : lst) {
    		DtoSi dto = new DtoSi();
    		dto.setId(pelicula.getCodPelicula());
    		dto.setNombre(pelicula.getNomPeli());
    		lstDto.add(dto);
		}
    	return lstDto;
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarSalas")
	public List<DtoSi> consultarSalas(){
		Query query = em.createNamedQuery("Sala.findAll");
    	List<Sala> lst = query.getResultList();
    	List<DtoSi> lstDto = new ArrayList<DtoSi>();
    	for (Sala sala : lst) {
    		DtoSi dto = new DtoSi();
    		dto.setId(sala.getCodSala());
    		dto.setNombre( "Sala " + sala.getCodSala());
    		lstDto.add(dto);
		}
    	return lstDto;
	}
	
	
	public void registrarFuncion(DtoFuncionNueva1 dtoFuncionNueva) {
		System.out.println("Codigo de la Pelicula: " + dtoFuncionNueva.getCodPelicula());
		System.out.println("Codigo de la Sala: " + dtoFuncionNueva.getCodSala());
		System.out.println("Fecha: " + dtoFuncionNueva.getFecha());
		System.out.println("Precio: " + dtoFuncionNueva.getPrecio());
		
		Funcion funcion = new Funcion();
		//funcion.setCodFuncion(100);
		funcion.setCodPelicula(dtoFuncionNueva.getCodPelicula());
		funcion.setCodSala(dtoFuncionNueva.getCodSala());
		funcion.setFechaFuncion(dtoFuncionNueva.getFecha());
		funcion.setPrecio(BigDecimal.valueOf(dtoFuncionNueva.getPrecio()));
		funcion.setHoraInicio(new Time(dtoFuncionNueva.getFecha().getTime()));
		em.persist(funcion);
	}
	
	

}
