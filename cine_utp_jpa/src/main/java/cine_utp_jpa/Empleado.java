package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_empleado") 
	@SequenceGenerator(name="seq_empleado",sequenceName="seq_empleado", allocationSize=1)
	@Column(name="cod_empleado")
	private Integer codEmpleado;

	@Column(name="ape_emp")
	private String apeEmp;

	@Column(name="cod_cargo")
	private Integer codCargo;

	@Column(name="direccion_emp")
	private String direccionEmp;

	@Column(name="email_emp")
	private String emailEmp;

	@Column(name="foto_emp")
	private byte[] fotoEmp;

	@Column(name="nom_emp")
	private String nomEmp;

	private BigDecimal salario;

	public Empleado() {
	}

	public Integer getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(Integer codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getApeEmp() {
		return this.apeEmp;
	}

	public void setApeEmp(String apeEmp) {
		this.apeEmp = apeEmp;
	}

	public Integer getCodCargo() {
		return this.codCargo;
	}

	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}

	public String getDireccionEmp() {
		return this.direccionEmp;
	}

	public void setDireccionEmp(String direccionEmp) {
		this.direccionEmp = direccionEmp;
	}

	public String getEmailEmp() {
		return this.emailEmp;
	}

	public void setEmailEmp(String emailEmp) {
		this.emailEmp = emailEmp;
	}

	public byte[] getFotoEmp() {
		return this.fotoEmp;
	}

	public void setFotoEmp(byte[] fotoEmp) {
		this.fotoEmp = fotoEmp;
	}

	public String getNomEmp() {
		return this.nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}