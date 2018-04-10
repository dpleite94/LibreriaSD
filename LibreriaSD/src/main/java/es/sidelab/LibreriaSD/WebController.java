package es.sidelab.LibreriaSD;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
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
                @Autowired
		private AutorRepository repositorioAutor;
        @Autowired
        private CategoriaRepository repositorioCategoria;
                
		@PostConstruct
		public void init() {
                       
                        Autor aut1 = new Autor("Valle Inclan");
                        Autor aut2 = new Autor("Ken Follet");
                        Autor aut3 = new Autor("Juan Capdevila");
                        Autor aut4 = new Autor("VV.AA.");
                        Autor aut5 = new Autor("Pío Baroja");
                        Autor aut6 = new Autor("Martin Handford");
                        
                        repositorioAutor.save(aut1);
			repositorioAutor.save(aut2);
                        repositorioAutor.save(aut3);
			repositorioAutor.save(aut4);
                        repositorioAutor.save(aut5);
			repositorioAutor.save(aut6);
			
			Categoria cat1 = new Categoria("Comedia");
			Categoria cat2 = new Categoria("Novela histórica");
			Categoria cat3 = new Categoria("Infantil");
			Categoria cat4 = new Categoria("Novela autobiográfica");
			
			repositorioCategoria.save(cat1);
			repositorioCategoria.save(cat2);
			repositorioCategoria.save(cat3);
			repositorioCategoria.save(cat4);
                    
			Editorial edi1= new Editorial("Anaya", 913456767, "anaya.editorial.sd@gmail.com", 280123, "A7843243");
			Editorial edi2= new Editorial("Santillana", 913498007, "santillana.editorial.sd@gmail.com", 280070, "A7841661");
			// Hay que guardar dos veces la editorial en el repositorio por temas de consistencia y coherencia con
			// los elementos con los que se relaciona formalmente en la bd
			repositorioEditorial.save(edi1);
			repositorioEditorial.save(edi2);
                        			
			
			Libro lib1= new Libro( "Luces de Bohemia", new HashSet<Autor>() {{add(aut5);add(aut2); }} , edi1,"10-3-1905", 190, "7564839275993", 20.99, cat1 );
			lib1.setEditorial(edi1);
                       
  			
			Libro lib2= new Libro("Los pilares de la tierra", new HashSet<Autor>() {{add(aut3);add(aut4); }} ,edi1,"26-10-1989", 1300, "7564006535311", 24.99, cat2 );
			lib2.setEditorial(edi1);
 			
			Libro lib3 = new Libro("TEO va a la URJC", new HashSet<Autor>() {{add(aut6);add(aut1); }} ,edi2,"13-5-2005", 32, "9788471763112", 4.99, cat3 );
			lib3.setEditorial(edi2);
			
			Libro lib4 = new Libro("Pinta y colorea", new HashSet<Autor>() {{add(aut6); }} ,edi2,"11-2-2000", 12, "9788416117581", 2.99, cat3 );
			lib4.setEditorial(edi2);
			
			Libro lib5 = new Libro("El árbol de la ciencia",  new HashSet<Autor>() {{add(aut5); }} ,edi1,"9-11-1911", 304, "9788437605227", 19.99, cat4 );
			lib5.setEditorial(edi1);                   
			
			Libro lib6 = new Libro("¿Donde está Wally?",  new HashSet<Autor>() {{add(aut4); }} ,edi1,"1-12-2012", 30, "9788493961473", 8.99, cat3 );
			lib6.setEditorial(edi1);
   		
			edi1.getLibros().add(lib1);
			edi1.getLibros().add(lib2);
			edi2.getLibros().add(lib3);
			edi2.getLibros().add(lib4);
			edi1.getLibros().add(lib5);
			edi1.getLibros().add(lib6);
			repositorioEditorial.save(edi1);
			repositorioEditorial.save(edi2);
                        
         
                        
                        repositorioLibro.save(lib1);
                        repositorioLibro.save(lib2);
                        repositorioLibro.save(lib3);
                        repositorioLibro.save(lib4);
                        repositorioLibro.save(lib5);
                        repositorioLibro.save(lib6);
                        
                     /* repositorioLibro.save(new HashSet<Libro>() {{
                                 add(new Libro("", new HashSet<Autor>() {{
                                 add(aut5);
                                  add(aut2);
                             }}));

                             add(new Libro("", new HashSet<Autor>() {{
                                add(aut3);
                                add(aut4);
                                 }}));
                             
                                 add(new Libro("", new HashSet<Autor>() {{
                                add(aut3);
                                add(aut4);
                                 }}));
                            }});   */                    
                             

			
		}		

		@RequestMapping("/LibreriaSD")
		public String greetingInicio(Model model) {

			model.addAttribute("editoriales", repositorioEditorial.findAll());
                        
                        model.addAttribute("autores", repositorioAutor.findAll()); 
                        
            model.addAttribute("categorias", repositorioCategoria.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/buscar/libro")
		public String buscarLibro(@RequestParam String titulo, Model model) {

			model.addAttribute("libros", repositorioLibro.findByTitulo(titulo));
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());
                        
                        model.addAttribute("autores", repositorioAutor.findAll());
                        
            model.addAttribute("categorias", repositorioCategoria.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/buscar/editorial")
		public String buscarEditorial(@RequestParam long idEditorial, Model model) {

			model.addAttribute("editorialess", repositorioEditorial.findByIdEditorial(idEditorial));
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());
                        
                        model.addAttribute("autores", repositorioAutor.findAll());
                        
            model.addAttribute("categorias", repositorioCategoria.findAll());

			return "inicio";
		}
		
		@RequestMapping("/LibreriaSD/buscar/poreditorial")
		public String buscarPorEditorial(@RequestParam long idEditorial, Model model) {
                        
                       
                        List<Libro> libroses = repositorioLibro.findByEditorialIdEditorial(idEditorial);
                       
                        repositorioLibro.save(libroses);
                        
			model.addAttribute("libros", repositorioLibro.findByEditorialIdEditorial(idEditorial));                       
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());
                        
                        model.addAttribute("autores", repositorioAutor.findAll());
                        
            model.addAttribute("categorias", repositorioCategoria.findAll());           

			return "inicio";
		}
		
		@RequestMapping("/LibreriaSD/buscar/porautor")
		public String buscarPorAutor(@RequestParam long idAutor, Model model) {
                      

                    
                    Autor autorBusqueda = repositorioAutor.findByIdAutor(idAutor);
                    
                    Set librosdelautor = autorBusqueda.getLibros();
                    
                    List libros = new ArrayList();
                    
                    libros.addAll(librosdelautor);
                    
            
                    model.addAttribute("libros", libros);
                            
                    model.addAttribute("editoriales", repositorioEditorial.findAll());

                    model.addAttribute("autores", repositorioAutor.findAll());
                    
                    model.addAttribute("categorias", repositorioCategoria.findAll());

                    return "inicio";
		}
		
		@RequestMapping("/LibreriaSD/buscar/porcategoria")
		public String buscarPorCategoria(@RequestParam long idCategoria, Model model) {

                        List<Libro> libros = repositorioLibro.findByCategoriaIdCategoria(idCategoria);
            
                        repositorioLibro.save(libros);
            
                        model.addAttribute("libros", repositorioLibro.findByCategoriaIdCategoria(idCategoria));  
			
			model.addAttribute("autores", repositorioAutor.findAll());
			
			model.addAttribute("editoriales", repositorioEditorial.findAll());
			
			model.addAttribute("categorias", repositorioCategoria.findAll());

			return "inicio";
		}

		@RequestMapping("/LibreriaSD/añadir/libro")
		public String greetingAñadirLibro(Model model) {

			model.addAttribute("editoriales", repositorioEditorial.findAll());
                        
                        model.addAttribute("autores", repositorioAutor.findAll());
                        
            model.addAttribute("categorias", repositorioCategoria.findAll());

			return "añadirLibro";
		}

		@RequestMapping("/LibreriaSD/añadir/editorial")
		public String greetingAñadirEditorial(Model model) {

			return "añadirEditorial";
		}
                
                @RequestMapping("/LibreriaSD/añadir/autor")
		public String greetingAñadirAutor(Model model) {

			return "añadirAutor";
		}
                
                @RequestMapping("/LibreriaSD/añadir/categoria")
		public String greetingAñadirCategoria(Model model) {

			return "añadirCategoria";
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
