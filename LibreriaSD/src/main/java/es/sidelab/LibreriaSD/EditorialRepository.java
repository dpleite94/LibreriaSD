package es.sidelab.LibreriaSD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Long>{
	
	Editorial findByIdEditorial(long idEditorial);
	
}
