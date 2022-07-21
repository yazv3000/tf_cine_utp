package pe.edu.universidad.proc.comprarProductos.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoVentaConsulta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private String nombreCliente;
	private String nombreProducto;
	private Date fecha;
	private int cantidad;
	private double monto;
	
	// Constructor
	public DtoVentaConsulta() {}

	// Métodos Getter & Setter
	public String getNombreCliente() {		return nombreCliente;	}
	public void setNombreCliente(String nombreCliente) {		this.nombreCliente = nombreCliente;	}

	public String getNombreProducto() {		return nombreProducto;	}
	public void setNombreProducto(String nombreProducto) {		this.nombreProducto = nombreProducto;	}

	public Date getFecha() {		return fecha;	}
	public void setFecha(Date fecha) {		this.fecha = fecha;	}

	public int getCantidad() {		return cantidad;	}
	public void setCantidad(int cantidad) {		this.cantidad = cantidad;	}

	public double getMonto() {		return monto;	}
	public void setMonto(double monto) {		this.monto = monto;	}

}
