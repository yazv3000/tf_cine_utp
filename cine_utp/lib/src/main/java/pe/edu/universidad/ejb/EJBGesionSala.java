package pe.edu.universidad.ejb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
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
	private int codHorario;

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
	
	public Map<Integer, List<SelectItem>> todosHorariosMap(){
		List<Sala> salas = obtenerDatosSala();
		List<HorarioSala> horarios =listadoDeHorasPorFecha();
		Map<Integer, List<SelectItem>> horarioMap = new LinkedHashMap<Integer, List<SelectItem>>();
		
		for (int i = 0; i < salas.size(); i++) {
			List<SelectItem> items = new ArrayList<SelectItem>();
			
			for (int j = 0; j < horarios.size(); j++) {
				if (salas.get(i).getCodSala() == horarios.get(j).getCodSala()) {
					SelectItem item = new SelectItem();
					item.setLabel(horarios.get(j).getHora().getHours()<10?"0"+horarios.get(j).getHora().getHours()+":00":horarios.get(j).getHora().getHours()+":00");
					item.setValue(horarios.get(i).getCodigo());
					items.add(item);
				}
			}
			horarioMap.put(salas.get(i).getCodSala(), items);
		}
		return horarioMap;
	}
	
	public HorarioSala ConsultarHorarioSala() {
		HorarioSala horarioSala = new HorarioSala();
		for (int i = 0; i < listadoDeHorasPorFecha().size(); i++) {
			if (listadoDeHorasPorFecha().get(i).getCodigo() == codHorario) {
				horarioSala = listadoDeHorasPorFecha().get(i);
				break;
			}
		}
		return horarioSala;
	}
	
	public Sala ConsultarSala() {
		Sala sala = new Sala();
		for (int i = 0; i <  obtenerDatosSala().size(); i++) {
			if ( sala.getCodSala() == obtenerDatosSala().get(i).getCodSala()) {
				sala = obtenerDatosSala().get(i);
				break;
			}
		}
		return sala;
	}
	
	public void reservaDeSala(Reserva r ) {
		em.persist(r);
	}
	

}
