package pe.edu.universidad.proc.alquilarSala;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.rs.EJBDaoGenerico;

/**
 * Session Bean implementation class EJBGesionSala
 */
@Path("EJBAlquilarSala")
@Stateless
@LocalBean
public class EJBAlquilarSala {

	@EJB
	private EJBDaoGenerico dao;
	
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBAlquilarSala() {	}

	@GET
	@Path("listarSalasTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sala> listarSalasTodos() {
		Query query = em.createNamedQuery("Sala.findAll");
    	List<Sala> lst = query.getResultList();
		return lst;
	}

	@GET
	@Path("listadoDeHorariosPorFecha")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HorarioSala> listadoDeHorariosPorFecha(Date fecha) {
		Query query = em.createNamedQuery("HorarioSala.filtrarFecha");
		query.setParameter("date", fecha);
    	List<HorarioSala> lst = query.getResultList();
		return lst;
	}
	
	@POST
	@Path("reservaDeSala")
	@Produces(MediaType.APPLICATION_JSON)
	public void reservaDeSala(Reserva r ) {
		System.out.println("Guardando reserva.....");
		em.persist(r);
	}
	
    public HorarioSala consultarHorarioPorId(int idHorario) {
    	HorarioSala horario = (HorarioSala) dao.consultarEntityPorId("HorarioSala", idHorario);
    	return horario;
    }
	
}

