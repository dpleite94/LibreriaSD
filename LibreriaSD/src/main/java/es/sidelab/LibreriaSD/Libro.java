package es.sidelab.LibreriaSD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long idLibro;	
		private String autor;
		private String titulo;
		@ManyToOne
		@JoinColumn(name="nombre")
		private Editorial editorial;
		private String añopublicacion;
		private Integer numpag;
		private String ISBN;
		private Double precio;
		private String categoria;
		
		public Libro() {
			
		}

		public Libro(String autor, String titulo, Editorial editorial, String añopublicacion, Integer numpag, 
				String ISBN, Double precio, String categoria) {
			this.autor = autor;
			this.titulo = titulo;
			this.editorial = editorial;
			this.añopublicacion = añopublicacion;
			this.numpag = numpag;
			this.ISBN = ISBN;
			this.precio = precio;
			this.categoria = categoria;
		}

		public long getIdLibro() {
			return idLibro;
		}
		
		public void setIdSmartPhone(long idLibro) {
			this.idLibro = idLibro;
		}
		
		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public Editorial getEditorial() {
			return editorial;
		}

		public void setEditorial(Editorial editorial) {
			this.editorial = editorial;
		}
		
		public String getAñopublicacion() {
			return añopublicacion;
		}
		
		public void setAñopublicacion(String añopublicacion) {
			this.añopublicacion = añopublicacion;
		}
		
		public Integer getNumpag() {
			return numpag;
		}
		
		public void setNumpag(Integer numpag) {
			this.numpag = numpag;
		}
		
		public String getISBN() {
			return ISBN;
		}
		
		public void setISBN(String ISBN) {
			this.ISBN = ISBN;
		}
		
		public Double getPrecio() {
			return precio;
		}
		
		public void setPrecio(Double precio) {
			this.precio = precio;
		}
		
		public String getCategoria() {
			return categoria;
		}
		
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		@Override
		public String toString() {
			return "Libro [autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial + ", añopublicacion=" + 
		añopublicacion + ", numpag=" + numpag + ", ISBN=" + ISBN + ", precio=" + precio + ", categoria=" + categoria + "]";
		}

}
