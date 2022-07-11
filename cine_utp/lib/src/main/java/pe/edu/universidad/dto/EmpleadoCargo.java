package pe.edu.universidad.dto;

import java.io.Serializable;

public class EmpleadoCargo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//ATRIBUTOS
	private int idEmpleadoCargo;
	private String nombreCargo;
	
	//CONSTRUCTOR
	public EmpleadoCargo() {}

	public int getIdEmpleadoCargo() {	return idEmpleadoCargo;}
	public void setIdEmpleadoCargo(int idEmpleadoCargo) {	this.idEmpleadoCargo = idEmpleadoCargo;	}

	public String getNombreCargo() {return nombreCargo;	}
	public void setNombreCargo(String nombreCargo) {this.nombreCargo = nombreCargo;	}
	
}
