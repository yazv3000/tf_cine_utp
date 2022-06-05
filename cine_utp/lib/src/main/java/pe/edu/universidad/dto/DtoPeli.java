package pe.edu.universidad.dto;
import java.util.List;
import pe.edu.universidad.entidades.sala;

public class DtoPeli {
	private int codigo;
	private String nombre;
	private int duracion;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
