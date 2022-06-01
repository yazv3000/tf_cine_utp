package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the entrada database table.
 * 
 */
@Entity
@NamedQuery(name="Entrada.findAll", query="SELECT e FROM Entrada e")
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_ticket")
	private Integer codTicket;

	private String asiento;

	@Column(name="cod_cajero")
	private Integer codCajero;

	@Column(name="cod_cliente")
	private Integer codCliente;

	@Column(name="cod_funcion")
	private Integer codFuncion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	public Entrada() {
	}

	public Integer getCodTicket() {
		return this.codTicket;
	}

	public void setCodTicket(Integer codTicket) {
		this.codTicket = codTicket;
	}

	public String getAsiento() {
		return this.asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public Integer getCodCajero() {
		return this.codCajero;
	}

	public void setCodCajero(Integer codCajero) {
		this.codCajero = codCajero;
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodFuncion() {
		return this.codFuncion;
	}

	public void setCodFuncion(Integer codFuncion) {
		this.codFuncion = codFuncion;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

}