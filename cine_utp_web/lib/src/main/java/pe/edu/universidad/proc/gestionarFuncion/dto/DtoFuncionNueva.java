package pe.edu.universidad.proc.gestionarFuncion.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoFuncionNueva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codPelicula;
	private int codSala;
	private Date fecha;
	private String hora;
	private double precio;

	// Constructor
	public DtoFuncionNueva() {}

	// Métodos Getter & Setter
	public int getCodPelicula() {		return codPelicula;	}
	public void setCodPelicula(int codPelicula) {		this.codPelicula = codPelicula;	}

	public int getCodSala() {		return codSala;	}
	public void setCodSala(int codSala) {		this.codSala = codSala;	}

	public Date getFecha() {		return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}

	public String getHora() {		return hora;	}
	public void setHora(String hora) {		this.hora = hora;	}

	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}
}