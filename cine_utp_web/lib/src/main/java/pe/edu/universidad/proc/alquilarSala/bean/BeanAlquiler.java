package pe.edu.universidad.proc.alquilarSala.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.proc.alquilarSala.EJBAlquilarSala;

@Named
@SessionScoped
public class BeanAlquiler implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private EJBAlquilarSala ejb;

	public BeanAlquiler() {
		fechaDisponible = new Date();
		reserva = new Reserva();
	}

	@PostConstruct
	public void inicializar() {
		lstSalas = ejb.obtenerDatosSala();
	}

	public List<SelectItem> filtrarHorario(Sala s) {
		List<HorarioSala> horario = ejb.listadoDeHorariosPorFecha(fechaDisponible);
		List<SelectItem> itemsHorarios = new ArrayList<SelectItem>();
		
		for (HorarioSala horarioSala : horario) {
			if (horarioSala.getSala().getCodSala() ==  s.getCodSala()) {
				SelectItem si = new SelectItem();
				si.setLabel(horarioSala.getHora().getHours()<10?"0"+horarioSala.getHora().getHours()+":00":horarioSala.getHora().getHours()+":00");
				si.setValue(horarioSala.getCodigo());
				System.out.println("El código: "+horarioSala.getCodigo());
				itemsHorarios.add(si);
			}
		}
		return itemsHorarios;
	}

	public void insertarReserva() {
		System.out.println("ENRAS????????");
		reserva.setCodHorario(idHorarioSeleccionado);
		ejb.reservaDeSala(reserva);
		
	}

	public String actulizarPagina() {
		return "salas";
	}

	// Propiedades : atributo + getter & setter
	private List<Sala> lstSalas;
	public List<Sala> getLstSalas() {		return lstSalas;	}
	public void setLstSalas(List<Sala> lstSalas) {		this.lstSalas = lstSalas;	}

	private Reserva reserva;
	public Reserva getReserva() {	return reserva;	}
	public void setReserva(Reserva reserva) {		this.reserva = reserva;	}

	private Date fechaDisponible;
	public Date getFechaDisponible() {
		return fechaDisponible;
	}
	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	private int idHorarioSeleccionado;
	public int getIdHorarioSeleccionado() {
		return idHorarioSeleccionado;
	}
	public void setIdHorarioSeleccionado(int idHorarioSeleccionado) {
		this.idHorarioSeleccionado = idHorarioSeleccionado;
	}

}