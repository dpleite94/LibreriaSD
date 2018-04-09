/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sidelab.LibreriaSD;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/**
 *
 * @author jaime
 */
@Entity
@Table(name = "AUTOR")
public class Autor {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idAutor;
    @ManyToMany(mappedBy="autores")
    @Cascade({CascadeType.ALL})
    private Set<Libro> libros;
    private String nombre;
    
    public Autor() {}
    
    public Autor( String nombre) {
        
        this.nombre = nombre;
    }
    
    public Autor(String name, Set<Libro> libros){
        this.nombre = name;
        this.libros = libros;
    }
    
    public long getIdAutor() {
		return idAutor;
	}
	
    public void setIdAutor(long idEditorial) {
		this.idAutor = idEditorial;
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
