package pe.edu.universidad.proc.comprarTicket.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoTicketNuevo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codCliente;
	private int codFuncion;
	private int codCajero;
	private Date fechaCompra;
	private int asiento;
	
	// Constructor
	public DtoTicketNuevo() {	
		this.codCajero = 0;
		this.fechaCompra = new Date();
	}

	// Métodos Getter & Setter
	public int getCodCliente() {		return codCliente;	}
	public void setCodCliente(int codCliente) {		this.codCliente = codCliente;	}

	public int getCodFuncion() {		return codFuncion;	}
	public void setCodFuncion(int codFuncion) {		this.codFuncion = codFuncion;	}

	public int getCodCajero() {		return codCajero;	}
	public void setCodCajero(int codCajero) {		this.codCajero = codCajero;	}

	public Date getFechaCompra() {		return fechaCompra;	}
	public void setFechaCompra(Date fechaCompra) {		this.fechaCompra = fechaCompra;	}

	public int getAsiento() {		return asiento;	}
	public void setAsiento(int asiento) {		this.asiento = asiento;	}
	
}