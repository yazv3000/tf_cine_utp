package pe.edu.universidad.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Reserva;
import cine_utp_jpa.Sala;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanSeleccionSala implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBGesionSala ejb;
	private List<Sala> lstSalas;
	
	public BeanSeleccionSala() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		lstSalas = ejb.obtenerDatosSala();
		
	}
	
	
	
	public String siguientePagina() {
		return "SalaHorarios";
	}

	public List<Sala> getLstSalas() {
		return lstSalas;
	}

	public void setLstSalas(List<Sala> lstSalas) {
		this.lstSalas = lstSalas;
	}
	

}
