package pe.edu.universidad.proc.comprarProductos.bean;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.universidad.proc.comprarProductos.EJBComprarProducto;
import pe.edu.universidad.proc.comprarProductos.dto.DtoClienteConsulta;
import pe.edu.universidad.proc.comprarProductos.dto.DtoProductoConsulta;
import pe.edu.universidad.proc.comprarProductos.dto.DtoVentaNueva;


@Named						// objeto nombrado
@SessionScoped			// alcance

public class BeanCompraProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EJBComprarProducto ejb;		// EJB se inyecta después de crear el objeto bean (después de llamar al constructor)
	
	@Inject
	private BeanVentaProductos beanVentaProductos;
	
	public BeanCompraProducto() {}
	
	public String cargarDetalle() {
		return "registroCompra";
	}
	
	public String confirmarCompra() {
		DtoVentaNueva venta = new DtoVentaNueva();
		venta.setCodCliente(cliente.getCodigo());
		venta.setCodProducto(producto.getCodProducto());
		venta.setCantidad(cantidad);
		venta.setCodVendedor(2);
		venta.setFechaVenta(new Date());
		venta.setMonto(getMontoTotal());
		ejb.registrarVentaProducto(venta);
		
		beanVentaProductos.inicializar();
		return "ventasProducto";
	}
	
	// Propiedades : atributo + getter & setter
	private DtoClienteConsulta cliente;
	public DtoClienteConsulta getCliente() {		return cliente;	}
	public void setCliente(DtoClienteConsulta cliente) {
		this.cliente = cliente;
	}
	
	private DtoProductoConsulta producto; 
	public DtoProductoConsulta getProducto() {		return producto;	}
	public void setProducto(DtoProductoConsulta producto) {
		this.producto = producto;
	}
	
	private int cantidad;
	public int getCantidad() {		return cantidad;	}
	public void setCantidad(int cantidad) {		this.cantidad = cantidad;	}	
	
	private double montoTotal;
	public double getMontoTotal() {		
		return cantidad*producto.getPrecio();	
	}
	public void setMontoTotal(double montoTotal) {		this.montoTotal = montoTotal;	}
	
}
