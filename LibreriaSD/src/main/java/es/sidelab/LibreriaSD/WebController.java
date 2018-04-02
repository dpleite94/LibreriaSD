package es.sidelab.LibreriaSD;

	import javax.annotation.PostConstruct;

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
		
		@PostConstruct
		public void init() {
			Editorial edi1= new Editorial("Anaya", 913456767, "anaya.editorial.sd@gmail.com", 280123, "A7843243");
			Editorial edi2= new Editorial("Santillana", 913498007, "santillana.editorial.sd@gmail.com", 280070, "A7841661");
			// Hay que guardar dos veces la editorial en el repositorio por temas de consistencia y coherencia con
			// los elementos con los que se relaciona formalmente en la bd
			repositorioEditorial.save(edi1);
			repositorioEditorial.save(edi2);
			
			Libro lib1= new Libro("Valle Inclan", "Luces de Bohemia",edi1,"10-3-1905", 190, "7564839275993", 20.99, "Comedia" );
			lib1.setEditorial(edi1);
			repositorioLibro.save(lib1);
			
			Libro lib2= new Libro("Ken Follet", "Los pilares de la tierra",edi1,"26-10-1989", 1300, "7564006535311", 24.99, "Novela histórica" );
			lib2.setEditorial(edi1);
			repositorioLibro.save(lib2);
			
			Libro lib3 = new Libro("Juan Capdevila", "TEO va a la URJC",edi2,"13-5-2005", 32, "9788471763112", 4.99, "Infantil" );
			lib3.setEditorial(edi2);
			repositorioLibro.save(lib3);
			
			Libro lib4 = new Libro("VV.AA.", "Pinta y colorea",edi2,"11-2-2000", 12, "9788416117581", 2.99, "Infantil" );
			lib4.setEditorial(edi2);
			repositorioLibro.save(lib4);
			
			Libro lib5 = new Libro("Pío Baroja", "El árbol de la ciencia",edi1,"9-11-1911", 304, "9788437605227", 19.99, "Novela autobiográfica" );
			lib5.setEditorial(edi1);
			repositorioLibro.save(lib5);
			
			Libro lib6 = new Libro("Martin Handford", "¿Donde está Wally?",edi1,"1-12-2012", 30, "9788493961473", 8.99, "Infantil" );
			lib6.setEditorial(edi1);
			repositorioLibro.save(lib6);
			
			
			edi1.getLibros().add(lib1);
			edi1.getLibros().add(lib2);
			edi2.getLibros().add(lib3);
			edi2.getLibros().add(lib4);
			edi1.getLibros().add(lib5);
			edi1.getLibros().add(lib6);
			repositorioEditorial.save(edi1);
			repositorioEditorial.save(edi2);

			
		}		

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
