package es.sidelab.LibreriaSD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
	Libro findByTitulo(String titulo);
	
	Libro findByIdLibro(long idLibro);
	
}
