package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the venta_producto database table.
 * 
 */
@Entity
@Table(name="venta_producto")
@NamedQuery(name="VentaProducto.findAll", query="SELECT v FROM VentaProducto v")
public class VentaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_venta")
	@GeneratedValue(generator="seq_ventas") 
	@SequenceGenerator(name="seq_ventas",sequenceName="seq_ventas", allocationSize=1)
	private Integer codVenta;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venta")
	private Date fechaVenta;

	@Column(name="monto_total")
	private BigDecimal montoTotal;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="cod_vendedor")
	private Empleado empleado;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="cod_producto")
	private Producto producto;

	public VentaProducto() {
	}

	public Integer getCodVenta() {
		return this.codVenta;
	}

	public void setCodVenta(Integer codVenta) {
		this.codVenta = codVenta;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public BigDecimal getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
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

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}