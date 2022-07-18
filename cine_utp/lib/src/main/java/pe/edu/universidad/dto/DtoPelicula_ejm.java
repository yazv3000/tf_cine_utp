package pe.edu.universidad.dto;

public class DtoPelicula_ejm {
	// ATRIBUTOS
		private int cod_pelicula;
		private String nom_peli;
		private String tipo;
		private String descripcion;
		private String calificacion;
		private String duracion;
		private byte[] poster;
		
		// CONSTRUCTORES
		public DtoPelicula_ejm() {}
		
		public DtoPelicula_ejm(int id_pelicula, String nom_peli, String descripcion, String tipo, String calificacion,
				String duracion, byte[] poster) {
			this.cod_pelicula = id_pelicula;
			this.nom_peli = nom_peli;
			this.descripcion = descripcion;
			this.tipo = tipo;
			this.calificacion = calificacion;
			this.duracion = duracion;
			this.poster = poster;
		}
		
		// GETTERs & SETTERs
		public int getCod_pelicula() {		return cod_pelicula;	}
		public void setCod_pelicula(int cod_pelicula) {		this.cod_pelicula = cod_pelicula;	}

		public String getNom_peli() {return nom_peli;}
		public void setNom_peli(String nom_peli) {	this.nom_peli = nom_peli;}
		
		public String getDescripcion() {return descripcion;}
		public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
		
		public String getTipo() {	return tipo;}
		public void setTipo(String tipo) {	this.tipo = tipo;}
		
		public String getCalificacion() {	return calificacion;}
		public void setCalificacion(String calificacion) {this.calificacion = calificacion;}
		
		public String getDuracion() {	return duracion;}
		public void setDuracion(String duracion) {	this.duracion = duracion;}
		
		public byte[] getPoster() {	return poster;}
		public void setPoster(byte[] poster) {	this.poster = poster;}
}
