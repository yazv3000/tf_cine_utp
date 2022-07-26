package pe.edu.universidad.proc.alquilarSala.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import pe.edu.universidad.proc.alquilarSala.EJBAlquilarSala;

@Named						// objeto nombrado
@SessionScoped			// alcance
public class BeanAlquilerSala implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBAlquilarSala ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)

	public BeanAlquilerSala() {	
		reserva = new Reserva();
	}
	
	// Propiedades
	private int codSala;
	public int getCodSala() {		return codSala;	}
	public void setCodSala(int codSala) {		this.codSala = codSala;	}

	private Reserva reserva;
	public Reserva getReserva() {	return reserva;	}
	public void setReserva(Reserva reserva) {		this.reserva = reserva;	}
	
	private HorarioSala horario;
	public HorarioSala getHorario() {		return horario;	}
	public void setHorario(HorarioSala horario) {		this.horario = horario;	}
	
}
