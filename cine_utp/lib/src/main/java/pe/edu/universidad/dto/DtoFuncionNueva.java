package pe.edu.universidad.dto;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cine_utp_jpa.Pelicula;



public class DtoFuncionNueva {
	private int codFuncion;
	private Pelicula peli;
	private int codSala;
	private Time horaInicio;
	private double precio;
	private Date fecha;
	
	
	public int getCodFuncion() {		return codFuncion;	}
	public void setCodFuncion(int codFuncion) {		this.codFuncion = codFuncion;	}

	public Pelicula getPeli() {	return peli;}
	public void setPeli(Pelicula peli) {	this.peli = peli;}

	public int getCodSala() {		return codSala;	}
	public void setCodSala(int codSala) {		this.codSala = codSala;	}

	public Time getHoraInicio() {		return horaInicio;	}
	public void setHoraInicio(String horaInicio) {        
		Time time = Time.valueOf(horaInicio);
		this.horaInicio = time;
	}
    
	public double getPrecio() {		return precio;	}
	public void setPrecio(double precio) {		this.precio = precio;	}

	public Date getFecha() {	return fecha;	}
	public void setFecha(String fecha) {		
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd");
	    try {
			Date result = sdt.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
