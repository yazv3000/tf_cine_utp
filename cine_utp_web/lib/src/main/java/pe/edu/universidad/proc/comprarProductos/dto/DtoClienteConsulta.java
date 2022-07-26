package pe.edu.universidad.proc.comprarProductos.dto;

import java.io.Serializable;

public class DtoClienteConsulta  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codigo;
	private String nombreCompleto;
	private String dni;
	private String direccion;
	private String email;

	// Constructor
	public DtoClienteConsulta() {	}

	// Métodos Getter & Setter
	public int getCodigo() {		return codigo;	}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}

	public String getNombreCompleto() {		return nombreCompleto;	}
	public void setNombreCompleto(String nombreCompleto) {		this.nombreCompleto = nombreCompleto;	}

	public String getDni() {		return dni;	}
	public void setDni(String dni) {		this.dni = dni;	}

	public String getDireccion() {		return direccion;	}
	public void setDireccion(String direccion) {		this.direccion = direccion;	}

	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.email = email;	}
	
}