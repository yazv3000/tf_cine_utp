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
import javax.faces.model.SelectItem;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanDetalleAlquiler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBGesionSala ejb;
	private List<Sala> lstSalas;
	private Date fechaDisponible;
	private Time hora; 
	private Reserva reserva;
	private int codhora;
	//private List<SelectItem> lst;
	private Map<Integer, List<SelectItem>> horarioMap;
	
	public BeanDetalleAlquiler() {
		fechaDisponible = new Date();
		reserva = new Reserva();
	}
	
	@PostConstruct
	public void inicializar() {
		lstSalas = ejb.obtenerDatosSala();
		horarioMap = ejb.todosHorariosMap();
	}
	
	
	public List<SelectItem> FiltrarHorario(Sala s) {
		return horarioMap.get(s.getCodSala());
	}
//	public List<SelectItem> FiltrarHorario(Sala s) {
//		
//		List<HorarioSala> horario = ejb.listadoDeHorasPorFecha();
//		lst = new ArrayList<SelectItem>();
//		for (HorarioSala horarioSala : horario) {
//			if (horarioSala.getFecha().equals(fechaDisponible) && horarioSala.getCodSala() ==  s.getCodSala()) {
//				SelectItem si = new SelectItem();
//				
//				//System.out.println("Codigo Sala: "+ s.getCodSala()+" Codigodel Horario:" + horarioSala.getCodigo() );
//				si.setLabel(horarioSala.getHora().getHours()<10?"0"+horarioSala.getHora().getHours()+":00":horarioSala.getHora().getHours()+":00");
//				si.setValue(horarioSala.getCodigo());
//				lst.add(si);
//				
//			}
//		}
//		System.out.println("----- SALA: " + s.getCodSala());
//		for (SelectItem l : lst) {
//			System.out.println(l.getValue());
//		}
//		return lst;
//	}
	
	
	
	public void insertarReserva() {
		//System.out.println(reserva.getCodHorario()+ " <-------");
		System.out.println(codhora + " <-----------");
		ejb.reservaDeSala(reserva);
	}
	
	public String actulizarPagina() {
		return "Salas";
	}

	public List<Sala> getLstSalas() {
		return lstSalas;
	}

	public void setLstSalas(List<Sala> lstSalas) {
		this.lstSalas = lstSalas;
	}
	public Date getFechaDisponible() {
		return fechaDisponible;
	}

	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

//	public List<SelectItem> getLst() {
//		return lst;
//	}
//
//	public void setLst(List<SelectItem> lst) {
//		this.lst = lst;
//	}
	
	public int getCodhora() {
		return codhora;
	}

	public void setCodhora(int codhora) {
		this.codhora = codhora;
	}

	public Map<Integer, List<SelectItem>> getHorarioMap() {
		return horarioMap;
	}

	public void setHorarioMap(Map<Integer, List<SelectItem>> horarioMap) {
		this.horarioMap = horarioMap;
	}

}
