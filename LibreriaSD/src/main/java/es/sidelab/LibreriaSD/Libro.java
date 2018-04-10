package es.sidelab.LibreriaSD;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Libro implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long idLibro;	
		@ManyToMany
                @Cascade({CascadeType.SAVE_UPDATE})
                private Set<Autor> autores;
		private String titulo;
		@ManyToOne
		@JoinColumn(name="editorial")
		private Editorial editorial;
		private String añopublicacion;
		private Integer numpag;
		private String ISBN;
		private Double precio;
		@ManyToOne
        @Cascade({CascadeType.SAVE_UPDATE})
		private Categoria categoria;
		
		public Libro() {
			
		}

		public Libro( String titulo, Editorial editorial, String añopublicacion, Integer numpag, 
				String ISBN, Double precio, Categoria categoria) {
                        this.titulo = titulo;

			this.editorial = editorial;
			this.añopublicacion = añopublicacion;
			this.numpag = numpag;
			this.ISBN = ISBN;
			this.precio = precio;
			this.categoria = categoria;
		}
                public Libro( String titulo, HashSet<Autor> autores, Editorial editorial, String añopublicacion, Integer numpag, 
				String ISBN, Double precio, Categoria categoria) {
                        this.titulo = titulo;
                        this.autores = autores;
			this.editorial = editorial;
			this.añopublicacion = añopublicacion;
			this.numpag = numpag;
			this.ISBN = ISBN;
			this.precio = precio;
			this.categoria = categoria;
		}
		public Libro( String titulo, Set<Autor> autores) {
                        this.titulo = titulo;
                        this.autores = autores;

		}                

		public long getIdLibro() {
			return idLibro;
		}
		
		public void setIdSmartPhone(long idLibro) {
			this.idLibro = idLibro;
		}
		
		public Set<Autor> getAutores() {
			return autores;
		}

		public void setAutores(Set<Autor> autores) {
			this.autores = autores;
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
		
		public Categoria getCategoria() {
			return categoria;
		}
		
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		@Override
		public String toString() {
			return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", añopublicacion=" + 
		añopublicacion + ", numpag=" + numpag + ", ISBN=" + ISBN + ", precio=" + precio + ", categoria=" + categoria + "]";
		}

}
