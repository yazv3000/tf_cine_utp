package pe.edu.universidad.proc.gestionarFuncion.dto;

public class DtoPeliculaConsulta {
	
	// Atributos
	private int codigo;
	private String nombre;
	private String tipo;
	private String descripcion;
	private String calificacion;
	private String duracion;
	
	// Constructor
	public DtoPeliculaConsulta() {}
	
	// Métodos Getter & Setter
	public int getCodigo() {		return codigo;	}
	public void setCodigo(int codigo) {		this.codigo = codigo;	}

	public String getNombre() {		return nombre;	}
	public void setNombre(String nombre) {		this.nombre = nombre;	}

	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	
	public String getTipo() {	return tipo;}
	public void setTipo(String tipo) {	this.tipo = tipo;}
	
	public String getCalificacion() {	return calificacion;}
	public void setCalificacion(String calificacion) {this.calificacion = calificacion;}
	
	public String getDuracion() {	return duracion;}
	public void setDuracion(String duracion) {	this.duracion = duracion;}
	
}