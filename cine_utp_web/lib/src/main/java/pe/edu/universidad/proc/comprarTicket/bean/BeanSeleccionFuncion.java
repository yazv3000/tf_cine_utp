package pe.edu.universidad.proc.comprarTicket.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarTicket.EJBComprarTicket;
import pe.edu.universidad.proc.comprarTicket.dto.DtoFuncionConsulta;


@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanSeleccionFuncion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarTicket ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanCompraTicket beanCompra;
	
	@Inject
	private BeanSeleccionAsiento beanSeleccionAsiento;
	
	public BeanSeleccionFuncion() { 
		System.out.println("Creando BeanSeleccionFuncion");
	}
	
    @PostConstruct
    public void inicializar() {
    	lstFuncion = ejb.consultarFuncionesTodos();	
    }

	// Propiedades : atributo + getter & setter
	private List<DtoFuncionConsulta> lstFuncion;
	public List<DtoFuncionConsulta> getLstFuncion() {		return lstFuncion;	}
	public void setLstFuncion(List<DtoFuncionConsulta> lstFuncion) {		this.lstFuncion = lstFuncion;	}

	public String seleccionarFuncion() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	int idFuncion = Integer.parseInt(map.get("funcionid"));
    	System.out.println("Se ha seleccionado la función: "+idFuncion);
    	beanCompra.setFuncion(ejb.consultarFuncionPorId(idFuncion));
		return beanSeleccionAsiento.cargarAsientos(idFuncion);
	}
	
	public String cargarFunciones() {
		return "seleccionFuncion";
	}
	
}
