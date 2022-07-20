package pe.edu.universidad.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DtoCompraProductoNueva implements Serializable{
	private int codVenta;
	
	private int codProducto;
	
	private int codCliente;
	
	private String fecha;
	
	

	private Date fechaVenta;

	private double montoTotal;
	
	private int cantidad;

	public DtoCompraProductoNueva() {
	}

	public Integer getCodVenta() {
		return this.codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	
	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public int getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		this.fecha = sdf.format(fechaVenta);
	}
	public String getFechaVenta() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(fechaVenta);
	}

	public void setFechaVenta(Date fechaVenta) {
		
		
		this.fechaVenta = fechaVenta;
	}

	public double getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
