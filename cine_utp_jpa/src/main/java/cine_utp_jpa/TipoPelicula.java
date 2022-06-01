package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_pelicula database table.
 * 
 */
@Entity
@Table(name="tipo_pelicula")
@NamedQuery(name="TipoPelicula.findAll", query="SELECT t FROM TipoPelicula t")
public class TipoPelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_tipopeli")
	private Integer codTipopeli;

	@Column(name="nom_tipopeli")
	private String nomTipopeli;

	public TipoPelicula() {
	}

	public Integer getCodTipopeli() {
		return this.codTipopeli;
	}

	public void setCodTipopeli(Integer codTipopeli) {
		this.codTipopeli = codTipopeli;
	}

	public String getNomTipopeli() {
		return this.nomTipopeli;
	}

	public void setNomTipopeli(String nomTipopeli) {
		this.nomTipopeli = nomTipopeli;
	}

}