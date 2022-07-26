package pe.edu.universidad.proc.comprarTicket.dto;

import java.io.Serializable;

public class DtoAsiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Atributos
	private int numero;
	private boolean estadoDisponible;
	
	// Constructor
	public DtoAsiento(int num) {
		this.numero = num;
		this.estadoDisponible = true;
	}

	// Métodos Getter & Setter
	public int getNumero() {		return numero;	}
	public void setNumero(int numero) {		this.numero = numero;	}

	public boolean isEstadoDisponible() {		return estadoDisponible;	}
	public void setEstadoDisponible(boolean estadoDisponible) {		this.estadoDisponible = estadoDisponible;	}
	
}
