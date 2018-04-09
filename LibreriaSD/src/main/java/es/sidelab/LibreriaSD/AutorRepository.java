/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sidelab.LibreriaSD;

/**
 *
 * @author jaime
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
    
	Autor findByIdAutor(long idAutor);
        
        Autor findByNombre(String nombre);

        

	
}