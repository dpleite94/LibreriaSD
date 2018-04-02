package es.sidelab.LibreriaSD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEditorial;
	private String nombre;
	private Integer telefono;
	private String email;
	private Integer codpostal;
	private String codfiscal;
	@OneToMany(mappedBy="editorial")
	private List<Libro> libros = new ArrayList<Libro>();
	
	public Editorial() {
		
	}
	
	public Editorial(String nombre, Integer telefono, String email, Integer codpostal, String codfiscal) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.codpostal = codpostal;
		this.codfiscal = codfiscal;
	}
	
	public long getIdEditorial() {
		return idEditorial;
	}
	
	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getCodpostal() {
		return codpostal;
	}
	
	public void setCodpostal(Integer codpostal) {
		this.codpostal = codpostal;
	}
	
	public String getCodfiscal() {
		return codfiscal;
	}
	
	public void setCodfiscal(String codfiscal) {
		this.codfiscal = codfiscal;
	}
	
	public List<Libro> getLibros() {
		return this.libros;
	}
	
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", codpostal=" + 
				codpostal + ", codfiscal=" + codfiscal  + "]";
	}
}
