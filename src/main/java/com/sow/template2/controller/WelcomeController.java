package com.sow.template2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "welcome";
	}

	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("message", message);
		return "welcome";
	}
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return "Hello, World!";
	}

}
