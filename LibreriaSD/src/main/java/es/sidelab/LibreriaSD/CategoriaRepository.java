package es.sidelab.LibreriaSD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
    
	Categoria findByIdCategoria(long idCategoria);
        
        Categoria findByNombre(String nombre);
}
