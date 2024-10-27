package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MantenimientoController {

	@GetMapping("/mantenimiento")
	public String mantenimiento() {
		return "mantenimiento";
	}

	@GetMapping("/reportes")
	public String reportes() {
		return "reportes";
	}
}
