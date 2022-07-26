package pe.edu.universidad.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanSeleccionHorario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBGesionSala ejb;
	private List<SelectItem> lst;
	private Date fechaDisponible;	
	private int codSala;
	
	private Reserva reserva;
	
	
	public BeanSeleccionHorario() {
		reserva = new Reserva();
	}
	
	@PostConstruct
	public void inicializar() {
		FiltrarHorario();
	}
	

	public List<SelectItem> FiltrarHorario() {
		
		
		List<HorarioSala> horario = ejb.listadoDeHorasPorFecha();
		lst = new ArrayList<SelectItem>();
		for (HorarioSala horarioSala : horario) {
			if (horarioSala.getFecha().equals(fechaDisponible) && horarioSala.getCodSala() ==  codSala) {
				SelectItem si = new SelectItem();
				
				
				si.setLabel(horarioSala.getHora().getHours()<10?"0"+horarioSala.getHora().getHours()+":00":horarioSala.getHora().getHours()+":00");
				si.setValue(horarioSala.getCodigo());
				lst.add(si);
				
			}
		}
		
		for (SelectItem l : lst) {
			System.out.println(l.getValue() + " Hora" +  l.getLabel());
		}
		return lst;
	}
	
	public String actulizarPagina() {
		FiltrarHorario();
		return "SalaHorarios";
	}
	
	public String insertarReserva() {
		System.out.println("Hello ");
		System.out.println(reserva.getCodHorario() + " Codigo Horario <-------------");
		System.out.println(reserva.getNombres() + " Nombres <-------------");
		ejb.reservaDeSala(reserva);
		return "ResumenAlquiler";
	}
	
	public String siguientePagina() {
		return "ResumenAlquiler";
	}

	public List<SelectItem> getLst() {
		return lst;
	}

	public void setLst(List<SelectItem> lst) {
		this.lst = lst;
	}

	public Date getFechaDisponible() {
		return fechaDisponible;
	}

	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
