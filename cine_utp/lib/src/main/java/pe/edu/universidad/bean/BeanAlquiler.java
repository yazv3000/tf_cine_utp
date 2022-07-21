package pe.edu.universidad.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Sala;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanAlquiler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBGesionSala ejb;
	private List<Sala> lstSalas;
	private Date fechaDisponible;
	private Time hora; //privicional
	
	public BeanAlquiler() {
		fechaDisponible = new Date();
	}
	
	@PostConstruct
	public void inicializar() {
		lstSalas = ejb.obtenerDatosSala();
	}

	public List<SelectItem> FiltrarHorario(Sala s) {
		
		List<HorarioSala> horario = ejb.listadoDeHorasPorFecha();
		List<SelectItem> lst = new ArrayList<SelectItem>();
		for (HorarioSala horarioSala : horario) {
			if (horarioSala.getFecha().equals(fechaDisponible) && horarioSala.getCodSala() ==  s.getCodSala()) {
				SelectItem si = new SelectItem();
				si.setValue(horarioSala.getCodigo());
				si.setLabel(horarioSala.getHora().getHours()<10?"0"+horarioSala.getHora().getHours()+":00":horarioSala.getHora().getHours()+":00");
				lst.add(si);
//				System.out.println(horarioSala.getHora().getHours());
//				System.out.println(horarioSala.getFecha());
//				System.out.println(fechaDisponible);
			}
		}
		return lst;
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
	
	
	
}
