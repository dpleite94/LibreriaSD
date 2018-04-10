package es.sidelab.LibreriaSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
	Libro findByTitulo(String titulo);
	
	Libro findByIdLibro(long idLibro);
	
	List<Libro> findByEditorialIdEditorial(long idEditorial);
	
	List<Libro> findByCategoriaIdCategoria(long idCategoria);
	
}
