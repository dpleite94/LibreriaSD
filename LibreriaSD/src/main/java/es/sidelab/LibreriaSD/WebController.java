package es.sidelab.LibreriaSD;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class WebController {

		@Autowired
		private LibroRepository repositorioLibro;
		@Autowired
		private EditorialRepository repositorioEditorial;

		@RequestMapping("/LibreriaSD")
		public String greetingInicio(Model model) {

			model.addAttribute("editoriales", repositorioEditorial.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/buscar/libro")
		public String buscarLibro(@RequestParam String titulo, Model model) {

			model.addAttribute("libros", repositorioLibro.findByTitulo(titulo));
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/buscar/editorial")
		public String buscarEditorial(@RequestParam long idEditorial, Model model) {

			model.addAttribute("editorialess", repositorioEditorial.findByIdEditorial(idEditorial));
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/añadir/libro")
		public String greetingAñadirLibro(Model model) {

			model.addAttribute("editoriales", repositorioEditorial.findAll());

			return "añadirLibro";
		}

		@RequestMapping("/LibreriaSD/añadir/editorial")
		public String greetingAñadirEditorial(Model model) {

			return "añadirEditorial";
		}

		@RequestMapping("/LibreriaSD/detallesLibro")
		public String greetingDetallesLibro(@RequestParam long idLibro, Model model) {

			model.addAttribute("libro", repositorioLibro.findByIdLibro(idLibro));

			return "detallesLibro";
		}
		
		@RequestMapping("/LibreriaSD/detallesEditorial")
		public String greetingDetallesEditorial(@RequestParam long idEditorial, Model model) {

			model.addAttribute("editorial", repositorioEditorial.findByIdEditorial(idEditorial));

			return "detallesEditorial";
		}

}
