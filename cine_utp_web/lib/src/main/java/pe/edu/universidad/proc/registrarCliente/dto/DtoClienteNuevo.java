package pe.edu.universidad.proc.registrarCliente.dto;

import java.io.Serializable;


public class DtoClienteNuevo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomCliePrin;
	private String nomClieSec;
	private String apeCliePrin;
	private String apeClieSec;
	private String correo;
	private String direccion;
	private String dni;

	public String getNomCliePrin() {	return nomCliePrin;}
	public void setNomCliePrin(String nomCliePrin) {	this.nomCliePrin = nomCliePrin;}
	
	public String getNomClieSec() {	return nomClieSec;}
	public void setNomClieSec(String nomClieSec) {	this.nomClieSec = nomClieSec;}
	
	public String getApeCliePrin() {	return apeCliePrin;}
	public void setApeCliePrin(String apeCliePrin) {	this.apeCliePrin = apeCliePrin;}
	
	public String getApeClieSec() {	return apeClieSec;}
	public void setApeClieSec(String apeClieSec) {	this.apeClieSec = apeClieSec;}
	
	public String getCorreo() {	return correo;	}
	public void setCorreo(String correo) {		this.correo = correo;	}
	
	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
	public String getDni() {		return dni;	}
	public void setDni(String dni) {		this.dni = dni;	}
}
