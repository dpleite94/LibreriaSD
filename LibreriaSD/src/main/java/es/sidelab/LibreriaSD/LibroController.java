package es.sidelab.LibreriaSD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {
	
	@Autowired
	private LibroRepository repositorioLibro;
	@Autowired
	private EditorialRepository repositorioEditorial;

	@PostMapping("/LibreriaSD/añadir/libro/solicitud")
	public String añadirLibro(@RequestParam String autor, @RequestParam String titulo, Editorial editorial, 
			@RequestParam String añopublicacion, @RequestParam Integer numpag, 
			@RequestParam String ISBN, @RequestParam Double precio, @RequestParam String categoria,
			Model model) {

		Libro libro = new Libro(autor, titulo, editorial, añopublicacion, numpag, ISBN, precio, categoria);

		repositorioLibro.save(libro);

		model.addAttribute("editoriales", repositorioEditorial.findAll());

		return "añadirLibro";
	}

	@RequestMapping("/LibreriaSD/modificarLibro")
	public String greetingModificar(@RequestParam long id, Model model) {

		model.addAttribute("libro", repositorioLibro.findByIdLibro(id));

		model.addAttribute("editoriales", repositorioEditorial.findAll());

		return "modificarLibro";
	}

	@PostMapping("/LibreriaSD/modificarLibro/solicitud")
	public String modificarLibro(@RequestParam long idLibro, @RequestParam String autor,
			@RequestParam String titulo, @RequestParam long idEditorial, @RequestParam String añopublicacion,
			@RequestParam Integer numpag, @RequestParam String ISBN, @RequestParam Double precio,
			@RequestParam String categoria, Model model) {

		Libro libro = repositorioLibro.findByIdLibro(idLibro);
		Editorial editorial = repositorioEditorial.findByIdEditorial(idEditorial);
		
		libro.setAutor(autor);
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
