package pe.edu.universidad.proc.gestionarFuncion.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.proc.gestionarFuncion.EJBGestionarFuncion;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoPeliculaConsulta;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanPelicula implements Serializable{

	@EJB
	private EJBGestionarFuncion ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	
    @PostConstruct
    public void inicializar() {
    	lstPelicula = ejb.consultarPeliculasTodos();	
    }


	// Propiedades : atributo + getter & setter
	private List<DtoPeliculaConsulta> lstPelicula;
	public List<DtoPeliculaConsulta> getLstPelicula() {		return lstPelicula;	}
	public void setLstPelicula(List<DtoPeliculaConsulta> lstPelicula) {		this.lstPelicula = lstPelicula;	}
    

}
