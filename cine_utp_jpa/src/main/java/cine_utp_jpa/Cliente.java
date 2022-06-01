package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_cliente")
	private Integer codCliente;

	@Column(name="ape_cl")
	private String apeCl;

	@Column(name="direccion_cl")
	private String direccionCl;

	@Column(name="dni_cl")
	private String dniCl;

	@Column(name="email_cl")
	private String emailCl;

	@Column(name="foto_cliente")
	private byte[] fotoCliente;

	@Column(name="nom_cl")
	private String nomCl;

	public Cliente() {
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getApeCl() {
		return this.apeCl;
	}

	public void setApeCl(String apeCl) {
		this.apeCl = apeCl;
	}

	public String getDireccionCl() {
		return this.direccionCl;
	}

	public void setDireccionCl(String direccionCl) {
		this.direccionCl = direccionCl;
	}

	public String getDniCl() {
		return this.dniCl;
	}

	public void setDniCl(String dniCl) {
		this.dniCl = dniCl;
	}

	public String getEmailCl() {
		return this.emailCl;
	}

	public void setEmailCl(String emailCl) {
		this.emailCl = emailCl;
	}

	public byte[] getFotoCliente() {
		return this.fotoCliente;
	}

	public void setFotoCliente(byte[] fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

	public String getNomCl() {
		return this.nomCl;
	}

	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}

}