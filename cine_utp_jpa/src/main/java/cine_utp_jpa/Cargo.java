package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="cod_cargo")
	@SequenceGenerator(name="cod_cargo",sequenceName="cod_cargo", allocationSize=1)
	@Column(name="cod_cargo")
	private Integer codCargo;

	@Column(name="nom_cargo")
	private String nomCargo;

	public Cargo() {
	}

	public Integer getCodCargo() {
		return this.codCargo;
	}

	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}

	public String getNomCargo() {
		return this.nomCargo;
	}

	public void setNomCargo(String nomCargo) {
		this.nomCargo = nomCargo;
	}

}