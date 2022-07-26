package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_producto")
	private Integer codProducto;

	private String nombre;

	private Integer precio;

	private String tipo;

	//bi-directional many-to-one association to VentaProducto
	@OneToMany(mappedBy="producto")
	private List<VentaProducto> ventaProductos;

	public Producto() {
	}

	public Integer getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<VentaProducto> getVentaProductos() {
		return this.ventaProductos;
	}

	public void setVentaProductos(List<VentaProducto> ventaProductos) {
		this.ventaProductos = ventaProductos;
	}

	public VentaProducto addVentaProducto(VentaProducto ventaProducto) {
		getVentaProductos().add(ventaProducto);
		ventaProducto.setProducto(this);

		return ventaProducto;
	}

	public VentaProducto removeVentaProducto(VentaProducto ventaProducto) {
		getVentaProductos().remove(ventaProducto);
		ventaProducto.setProducto(null);

		return ventaProducto;
	}

}