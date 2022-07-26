package pe.edu.universidad.dto;

import java.io.Serializable;

public class DtoProductoConsulta implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	private int codProducto;
	private String nombre;
	private String tipo;
	private double precio;
	
	// Constructor
	public DtoProductoConsulta () { }
	
	// Métodos Getter & Setter
	public int getCodProducto() {		return codProducto;	}
	public void setCodProducto(int codProducto) {		this.codProducto = codProducto;	}

	public String getNombre() {		return nombre;	}
	public void setNombre(String nombre) {		this.nombre = nombre;	}

	public String getTipo() {		return tipo;	}
	public void setTipo(String tipo) {		this.tipo = tipo;	}

	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}
	
}