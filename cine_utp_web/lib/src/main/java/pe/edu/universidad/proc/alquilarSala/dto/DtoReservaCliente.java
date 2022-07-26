package pe.edu.universidad.proc.alquilarSala.dto;

import java.io.Serializable;

public class DtoReservaCliente implements Serializable{
	
	private String nombres;
	private String apellidos;
	private String dni;
	private String Telefono;
	private String correo;
	
	public String getNombres() {		return nombres;	}
	public void setNombres(String nombres) {		this.nombres = nombres;	}
	
	public String getApellidos() {		return apellidos;	}
	public void setApellidos(String apellidos) {		this.apellidos = apellidos;	}
	
	public String getDni() {		return dni;	}
	public void setDni(String dni) {		this.dni = dni;	}
	
	public String getTelefono() {		return Telefono;	}
	public void setTelefono(String telefono) {		Telefono = telefono;	}
	
	public String getCorreo() {		return correo;	}
	public void setCorreo(String correo) {		this.correo = correo;	}
	
}