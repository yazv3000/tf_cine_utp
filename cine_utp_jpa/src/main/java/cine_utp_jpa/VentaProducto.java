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
	@GeneratedValue(generator="seq_venta") 
	@SequenceGenerator(name="seq_venta",sequenceName="seq_venta", allocationSize=1)
	@Column(name="cod_venta")
	private Integer codVenta;

	private Integer cantidad;

	@Column(name="cod_cliente")
	private Integer codCliente;

	@Column(name="cod_producto")
	private Integer codProducto;

	@Column(name="cod_vendedor")
	private Integer codVendedor;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venta")
	private Date fechaVenta;

	@Column(name="monto_total")
	private BigDecimal montoTotal;

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

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	public Integer getCodVendedor() {
		return this.codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
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

}