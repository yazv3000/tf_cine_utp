package pe.edu.universidad.dto;

public class DtoClienteNuevo {

	private String nomCliePrin;
	private String nomClieSec;
	private String apeClie;
	private String correo;
	private String direccion;
	private String dni;

	public String getNomCliePrin() {	return nomCliePrin;}
	public void setNomCliePrin(String nomCliePrin) {	this.nomCliePrin = nomCliePrin;}
	
	public String getNomClieSec() {	return nomClieSec;}
	public void setNomClieSec(String nomClieSec) {	this.nomClieSec = nomClieSec;}
	public String getApeClie() {		return apeClie;	}
	public void setApeClie(String apeClie) {		this.apeClie = apeClie;	}
	
	public String getCorreo() {	return correo;	}
	public void setCorreo(String correo) {		this.correo = correo;	}
	
	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}
	
	public String getDni() {		return dni;	}
	public void setDni(String dni) {		this.dni = dni;	}
	
}
