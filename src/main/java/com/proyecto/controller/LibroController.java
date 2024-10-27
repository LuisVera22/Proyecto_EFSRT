package com.proyecto.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.AutorEntity;
import com.proyecto.model.CategoriaEntity;
import com.proyecto.model.EditorialEntity;
import com.proyecto.model.LibroCategoriaEntity;
import com.proyecto.model.LibroEntity;
import com.proyecto.repository.EditorialRepository;
import com.proyecto.service.AutorService;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.EditorialService;
import com.proyecto.service.LibroCategoriaService;
import com.proyecto.service.LibroService;
import com.proyecto.service.impl.PdfService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
    private EditorialRepository editorialRepository;
	@Autowired
	private final EditorialService editorialService;
	@Autowired
    private final LibroService libroService;
	@Autowired
    private final AutorService autorService;
	@Autowired
    private final CategoriaService categoriaService;
	@Autowired
	private final LibroCategoriaService libroCategoriaService;
	@Autowired
	private PdfService pdfService;
	
	
    @GetMapping("/listado")
    public String libros(Model model, HttpSession sesion) {
    	List<CategoriaEntity> listarCategorias= categoriaService.listadoCategorias();
        List<LibroEntity> listaLibros = libroService.listadoLibros();
        model.addAttribute("categorias", listarCategorias);
		model.addAttribute("editoriales", editorialRepository.findAll());
        model.addAttribute("libros", listaLibros);
        return "catalogoAdmi"; 
    }
    @GetMapping("/registrar")
    public String mostrarFormularioAgregarLibro(Model model) {
        
        List<AutorEntity> listarAutores = autorService.listadoAutores();
        List<CategoriaEntity> listarCategoriaLibros = categoriaService.listadoCategorias();
		List<EditorialEntity> listadoEditorial = editorialService.listadoEditoriales();
        List<LibroCategoriaEntity> litarListas = libroCategoriaService.listarTodosCategoriaLibro();

        model.addAttribute("autores", listarAutores);
        model.addAttribute("categorias", listarCategoriaLibros);
		model.addAttribute("editoriales", listadoEditorial);
        model.addAttribute("libro", new LibroEntity()); 
        return "pagLibros";
    }

    @PostMapping("/registrar")
    public String registrarLibro(@ModelAttribute("libro") LibroEntity libroEntity, 
    		Model model, @RequestParam("foto") MultipartFile imagen) {
    	List<AutorEntity> listarAutores = autorService.listadoAutores();
    	List<CategoriaEntity> CategoriaLibros = categoriaService.listadoCategorias();
    	model.addAttribute("autores", listarAutores);
    	model.addAttribute("categorias", CategoriaLibros);
    	model.addAttribute("libro", new LibroEntity());
    	libroService.registrarLibro(libroEntity, imagen);
    	return "redirect:/libro/listado";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") String id) {
    	libroService.eliminarLibro(id);
    	return "redirect:/libro/listado";
    }
    @GetMapping("/pdf_libros")
	public ResponseEntity<InputStreamResource>generarPDF(HttpSession sesion)throws IOException{
		List<LibroEntity> lstLibros = libroService.listadoLibros();
		
		Map<String, Object> datosPdf = new HashMap<>();
	    datosPdf.put("libros", lstLibros);
	    
	    ByteArrayInputStream pdfBytes = pdfService.generarPdf("libros_pdf", datosPdf);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "inline; filename=libros.pdf");
	    
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(pdfBytes));
	
	}
}