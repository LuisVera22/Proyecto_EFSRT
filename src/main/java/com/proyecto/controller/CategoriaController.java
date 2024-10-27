package com.proyecto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.model.CategoriaEntity;
import com.proyecto.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listarCategorias(Model model) {
        List<CategoriaEntity> categorias = categoriaService.listadoCategorias();
        model.addAttribute("categorias", categorias);
        return "listCategorias"; 
    }

    

    @PostMapping("/registrar")
    public String registrarCategoria(@ModelAttribute CategoriaEntity categoria) {
        categoriaService.registrarCategoria(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        CategoriaEntity categoria = categoriaService.buscarCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoriaInfo"; 
    }

    @PostMapping("/editar/{id}")
    public String actualizarCategoria(@PathVariable("id") Integer id, @ModelAttribute CategoriaEntity categoria) {
        categoriaService.actualizarCategoria(id, categoria);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Integer id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/listar";
    }
}
