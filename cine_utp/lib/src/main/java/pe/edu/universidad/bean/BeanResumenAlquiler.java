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
import javax.inject.Inject;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.dto.DtoProductoConsulta;
import pe.edu.universidad.ejb.EJBCompraProducto;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanResumenAlquiler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBGesionSala ejb;
	//private Reserva reserva;
	private HorarioSala horarioSala;
	private Sala sala;
	
	public BeanResumenAlquiler() {
		//reserva = new Reserva();
		
	}
	
	@PostConstruct
	public void inicializar() {
		horarioSala = ejb.ConsultarHorarioSala();
		sala = ejb.ConsultarSala();
	}

//	public Reserva getReserva() {
//		return reserva;
//	}
//
//	public void setReserva(Reserva reserva) {
//		this.reserva = reserva;
//	}

	public HorarioSala getHorarioSala() {
		return horarioSala;
	}

	public void setHorarioSala(HorarioSala horarioSala) {
		this.horarioSala = horarioSala;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	
}
