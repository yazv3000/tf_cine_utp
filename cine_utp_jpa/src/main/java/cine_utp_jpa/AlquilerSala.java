package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the alquiler_sala database table.
 * 
 */
@Entity
@Table(name="alquiler_sala")
@NamedQuery(name="AlquilerSala.findAll", query="SELECT a FROM AlquilerSala a")
public class AlquilerSala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_alquiler")
	private Integer codAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	@Column(name="hora_inicio")
	private Time horaInicio;

	private BigDecimal precio;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="cod_sala")
	private Sala sala;

	public AlquilerSala() {
	}

	public Integer getCodAlquiler() {
		return this.codAlquiler;
	}

	public void setCodAlquiler(Integer codAlquiler) {
		this.codAlquiler = codAlquiler;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
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

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}