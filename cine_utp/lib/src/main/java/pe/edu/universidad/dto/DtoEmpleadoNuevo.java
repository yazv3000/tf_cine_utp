package pe.edu.universidad.dto;

public class DtoEmpleadoNuevo {
	// ATRIBUTOS
	private int cod_empleado; 
	private int cod_cargo;
	private String cargo;
	private String nom_emp_Prin, nom_emp_Sec, ape_emp_Prin, ape_emp_Sec;
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
	
	public String getNom_emp_Prin() {	return nom_emp_Prin;}
	public void setNom_emp_Prin(String nom_emp_Prin) {this.nom_emp_Prin = nom_emp_Prin;}
	
	public String getNom_emp_Sec() {	return nom_emp_Sec;}
	public void setNom_emp_Sec(String nom_emp_Sec) {this.nom_emp_Sec = nom_emp_Sec;}

	public String getApe_emp_Prin() {	return ape_emp_Prin;}
	public void setApe_emp_Prin(String ape_emp_Prin) {	this.ape_emp_Prin = ape_emp_Prin;}
	
	public String getApe_emp_Sec() {	return ape_emp_Sec;}
	public void setApe_emp_Sec(String ape_emp_Sec) {	this.ape_emp_Sec = ape_emp_Sec;}

	public String getEmail_emp() {		return email_emp;	}
	public void setEmail_emp(String email_emp) {		this.email_emp = email_emp;	}
	
	public String getDireccion_emp() {		return direccion_emp;	}
	public void setDireccion_emp(String direccion_emp) {		this.direccion_emp = direccion_emp;	}
	
	public double getSalario() {		return salario;	}
	public void setSalario(double salario) {		this.salario = salario;	}
	
	public byte[] getFoto_emp() {		return foto_emp;	}
	public void setFoto_emp(byte[] foto_emp) {		this.foto_emp = foto_emp;	}
}