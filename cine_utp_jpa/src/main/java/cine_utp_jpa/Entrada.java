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

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="cod_cajero")
	private Empleado empleado;

	//bi-directional many-to-one association to Funcion
	@ManyToOne
	@JoinColumn(name="cod_funcion")
	private Funcion funcion;

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

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Funcion getFuncion() {
		return this.funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

}