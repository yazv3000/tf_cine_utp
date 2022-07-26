package pe.edu.universidad.proc.comprarProductos.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoVentaNueva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int codCliente;
	private int codProducto;
	private int codVendedor;
	private Date fechaVenta;
	private int cantidad;
	private double monto;
	
	// Constructor
	public DtoVentaNueva() {}

	// Métodos Getter & Setter
	public int getCodCliente() {		return codCliente;	}
	public void setCodCliente(int codCliente) {		this.codCliente = codCliente;	}

	public int getCodProducto() {		return codProducto;	}
	public void setCodProducto(int codProducto) {		this.codProducto = codProducto;	}

	public int getCodVendedor() {		return codVendedor;	}
	public void setCodVendedor(int codVendedor) {		this.codVendedor = codVendedor;	}

	public Date getFechaVenta() {		return fechaVenta;	}
	public void setFechaVenta(Date fechaVenta) {		this.fechaVenta = fechaVenta;	}

	public int getCantidad() {		return cantidad;	}
	public void setCantidad(int cantidad) {		this.cantidad = cantidad;	}

	public double getMonto() {		return monto;	}
	public void setMonto(double monto) {		this.monto = monto;	}

}
