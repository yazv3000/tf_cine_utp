package pe.edu.universidad.proc.alquilarSala;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Sala;

/**
 * Session Bean implementation class EJBGesionSala
 */
@Stateless
@LocalBean
public class EJBAlquilarSala {

	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBAlquilarSala() {	}

	public List<Sala> obtenerDatosSala() {
		Query query = em.createNamedQuery("Sala.findAll");
    	List<Sala> lst = query.getResultList();
		return lst;
	}

	public List<HorarioSala> listadoDeHorasPorFecha() {
		Query query = em.createNamedQuery("HorarioSala.findAll");
    	List<HorarioSala> lst = query.getResultList();
		return lst;
	}
}

