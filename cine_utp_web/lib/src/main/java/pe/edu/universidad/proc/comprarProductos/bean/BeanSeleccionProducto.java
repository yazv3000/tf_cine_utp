package pe.edu.universidad.proc.comprarProductos.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarProductos.EJBComprarProducto;
import pe.edu.universidad.proc.comprarProductos.dto.DtoProductoConsulta;



@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanSeleccionProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarProducto ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanCompraProducto beanCompraProducto;
	
	public BeanSeleccionProducto() { 
		System.out.println("Creando BeanSeleccionProducto");
	}
	
    @PostConstruct
    public void inicializar() {
    	lstProducto = ejb.consultarProductosTodos();	
    }

	// Propiedades : atributo + getter & setter
	private List<DtoProductoConsulta> lstProducto;
	public List<DtoProductoConsulta> getLstProducto() {		return lstProducto;	}
	public void setLstProducto(List<DtoProductoConsulta> lstFuncion) {		this.lstProducto = lstProducto;	}

	public String seleccionarProducto() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	int idProducto = Integer.parseInt(map.get("productoid"));
    	System.out.println("Se ha seleccionado el producto: "+idProducto);
    	beanCompraProducto.setProducto(ejb.consultarProductoPorId(idProducto));
		return beanCompraProducto.cargarDetalle();
	}
	
	public String cargarProductos() {
		return "seleccionProducto";
	}
	
}
