package pe.edu.universidad.proc.gestionarFuncion;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cine_utp_jpa.Funcion;
import cine_utp_jpa.Pelicula;
import cine_utp_jpa.Sala;
import pe.edu.universidad.dto.DtoSi;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoFuncionConsulta;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoFuncionNueva;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoPeliculaConsulta;

/**
 * Session Bean implementation class EJBGestionarFunciones
 */
@Path("EJBGestionarFunciones")
@Stateless
@LocalBean
public class EJBGestionarFuncion {

	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    
	/**
     * Default constructor. 
     */
    public EJBGestionarFuncion() {}
    
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
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPeliculasTodos")
    public List<DtoPeliculaConsulta> consultarPeliculasTodos() {
    	
    	Query query = em.createNamedQuery("Pelicula.findAll");
    	List<Pelicula> lst = query.getResultList();
    	List<DtoPeliculaConsulta> lstDto = new ArrayList<DtoPeliculaConsulta>();
    	
    	for (Pelicula pelicula : lst) {
    		DtoPeliculaConsulta dto = new DtoPeliculaConsulta();
    		dto.setCodigo(pelicula.getCodPelicula());
    		dto.setNombre(pelicula.getNomPeli());
    		dto.setDescripcion(pelicula.getDescripcion());
    		dto.setTipo(pelicula.getTipopeli().getNomTipopeli());
    		dto.setCalificacion(pelicula.getCodCalific());
    		dto.setDuracion(pelicula.getDuracion()/60+":"+pelicula.getDuracion()%60);
    		lstDto.add(dto);
		}
    	
    	return lstDto;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarFuncionesTodos")
    public List<DtoFuncionConsulta> consultarFuncionesTodos() {
    	
    	Query query = em.createNamedQuery("Funcion.findAll");
    	List<Funcion> lst = query.getResultList();
    	List<DtoFuncionConsulta> lstDto = new ArrayList<DtoFuncionConsulta>();
    	
    	for (Funcion funcion : lst) {
    		DtoFuncionConsulta dtoFuncion = new DtoFuncionConsulta();
    		dtoFuncion.setCodFuncion(funcion.getCodFuncion());
    		dtoFuncion.setNombrePelicula(funcion.getPelicula().getNomPeli());
    		dtoFuncion.setSala(funcion.getCodSala());
    		dtoFuncion.setFecha(funcion.getFechaFuncion());
    		dtoFuncion.setHora(funcion.getHoraInicio());
    		dtoFuncion.setPrecio(funcion.getPrecio().doubleValue());
    		lstDto.add(dtoFuncion);
		}
    	
    	return lstDto;
    }
    
    
    @POST
    @Path("registrarFuncion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void registrarFuncion(DtoFuncionNueva dtoFuncionNueva) {
    	
    	System.out.println("========== NUEVA FUNCIÓN ==========");
		System.out.println("Codigo de la Pelicula: " + dtoFuncionNueva.getCodPelicula());
		System.out.println("Codigo de la Sala: " + dtoFuncionNueva.getCodSala());
		System.out.println("Fecha: " + dtoFuncionNueva.getFecha());
		System.out.println("Precio: " + dtoFuncionNueva.getPrecio());
		System.out.println("==============================");
		
		Funcion funcion = new Funcion();
		funcion.setPelicula(new Pelicula());
		funcion.getPelicula().setCodPelicula(dtoFuncionNueva.getCodPelicula());
		funcion.setCodSala(dtoFuncionNueva.getCodSala());
		funcion.setFechaFuncion(dtoFuncionNueva.getFecha());
		funcion.setPrecio(BigDecimal.valueOf(dtoFuncionNueva.getPrecio()));
		funcion.setHoraInicio(new Time(dtoFuncionNueva.getFecha().getTime()));
		em.persist(funcion);
		
	}
	
}
