package pe.edu.universidad.proc.comprarTicket.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarTicket.EJBComprarTicket;
import pe.edu.universidad.proc.comprarTicket.dto.DtoClienteConsulta;
import pe.edu.universidad.proc.comprarTicket.dto.DtoFuncionConsulta;
import pe.edu.universidad.proc.comprarTicket.dto.DtoTicketNuevo;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanCompraTicket implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarTicket ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanEntrada beanEntrada;
	
	public BeanCompraTicket() {}
	
	public String cargarDetalle() {
		return "registroTicket";
	}
	
	public String confirmarCompra() {
		DtoTicketNuevo ticket = new DtoTicketNuevo();
		ticket.setCodCliente(cliente.getCodigo());
		ticket.setCodFuncion(funcion.getCodFuncion());
		ticket.setAsiento(asiento);
		ejb.registrarTicket(ticket);
		System.out.println("Compra exitosa");
		beanEntrada.inicializar();
		return "entradasVendidas";
	}
	
	// Propiedades : atributo + getter & setter
	private DtoClienteConsulta cliente;
	public DtoClienteConsulta getCliente() {		return cliente;	}
	public void setCliente(DtoClienteConsulta cliente) {
		this.cliente = cliente;
	}
	
	private DtoFuncionConsulta funcion; 
	public DtoFuncionConsulta getFuncion() {		return funcion;	}
	public void setFuncion(DtoFuncionConsulta funcion) {
		this.funcion = funcion;
	}

	private int asiento;
	public int getAsiento() {		return asiento;	}
	public void setAsiento(int asiento) {		this.asiento = asiento;	}
	
}
