package es.sidelab.LibreriaSD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repositorioCategoria;

	@PostMapping("/LibreriaSD/añadir/categoria/solicitud")
	public String añadirCategoria(@RequestParam String nombre,
			Model model) {

		Categoria categoria = new Categoria(nombre);

		repositorioCategoria.save(categoria);

		return "añadirCategoria";
	}
        
}