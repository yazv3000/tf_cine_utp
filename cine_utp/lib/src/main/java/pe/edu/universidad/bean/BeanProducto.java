package pe.edu.universidad.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import cine_utp_jpa.HorarioSala;
import cine_utp_jpa.Sala;
import pe.edu.universidad.dto.DtoProductoConsulta;
import pe.edu.universidad.ejb.EJBCompraProducto;
import pe.edu.universidad.ejb.EJBGesionSala;

@Named
@SessionScoped
public class BeanProducto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private EJBCompraProducto ejb;
	private List<DtoProductoConsulta> listado;
	private List<DtoProductoConsulta> carrito;
	private double totalCarrito;
	
	public BeanProducto() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		listado = ejb.consultarProductosTodos();
	}

	public void accionAgregarProducto(DtoProductoConsulta p) {
		carrito = ejb.agregarProductoCarrito(carrito, p);
		totalCarrito = ejb.calcularTotalCarrito(carrito);
	}
	
	public void accionEliminarProducto(DtoProductoConsulta p) {
		carrito = ejb.elimiarProductoCarrito(carrito, p.getCodProducto());
		totalCarrito = ejb.calcularTotalCarrito(carrito);
	}
	
	public List<DtoProductoConsulta> getListado() {
		return listado;
	}

	public void setListado(List<DtoProductoConsulta> listado) {
		this.listado = listado;
	}

	public List<DtoProductoConsulta> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<DtoProductoConsulta> carrito) {
		this.carrito = carrito;
	}

	public double getTotalCarrito() {
		return totalCarrito;
	}

	public void setTotalCarrito(double totalCarrito) {
		this.totalCarrito = totalCarrito;
	}
	
	

}
