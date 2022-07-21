package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the entrada database table.
 * 
 */
@Entity
@NamedQueries({ 
@NamedQuery(name="Entrada.findAll", query="SELECT e FROM Entrada e"),
@NamedQuery(name="Entrada.findAsientosOcupados", query="SELECT e.asiento FROM Entrada e where e.funcion.codFuncion = :number")
})
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_ticket")
	@GeneratedValue(generator="seq_tickets") 
	@SequenceGenerator(name="seq_tickets",sequenceName="seq_tickets", allocationSize=1)
	private Integer codTicket;

	private int asiento;

	@Column(name="cod_cajero")
	private Integer codCajero;

	//bi-directional many-to-one association to Funcion
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

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

	public int getAsiento() {
		return this.asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public Integer getCodCajero() {
		return this.codCajero;
	}

	public void setCodCajero(Integer codCajero) {
		this.codCajero = codCajero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Funcion getFuncion() {
		return this.funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

}