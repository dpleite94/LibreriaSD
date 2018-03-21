package es.sidelab.LibreriaSD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialRepository repositorioEditorial;

	@PostMapping("/LibreriaSD/añadir/editorial/solicitud")
	public String añadirEditorial(@RequestParam String nombre, @RequestParam Integer telefono, 
			@RequestParam String email, @RequestParam Integer codpostal, @RequestParam String codfiscal,
			Model model) {

		Editorial editorial = new Editorial(nombre, telefono, email, codpostal, codfiscal);

		repositorioEditorial.save(editorial);

		return "añadirEditorial";
	}

	@RequestMapping("/LibreriaSD/modificarEditorial")
	public String greetingModificar(@RequestParam long id, Model model) {

		model.addAttribute("editorial", repositorioEditorial.findByIdEditorial(id));

		return "modificarEditorial";
	}

	@PostMapping("/LibreriaSD/modificarEditorial/solicitud")
	public String modificarEditorial(@RequestParam long idEditorial, @RequestParam String nombre, 
			@RequestParam Integer telefono, @RequestParam String email, @RequestParam Integer codpostal, 
			@RequestParam String codfiscal, Model model) {

		Editorial editorial = repositorioEditorial.findByIdEditorial(idEditorial);
		
		editorial.setNombre(nombre);
		editorial.setTelefono(telefono);
		editorial.setEmail(email);
		editorial.setCodpostal(codpostal);
		editorial.setCodfiscal(codfiscal);

		repositorioEditorial.save(editorial);

		return "modificarEditorial";
	}
}
