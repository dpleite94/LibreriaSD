package es.sidelab.LibreriaSD;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idCategoria;
    @OneToMany(mappedBy="categoria")
    @Cascade({CascadeType.ALL})
    private Set<Libro> libros;
    private String nombre;
    
    public Categoria() {
    	
    }
    
    public Categoria( String nombre) {
        
        this.nombre = nombre;
    }
    
    public Categoria(String name, Set<Libro> libros){
        this.nombre = name;
        this.libros = libros;
    }
    
    public long getIdCategoria() {
		return idCategoria;
	}
	
    public void setIdCategoria(long idEditorial) {
		this.idCategoria = idEditorial;
        }
    
    public Set<Libro> getLibros() {
			return libros;
		}

    public void setLibros(Set<Libro> libros) {
			this.libros = libros;
    }
    
    public String getNombre() {
        
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
    
        this.nombre = nombre;
    }
    
    @Override
	public String toString() {
		return "Autor [nombre=" + nombre + "]";
        }
    
}
