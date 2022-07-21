package cine_utp_jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_sala")
	private Integer codSala;

	private Integer capacidad;

	//bi-directional many-to-one association to AlquilerSala
	@OneToMany(mappedBy="sala")
	private List<AlquilerSala> alquilerSalas;

	//bi-directional many-to-one association to HorarioSala
	@OneToMany(mappedBy="sala")
	private List<HorarioSala> horarioSalas;

	public Sala() {
	}

	public Integer getCodSala() {
		return this.codSala;
	}

	public void setCodSala(Integer codSala) {
		this.codSala = codSala;
	}

	public Integer getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public List<AlquilerSala> getAlquilerSalas() {
		return this.alquilerSalas;
	}

	public void setAlquilerSalas(List<AlquilerSala> alquilerSalas) {
		this.alquilerSalas = alquilerSalas;
	}

	public AlquilerSala addAlquilerSala(AlquilerSala alquilerSala) {
		getAlquilerSalas().add(alquilerSala);
		alquilerSala.setSala(this);

		return alquilerSala;
	}

	public AlquilerSala removeAlquilerSala(AlquilerSala alquilerSala) {
		getAlquilerSalas().remove(alquilerSala);
		alquilerSala.setSala(null);

		return alquilerSala;
	}

	public List<HorarioSala> getHorarioSalas() {
		return this.horarioSalas;
	}

	public void setHorarioSalas(List<HorarioSala> horarioSalas) {
		this.horarioSalas = horarioSalas;
	}

	public HorarioSala addHorarioSala(HorarioSala horarioSala) {
		getHorarioSalas().add(horarioSala);
		horarioSala.setSala(this);

		return horarioSala;
	}

	public HorarioSala removeHorarioSala(HorarioSala horarioSala) {
		getHorarioSalas().remove(horarioSala);
		horarioSala.setSala(null);

		return horarioSala;
	}

}