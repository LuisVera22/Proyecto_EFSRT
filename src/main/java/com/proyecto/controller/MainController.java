package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lb")
@RequiredArgsConstructor
public class MainController {

	@GetMapping("/index")
	public String main(Model model) {
		
		return "index";
	}
}

