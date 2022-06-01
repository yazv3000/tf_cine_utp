package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the funcion database table.
 * 
 */
@Entity
@NamedQuery(name="Funcion.findAll", query="SELECT f FROM Funcion f")
public class Funcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_funcion")
	private Integer codFuncion;

	@Column(name="cod_pelicula")
	private Integer codPelicula;

	@Column(name="cod_sala")
	private Integer codSala;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_funcion")
	private Date fechaFuncion;

	@Column(name="hora_inicio")
	private Time horaInicio;

	public Funcion() {
	}

	public Integer getCodFuncion() {
		return this.codFuncion;
	}

	public void setCodFuncion(Integer codFuncion) {
		this.codFuncion = codFuncion;
	}

	public Integer getCodPelicula() {
		return this.codPelicula;
	}

	public void setCodPelicula(Integer codPelicula) {
		this.codPelicula = codPelicula;
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

}