package com.nk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "main";
	}

}
