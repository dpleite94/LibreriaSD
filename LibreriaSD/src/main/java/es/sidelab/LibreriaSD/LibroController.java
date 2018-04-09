package es.sidelab.LibreriaSD;

import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Set;
@Controller
public class LibroController {
	
	@Autowired
	private LibroRepository repositorioLibro;
	@Autowired
	private EditorialRepository repositorioEditorial;
	@Autowired
	private AutorRepository repositorioAutor;        

	@PostMapping("/LibreriaSD/añadir/libro/solicitud")
	public String añadirLibro(@RequestParam String titulo, Editorial editorial, long[] autores,
			@RequestParam String añopublicacion, @RequestParam Integer numpag, 
			@RequestParam String ISBN, @RequestParam Double precio, @RequestParam String categoria,
			Model model) {
                Libro libro = new Libro(titulo , editorial, añopublicacion, numpag, ISBN, precio, categoria);
            
        
                    Set<Autor> autoresset = new HashSet<>();
                    Autor autorBusqueda = new Autor();
                
                    for (int i = 0; i < autores.length; i++){
                    
                    autorBusqueda = repositorioAutor.findByIdAutor(autores[i]);
                    Collections.addAll(autoresset, autorBusqueda);
                    }
                  
                libro.setAutores(autoresset);
		repositorioLibro.save(libro);

		model.addAttribute("editoriales", repositorioEditorial.findAll());
                
                model.addAttribute("autores", repositorioAutor.findAll());

		return "añadirLibro";
	}

	@RequestMapping("/LibreriaSD/modificarLibro")
	public String greetingModificar(@RequestParam long id, Model model) {

            
                model.addAttribute("autores2", repositorioAutor.findAll());
            
		model.addAttribute("libro", repositorioLibro.findByIdLibro(id));
                
                

		model.addAttribute("editoriales", repositorioEditorial.findAll());
                

		return "modificarLibro";
	}
        
	@PostMapping("/LibreriaSD/modificarLibro/solicitud")
	public String modificarLibro(@RequestParam long idLibro, long[] autores2,
			@RequestParam String titulo, @RequestParam long idEditorial, @RequestParam String añopublicacion,
			@RequestParam Integer numpag, @RequestParam String ISBN, @RequestParam Double precio,
			@RequestParam String categoria, Model model) {

		Libro libro = repositorioLibro.findByIdLibro(idLibro);
		Editorial editorial = repositorioEditorial.findByIdEditorial(idEditorial);
		
		
                    Set<Autor> autoresset = new HashSet<>();
                    Autor autorBusqueda = new Autor();
                    for (int i = 0; i < autores2.length; i++){
                        autorBusqueda = repositorioAutor.findByIdAutor(autores2[i]);
                        Collections.addAll(autoresset, autorBusqueda);
                    }
                  
                libro.setAutores(autoresset);
		libro.setTitulo(titulo);
		libro.setEditorial(editorial);
		libro.setAñopublicacion(añopublicacion);
		libro.setNumpag(numpag);
		libro.setISBN(ISBN);
		libro.setPrecio(precio);
		libro.setCategoria(categoria);

		repositorioLibro.save(libro);

		return "modificarLibro";
	}

	
}
