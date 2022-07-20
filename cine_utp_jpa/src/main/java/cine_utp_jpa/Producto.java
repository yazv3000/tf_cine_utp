package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
@NamedQueries({ 
@NamedQuery(name="Producto.unitarios", query="SELECT p FROM Producto p where p.tipo='unitario'"),
@NamedQuery(name="Producto.combos", query="SELECT p FROM Producto p where p.tipo='combo'"),
@NamedQuery(name="Producto.precio", query="SELECT p.precio FROM Producto p where p.codProducto = :number")
})
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_producto")
	private Integer codProducto;

	private String nombre;

	private Integer precio;

	private String tipo;

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

}