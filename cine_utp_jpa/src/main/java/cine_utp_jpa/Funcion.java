package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the funcion database table.
 * 
 */
@Entity
@NamedQueries({ 
@NamedQuery(name="Funcion.findAll", query="SELECT f FROM Funcion f"),
@NamedQuery(name="Funcion.consultarCodigo", query="SELECT f FROM Funcion f where f.codFuncion = :number")
})
public class Funcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="seq_funciones") 
	@SequenceGenerator(name="seq_funciones",sequenceName="seq_funciones", allocationSize=1)
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

	private BigDecimal precio;

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

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}