package cine_utp_jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the pelicula database table.
 * 
 */
@Entity
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_pelicula")
	private Integer codPelicula;

	@Column(name="cod_calific")
	private String codCalific;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="cod_tipopeli")
	private TipoPelicula tipopeli;

	private String descripcion;

	private Integer duracion;

	@Column(name="nom_peli")
	private String nomPeli;

	private byte[] poster;

	
	public Pelicula() {
	}

	public Integer getCodPelicula() {
		return this.codPelicula;
	}

	public void setCodPelicula(Integer codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getCodCalific() {
		return this.codCalific;
	}

	public void setCodCalific(String codCalific) {
		this.codCalific = codCalific;
	}

	public TipoPelicula getTipopeli() {
		return tipopeli;
	}

	public void setTipopeli(TipoPelicula tipopeli) {
		this.tipopeli = tipopeli;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getNomPeli() {
		return this.nomPeli;
	}

	public void setNomPeli(String nomPeli) {
		this.nomPeli = nomPeli;
	}

	public byte[] getPoster() {
		return this.poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

}