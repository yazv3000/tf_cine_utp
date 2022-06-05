package pe.edu.universidad.dto;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DtoFuncionConsulta {
	
    private int codFuncion;
	private String nomPeli;
	private int sala;
	private String horaInicio;
	private double precio;
	private Date fecha;
	
	
	public int getCodFuncion() {		return codFuncion;	}
	public void setCodFuncion(int codFuncion) {		this.codFuncion = codFuncion;	}

	public String getNomPeli() {		return nomPeli;	}
	public void setNomPeli(String nomPeli) {		this.nomPeli = nomPeli;	}

	public int getSala() {		return sala;	}
	public void setSala(int sala) {		this.sala = sala;	}

	public String getHoraInicio() {		return horaInicio;	}
	public void setHoraInicio(Time horaInicio) {        
        DateFormat format = new SimpleDateFormat("HH:mm");
		this.horaInicio = format.format(horaInicio.getTime());
	}
    
	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}

	public Date getFecha() {	return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}
	
	
}
