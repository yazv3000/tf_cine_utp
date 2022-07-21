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
import pe.edu.universidad.proc.comprarTicket.dto.DtoClienteConsulta;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanClienteTicket implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarTicket ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanSeleccionFuncion beanSeleccionFuncion;
	
	@Inject
	private BeanCompraTicket beanCompra;
	
	public BeanClienteTicket() {	
		System.out.println("Creando BeanClienteTicket");
	}
	
    @PostConstruct
    public void inicializar() {
    	lstCliente = ejb.consultarClientesTodos();	
    }

	// Propiedades : atributo + getter & setter
	private List<DtoClienteConsulta> lstCliente;
	public List<DtoClienteConsulta> getLstCliente() {		return lstCliente;	}
	public void setLstFuncion(List<DtoClienteConsulta> lstCliente) {		this.lstCliente = lstCliente;	}

	public String seleccionarCliente() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	int idCliente = Integer.parseInt(map.get("clienteid"));
    	System.out.println("Se ha seleccionado al cliente: "+idCliente);
    	beanCompra.setCliente(ejb.consultarClientePorId(idCliente));
    	return beanSeleccionFuncion.cargarFunciones();
	}
	
}
