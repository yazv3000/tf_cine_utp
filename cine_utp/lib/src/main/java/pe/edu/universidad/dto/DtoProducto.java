package pe.edu.universidad.dto;

import java.io.Serializable;

public class DtoProducto implements Serializable{
	private int codProducto;

	private String nombre;

	private Integer precio;

	private String tipo;

	public DtoProducto() {	}

	public int getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(int codProducto) {
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
