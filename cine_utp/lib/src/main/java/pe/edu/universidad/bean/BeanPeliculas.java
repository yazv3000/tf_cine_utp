package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoPelicula;
import pe.edu.universidad.ejb.EJBGestionarFunciones;

@Named
@SessionScoped
public class BeanPeliculas implements Serializable {
	private String cadenaPelicula;
	
	private List<DtoPelicula> lstPelicula;
	
	@EJB
	private EJBGestionarFunciones ejb;
	
	@Inject
	private BeanFuncion beanFuncion;
	
	
	public BeanPeliculas() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		//lstPelicula = ejb.consultarPeliculasTodos();
	}
	
	public void consultarPeliculas() {
		lstPelicula = ejb.consultarPeliculasPorNombre(cadenaPelicula);
	}
	
	public String irNuevaFuncion() {
		Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int idPelicula = Integer.parseInt(map.get("peliculaId"));
		return beanFuncion.cargarPelicula(idPelicula);
	}
	
	public List<DtoPelicula> getLstPelicula() {
		return lstPelicula;
	}

	public void setLstPelicula(List<DtoPelicula> lstPelicula) {
		this.lstPelicula = lstPelicula;
	}

	public String getCadenaPelicula() {
		return cadenaPelicula;
	}

	public void setCadenaPelicula(String cadenaPelicula) {
		this.cadenaPelicula = cadenaPelicula;
	}
	
	
	
}
