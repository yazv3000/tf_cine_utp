package pe.edu.universidad.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.dto.DtoSi;

/**
 * Session Bean implementation class EJBGesionSala
 */
@Stateless
@LocalBean
public class EJBGesionSala {
	
	@PersistenceContext(unitName = "cine_utp_jpa")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBGesionSala() {
        // TODO Auto-generated constructor stub
    }

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
	
	public void reservaDeSala(Reserva r ) {
		System.out.println("Nombre: " + r.getNombres());
		System.out.println("Codigo del Horario---: " + r.getCodHorario());
		//em.persist(r);
	}
	

}
