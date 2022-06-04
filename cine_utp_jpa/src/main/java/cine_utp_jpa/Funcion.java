package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the funcion database table.
 * 
 */
@Entity
@Table(name="funcion")
@NamedQueries({ 
@NamedQuery(name="Funcion.findAll", query="SELECT f FROM Funcion f"),
@NamedQuery(name="Funcion.consultarNombreCodigo", query="SELECT f FROM Funcion f ")
})

public class Funcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_funcion")
	private Integer codFuncion;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="cod_pelicula")
	private Pelicula pelicula;

	@Column(name="cod_sala")
	private Integer codSala;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_funcion")
	private Date fechaFuncion;

	@Column(name="hora_inicio")
	private Time horaInicio;

	@Column(name="precio")
	private BigDecimal precio;


	public Funcion() {
	}

	public Integer getCodFuncion() {
		return this.codFuncion;
	}

	public void setCodFuncion(Integer codFuncion) {
		this.codFuncion = codFuncion;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	public Integer getCodSala() {
		return this.codSala;
	}

	public void setCodSala(Integer codSala) {
		this.codSala = codSala;
	}

	public Date getFechaFuncion() {
		return this.fechaFuncion;
	}

	public void setFechaFuncion(Date fechaFuncion) {
		this.fechaFuncion = fechaFuncion;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


}