package pe.edu.universidad.proc.gestionarFuncion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoSi;
import pe.edu.universidad.proc.gestionarFuncion.EJBGestionarFuncion;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoFuncionNueva;


@Named
@SessionScoped
public class BeanFuncionNueva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBGestionarFuncion ejb;

	@Inject
	private BeanFuncion beanFuncion;
	
	public BeanFuncionNueva() {
		dtoFuncionNueva = new DtoFuncionNueva();
	}

	@PostConstruct
	public void inicializar() {
		// Lista de películas
		List<DtoSi> lstPeliculas = ejb.consultarPeliculas();
		siPeliculas = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstPeliculas) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			siPeliculas.add(si);
		}
		
		// Lista de salas disponibles
		List<DtoSi> lstSalas = ejb.consultarSalas();
		siSalas = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstSalas) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			siSalas.add(si);
		}
	}

	public String guardarFuncion() {
		ejb.registrarFuncion(dtoFuncionNueva);
		beanFuncion.inicializar();
		return "funcion"; 
	}
	
	// Propiedades : atributo + getter & setter
	private DtoFuncionNueva dtoFuncionNueva;
	public DtoFuncionNueva getDtoFuncionNueva() {		return dtoFuncionNueva;	}
	public void setDtoFuncionNueva(DtoFuncionNueva dtoFuncionNueva) {
		this.dtoFuncionNueva = dtoFuncionNueva;
	}

	private List<SelectItem> siPeliculas;
	public List<SelectItem> getSiPeliculas() {		return siPeliculas;	}
	public void setSiPeliculas(List<SelectItem> siPeliculas) {
		this.siPeliculas = siPeliculas;
	}

	private List<SelectItem> siSalas;
	public List<SelectItem> getSiSalas() {		return siSalas;	}
	public void setSiSalas(List<SelectItem> siSalas) {
		this.siSalas = siSalas;
	}

}