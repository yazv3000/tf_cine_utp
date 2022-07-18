package pe.edu.universidad.dto;

import java.io.Serializable;

import javax.persistence.Id;

public class DtoPelicula implements Serializable{
	
	private int Id;
	private String nombre;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
