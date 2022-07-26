package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the horario_sala database table.
 * 
 */
@Entity
@Table(name="horario_sala")
@NamedQuery(name="HorarioSala.findAll", query="SELECT h FROM HorarioSala h")
public class HorarioSala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codigo;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	private BigDecimal precio;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="cod_sala")
	private Sala sala;

	public HorarioSala() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
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