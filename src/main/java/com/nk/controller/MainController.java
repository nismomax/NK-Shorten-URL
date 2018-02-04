package com.nk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "main";
	}

}
