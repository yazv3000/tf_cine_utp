package pe.edu.universidad.entidades;

public class Empleado {

	// ATRIBUTOS
	private int cod_empleado; //, cod_cargo;
	private String cargo;
	private String nom_emp, ape_emp;
	private String email_emp;
	private String direccion_emp;
	private double salario;
	private byte[] foto_emp;
	
	// CONSTRUCTOR POR DEFECTO
	public Empleado() {};
	
	// GETTERs & SETTERs
	public int getCod_empleado() {		return cod_empleado;	}
	public void setCod_empleado(int cod_empleado) {		this.cod_empleado = cod_empleado;	}
	
	/*public int getCod_cargo() {		return cod_cargo;	}
	public void setCod_cargo(int cod_cargo) {		this.cod_cargo = cod_cargo;	}
	*/
	
	public String getCargo() {return cargo;}
	public void setCargo(String cargo) {		this.cargo = cargo;	}

	public String getNom_emp() {		return nom_emp;	}
	public void setNom_emp(String nom_emp) {		this.nom_emp = nom_emp;	}
	
	public String getApe_emp() {		return ape_emp;	}
	public void setApe_emp(String ape_emp) {		this.ape_emp = ape_emp;	}
	
	public String getEmail_emp() {		return email_emp;	}
	public void setEmail_emp(String email_emp) {		this.email_emp = email_emp;	}
	
	public String getDireccion_emp() {		return direccion_emp;	}
	public void setDireccion_emp(String direccion_emp) {		this.direccion_emp = direccion_emp;	}
	
	public double getSalario() {		return salario;	}
	public void setSalario(double salario) {		this.salario = salario;	}
	
	public byte[] getFoto_emp() {		return foto_emp;	}
	public void setFoto_emp(byte[] foto_emp) {		this.foto_emp = foto_emp;	}

}
