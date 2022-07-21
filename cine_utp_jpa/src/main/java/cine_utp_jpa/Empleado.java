package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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

	//bi-directional many-to-one association to VentaProducto
	@OneToMany(mappedBy="empleado")
	private List<VentaProducto> ventaProductos;

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

	public List<VentaProducto> getVentaProductos() {
		return this.ventaProductos;
	}

	public void setVentaProductos(List<VentaProducto> ventaProductos) {
		this.ventaProductos = ventaProductos;
	}

	public VentaProducto addVentaProducto(VentaProducto ventaProducto) {
		getVentaProductos().add(ventaProducto);
		ventaProducto.setEmpleado(this);

		return ventaProducto;
	}

	public VentaProducto removeVentaProducto(VentaProducto ventaProducto) {
		getVentaProductos().remove(ventaProducto);
		ventaProducto.setEmpleado(null);

		return ventaProducto;
	}

}