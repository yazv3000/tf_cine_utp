package pe.edu.universidad.dto;

import java.io.Serializable;

public class DtoEmpleadoNuevo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS
	private int cod_empleado; 
	private int cod_cargo;
	private String cargo;
	private String nom_emp_prin, nom_emp_sec, ape_emp_prin, ape_emp_sec;
	private String email_emp;
	private String direccion_emp;
	private double salario;
	private byte[] foto_emp;

	// CONSTRUCTOR POR DEFECTO
	public DtoEmpleadoNuevo() {};

	// GETTERs & SETTERs
	public int getCod_empleado() {		return cod_empleado;	}
	public void setCod_empleado(int cod_empleado) {		this.cod_empleado = cod_empleado;	}
	
	public int getCod_cargo() {	return cod_cargo;}
	public void setCod_cargo(int cod_cargo) {	this.cod_cargo = cod_cargo;	}
	
	public String getCargo() {return cargo;}
	public void setCargo(String cargo) {	this.cargo = cargo;	}
	
	public String getNom_emp_prin() {	return nom_emp_prin;}
	public void setNom_emp_prin(String nom_emp_prin) {	this.nom_emp_prin = nom_emp_prin;}

	public String getNom_emp_sec() {	return nom_emp_sec;	}
	public void setNom_emp_sec(String nom_emp_sec) {	this.nom_emp_sec = nom_emp_sec;}

	public String getApe_emp_prin() {	return ape_emp_prin;}
	public void setApe_emp_prin(String ape_emp_prin) {	this.ape_emp_prin = ape_emp_prin;}
	
	public String getApe_emp_sec() {	return ape_emp_sec;}
	public void setApe_emp_sec(String ape_emp_sec) {	this.ape_emp_sec = ape_emp_sec;}

	public String getEmail_emp() {		return email_emp;	}
	public void setEmail_emp(String email_emp) {		this.email_emp = email_emp;	}
	
	public String getDireccion_emp() {		return direccion_emp;	}
	public void setDireccion_emp(String direccion_emp) {		this.direccion_emp = direccion_emp;	}
	
	public double getSalario() {		return salario;	}
	public void setSalario(double salario) {		this.salario = salario;	}
	
	public byte[] getFoto_emp() {		return foto_emp;	}
	public void setFoto_emp(byte[] foto_emp) {		this.foto_emp = foto_emp;	}
}