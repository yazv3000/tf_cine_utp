package pe.edu.universidad.proc.comprarTicket.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarTicket.EJBComprarTicket;
import pe.edu.universidad.proc.comprarTicket.dto.DtoAsiento;


@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanSeleccionAsiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarTicket ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanCompraTicket beanCompra;
	
	public BeanSeleccionAsiento() { 
		System.out.println("Creando BeanSeleccionAsiento");
	}

	// Propiedades : atributo + getter & setter
	private List<DtoAsiento> lstAsientos;
	public List<DtoAsiento> getLstAsientos() {		return lstAsientos;	}
	public void setLstFuncion(List<DtoAsiento> lstAsientos) {		this.lstAsientos = lstAsientos;	}

	public String seleccionarAsiento() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	int asiento = Integer.parseInt(map.get("asiento"));
    	System.out.println("Se ha seleccionado el asiento: "+asiento);
    	beanCompra.setAsiento(asiento);
		return beanCompra.cargarDetalle();
	}
	
	public String cargarAsientos(int idFuncion) {
		lstAsientos = ejb.consultarAsientosPorFuncion(idFuncion);	
		return "seleccionAsiento";
	}
	
}
