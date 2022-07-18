package pe.edu.universidad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoFuncionNueva;
import pe.edu.universidad.dto.DtoFuncionNueva1;
import pe.edu.universidad.dto.DtoPelicula;
import pe.edu.universidad.dto.DtoSala;
import pe.edu.universidad.dto.DtoSi;
import pe.edu.universidad.ejb.EJBGestionarFunciones;

@Named
@SessionScoped
public class BeanFuncion implements Serializable {
	
	private DtoFuncionNueva1 dtoFuncionNueva;
	
	private List<SelectItem> siPeliculas;
	private List<SelectItem> siSalas;
	
	
	@EJB
	private EJBGestionarFunciones ejb;
	
	public BeanFuncion() {
		dtoFuncionNueva = new DtoFuncionNueva1();
	}
	
	@PostConstruct
	public void inicializar() {
		List<DtoSi> lstPeliculas = ejb.consultarPeliculas();
		siPeliculas = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstPeliculas) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			siPeliculas.add(si);
		}
		List<DtoSi> lstSalas = ejb.consultarSalas();
		siSalas = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstSalas) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			siSalas.add(si);
		}
	}

	public void guardarFuncion() {
		ejb.registrarFuncion(dtoFuncionNueva);
	}
	
	public String cargarPelicula(int id) {
		System.out.println("Id Pelicula: " + id);
		dtoFuncionNueva.setCodPelicula(id);
		return "Funcion";
	}

	public DtoFuncionNueva1 getDtoFuncionNueva() {
		return dtoFuncionNueva;
	}

	public void setDtoFuncionNueva(DtoFuncionNueva1 dtoFuncionNueva) {
		this.dtoFuncionNueva = dtoFuncionNueva;
	}

	public List<SelectItem> getSiPeliculas() {
		return siPeliculas;
	}

	public void setSiPeliculas(List<SelectItem> siPeliculas) {
		this.siPeliculas = siPeliculas;
	}

	public List<SelectItem> getSiSalas() {
		return siSalas;
	}

	public void setSiSalas(List<SelectItem> siSalas) {
		this.siSalas = siSalas;
	}

	
	
}
