package pe.edu.universidad.proc.alquilarSala.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cine_utp_jpa.Reserva;
import pe.edu.universidad.proc.alquilarSala.EJBAlquilarSala;
import pe.edu.universidad.proc.alquilarSala.dto.DtoReservaCliente;

@Named
@SessionScoped
public class BeanClienteReserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBAlquilarSala ejb;
	
	@Inject
	private BeanAlquilerSala beanAlquilerSala;
	

	public BeanClienteReserva() { 
		dtoReservaCliente = new DtoReservaCliente();
	}
	
	public String irASalasDisponibles() {
		
		Reserva reserva = beanAlquilerSala.getReserva();
		reserva.setNombres(dtoReservaCliente.getNombres());
		reserva.setApellidos(dtoReservaCliente.getApellidos());
		reserva.setDni(dtoReservaCliente.getDni());
		reserva.setCorreo(dtoReservaCliente.getCorreo());
		reserva.setTelefono(dtoReservaCliente.getTelefono());
		beanAlquilerSala.setReserva(reserva);
		return "salasDisponibles";	
	}
	
	// Propiedades
	private DtoReservaCliente dtoReservaCliente;
	public DtoReservaCliente getDtoReservaCliente() {		
		return dtoReservaCliente;
	}
	public void setDtoReservaCliente(DtoReservaCliente dtoReservaCliente) {
		this.dtoReservaCliente = dtoReservaCliente;
	}
}
