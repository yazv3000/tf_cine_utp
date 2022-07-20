package pe.edu.universidad.compraProducto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import pe.edu.universidad.dto.DtoCompraProductoNueva;
import pe.edu.universidad.dto.DtoSi;

@Named
@SessionScoped
public class BeanComprarProducto implements Serializable{
	
	private DtoCompraProductoNueva dtoCompraProductoNueva;
	
	private List<SelectItem> productosUnitarios;
	private List<SelectItem> productosCombos;
	
	@EJB
	private EJBCompraProducto ejb;
	
	public BeanComprarProducto() {
		dtoCompraProductoNueva = new DtoCompraProductoNueva();
	}
	
	@PostConstruct
	public void inicializar() {
		List<DtoSi> lstProductosUnitarios = ejb.consultarProductosUnitarios();
		productosUnitarios = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstProductosUnitarios) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			productosUnitarios.add(si);
		}
		List<DtoSi> lstProductosCombos = ejb.consultarProductosCombos();
		productosCombos = new ArrayList<SelectItem>();
		for (DtoSi dtoSi : lstProductosCombos) {
			SelectItem si = new SelectItem();
			si.setLabel(dtoSi.getNombre());
			si.setValue(dtoSi.getId());
			productosCombos.add(si);
		}
	}
	public String realizarCompra() {
		ejb.registrarCompra(dtoCompraProductoNueva);
		return "ResumenVenta";
	}

	public DtoCompraProductoNueva getDtoCompraProductoNueva() {
		return dtoCompraProductoNueva;
	}

	public void setDtoCompraProductoNueva(DtoCompraProductoNueva dtoCompraProductoNueva) {
		this.dtoCompraProductoNueva = dtoCompraProductoNueva;
	}

	public List<SelectItem> getProductosUnitarios() {
		return productosUnitarios;
	}

	public void setProductosUnitarios(List<SelectItem> productosUnitarios) {
		this.productosUnitarios = productosUnitarios;
	}

	public List<SelectItem> getProductosCombos() {
		return productosCombos;
	}

	public void setProductosCombos(List<SelectItem> productosCombos) {
		this.productosCombos = productosCombos;
	}
	
	
}
