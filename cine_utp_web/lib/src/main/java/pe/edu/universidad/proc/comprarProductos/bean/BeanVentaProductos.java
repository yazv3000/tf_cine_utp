package pe.edu.universidad.proc.comprarProductos.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarProductos.EJBComprarProducto;
import pe.edu.universidad.proc.comprarProductos.dto.DtoVentaConsulta;

@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanVentaProductos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarProducto ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	public BeanVentaProductos() {
		System.out.println("Creando BeanVentaProductos");
	}
	
    @PostConstruct
    public void inicializar() {
    	lstVentas = ejb.consultarVentasTodos();	
    }
	
	// Propiedades : atributo + getter & setter
	private List<DtoVentaConsulta> lstVentas;
	public List<DtoVentaConsulta> getLstVentas() {		return lstVentas;		}
	public void setLstVentas(List<DtoVentaConsulta> lstVentas) {
		this.lstVentas = lstVentas;
	}	

}
