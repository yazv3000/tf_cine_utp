package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c")
public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_calific")
	private String codCalific;

	@Column(name="descr_calific")
	private String descrCalific;

	public Calificacion() {
	}

	public String getCodCalific() {
		return this.codCalific;
	}

	public void setCodCalific(String codCalific) {
		this.codCalific = codCalific;
	}

	public String getDescrCalific() {
		return this.descrCalific;
	}

	public void setDescrCalific(String descrCalific) {
		this.descrCalific = descrCalific;
	}

}