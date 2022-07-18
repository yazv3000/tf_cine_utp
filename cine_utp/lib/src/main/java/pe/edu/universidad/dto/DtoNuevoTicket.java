package pe.edu.universidad.dto;

import java.util.Date;

public class DtoNuevoTicket {

	private int codCliente;
	private int codFuncion;
	private int codCajero;
	private Date fechaCompra;
	private String asiento;
	
	public DtoNuevoTicket() {	
		this.codCajero = 0;
		this.fechaCompra = new Date();
		this.asiento = "A001";
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodFuncion() {
		return codFuncion;
	}

	public void setCodFuncion(int codFuncion) {
		this.codFuncion = codFuncion;
	}

	public int getCodCajero() {
		return codCajero;
	}

	public void setCodCajero(int codCajero) {
		this.codCajero = codCajero;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	
	
}
