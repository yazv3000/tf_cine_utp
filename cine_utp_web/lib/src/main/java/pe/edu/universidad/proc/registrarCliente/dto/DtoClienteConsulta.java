package pe.edu.universidad.proc.registrarCliente.dto;

import java.io.Serializable;

public class DtoClienteConsulta implements Serializable{
	
		private static final long serialVersionUID = 1L;
		// ATRIBUTOS
		private int idCliente;
		private String nombreCompleto;
		private String dni;
		private String direccion;
		private String email;
		//CONSTRUCTORES
		public DtoClienteConsulta() {	}
		public DtoClienteConsulta(int idCliente, String nombreCompleto, String direccion, String email) {
			this.idCliente = idCliente;
			this.nombreCompleto = nombreCompleto;
			this.direccion = direccion;
			this.email = email;
		}
		
		// METODOS GETTER & SETTER
		public int getIdCliente() {return idCliente;	}
		public void setIdCliente(int idCliente) {		this.idCliente = idCliente;	}
			
		public String getNombreCompleto() { return nombreCompleto;	}
		public void setNombreCompleto(String nombreCompleto) {		this.nombreCompleto = nombreCompleto;	}
		
		public String getDni() {	return dni;}
		public void setDni(String dni) {	this.dni = dni;}
		
		public String getDireccion() {		return direccion;	}
		public void setDireccion(String direccion) {		this.direccion = direccion;	}
		
		public String getEmail() {		return email;	}
		public void setEmail(String email) {		this.email = email;	}
}
