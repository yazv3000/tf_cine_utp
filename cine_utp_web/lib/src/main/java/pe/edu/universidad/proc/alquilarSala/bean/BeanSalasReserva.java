package pe.edu.universidad.proc.alquilarSala.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import cine_utp_jpa.Sala;
import pe.edu.universidad.proc.alquilarSala.EJBAlquilarSala;

@Named						// objeto nombrado
@SessionScoped			// alcance
public class BeanSalasReserva implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBAlquilarSala ejb;

	@Inject
	private BeanAlquilerSala beanAlquilerSala;
	
	public BeanSalasReserva() {	}
	
	@PostConstruct
	public void inicializar() {
		lstSalas = ejb.listarSalasTodos();
	}
	
	public String siguientePagina() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	int salaId = Integer.parseInt(map.get("salaId"));
    	System.out.println("Se ha seleccionado la sala: "+salaId);
    	beanAlquilerSala.setCodSala(salaId);
		return "horariosSala";
	}

	// Propiedades
	private List<Sala> lstSalas;
	public List<Sala> getLstSalas() {		return lstSalas;	}
	public void setLstSalas(List<Sala> lstSalas) {		this.lstSalas = lstSalas;	}
	
}
