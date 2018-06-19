package es.sidelab.LibreriaSD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutorController {
	
	@Autowired
	private AutorRepository repositorioAutor;

	@PostMapping("/añadir/autor/solicitud")
	public String añadirEditorial(@RequestParam String nombre,
			Model model) {

		Autor autor = new Autor(nombre);

		repositorioAutor.save(autor);

		return "añadirAutor";
	}
        
}