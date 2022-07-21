package pe.edu.universidad.proc.comprarTicket.dto;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DtoFuncionConsulta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codFuncion;
	private String nombrePelicula;
	private String sala;
	private Date fecha;
	private String hora;
	private double precio;

	// Constructor
	public DtoFuncionConsulta() {}

	// Métodos Getter & Setter
	public int getCodFuncion() {		return codFuncion;	}
	public void setCodFuncion(int codFuncion) {		this.codFuncion = codFuncion;	}

	public String getNombrePelicula() {		return nombrePelicula;	}
	public void setNombrePelicula(String nombrePelicula) {		this.nombrePelicula = nombrePelicula;	}

	public String getSala() {		return sala;	}
	public void setSala(String sala) {		this.sala = sala;	}

	public Date getFecha() {		return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}

	public String getHora() {		return hora;	}
	public void setHora(Time horaInicio) {        
        DateFormat format = new SimpleDateFormat("HH:mm");
		this.hora = format.format(horaInicio.getTime());
	}
	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}
}