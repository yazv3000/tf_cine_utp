package pe.edu.universidad.proc.comprarTicket.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoTicketConsulta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codTicket;
	private String nombreCliente;
	private int codFuncion;
	private String nombrePelicula;
	private String sala;
	private Date fechaFuncion;
	private Date fechaCompra;
	private int asiento;
	
	// Constructor
	public DtoTicketConsulta() {	}

	// Métodos Getter & Setter
	public int getCodTicket() {		return codTicket;	}
	public void setCodTicket(int codTicket) {		this.codTicket = codTicket;	}
	
	public int getCodFuncion() {		return codFuncion;	}
	public void setCodFuncion(int codFuncion) {		this.codFuncion = codFuncion;	}
	
	public String getNombrePelicula() {		return nombrePelicula;	}
	public void setNombrePelicula(String nombrePelicula) {		this.nombrePelicula = nombrePelicula;	}

	public String getSala() {		return sala;	}
	public void setSala(String sala) {		this.sala = sala;	}

	public int getAsiento() {		return asiento;	}
	public void setAsiento(int i) {		this.asiento = i;	}
	
	public String getNombreCliente() {		return nombreCliente;	}
	public void setNombreCliente(String nombreCliente) {		this.nombreCliente = nombreCliente;	}
	
	public Date getFechaFuncion() {		return fechaFuncion;	}
	public void setFechaFuncion(Date fechaFuncion) {		this.fechaFuncion = fechaFuncion;	}

	public Date getFechaCompra() {		return fechaCompra;	}
	public void setFechaCompra(Date fechaCompra) {		this.fechaCompra = fechaCompra;	}
	
}