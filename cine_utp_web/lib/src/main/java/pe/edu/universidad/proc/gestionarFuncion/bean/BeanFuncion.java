package pe.edu.universidad.proc.gestionarFuncion.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.proc.gestionarFuncion.EJBGestionarFuncion;
import pe.edu.universidad.proc.gestionarFuncion.dto.DtoFuncionConsulta;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanFuncion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBGestionarFuncion ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
    @PostConstruct
    public void inicializar() {
    	lstFuncion = ejb.consultarFuncionesTodos();	
    }

	// Propiedades : atributo + getter & setter
	private List<DtoFuncionConsulta> lstFuncion;
	public List<DtoFuncionConsulta> getLstFuncion() {		return lstFuncion;	}
	public void setLstFuncion(List<DtoFuncionConsulta> lstFuncion) {		this.lstFuncion = lstFuncion;	}

	
	

}
