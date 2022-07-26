package pe.edu.universidad.proc.registrarCliente.bean;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.proc.registrarCliente.EJBCliente;
import pe.edu.universidad.proc.registrarCliente.dto.DtoClienteNuevo;

@Named						// objeto nombrado
@SessionScoped			// alcance
public class BeanClienteNuevo implements Serializable{

	private static final long serialVersionUID = 1L;


	//ENTIDADES
	private DtoClienteNuevo dtoClienteNuevo;
	
	
	@EJB
	private EJBCliente ejb;
	public BeanClienteNuevo () {
		dtoClienteNuevo = new DtoClienteNuevo();
	}
	
	@PostConstruct
	public void inicializar() {
		
	}
	public String guardarCliente() {
		ejb.registrarCliente(dtoClienteNuevo);
		return "clienteTicket";
	}

	public DtoClienteNuevo getDtoClienteNuevo() {	return dtoClienteNuevo;}
	public void setDtoClienteNuevo(DtoClienteNuevo dtoClienteNuevo) {	this.dtoClienteNuevo = dtoClienteNuevo;}

}
