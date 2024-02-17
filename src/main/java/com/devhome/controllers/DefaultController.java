package com.devhome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping(value = { "/", "inicio", "home" })
	public String index(Model model) {
		model.addAttribute("title", " Início ");
		return "index";
	}

	@GetMapping(value = { "sobre", "about" })
	public String about(Model model) {
		model.addAttribute("title", " Sobre ");
		return "default/about";
	}

	@GetMapping(value = { "servico", "service" })
	public String services(Model model) {
		model.addAttribute("title", " Serviços ");
		return "default/service";
	}

	@GetMapping(value = { "contato", "contact" })
	public String contact(Model model) {
		model.addAttribute("title", " Contato ");
		return "default/contact";
	}

//	@GetMapping(value = { "perguntas-frequentes", "faq"})
//	public String contact(Model model) {
//		model.addAttribute("title", " FAQ ");
//		return "default/faq";
//	}

	@GetMapping(value = { "entrar", "login" })
	public String login(Model model) {
		model.addAttribute("title", " Entrar ");
		return "user/login";
	}

	@GetMapping(value = { "painel", "dashboard" })
	public String adm(Model model) {
		model.addAttribute("title", " Painel ADM ");
		return "adm/dashboard";
	}

	@GetMapping("menu")
	public String menu(Model model) {
		model.addAttribute("title", " Menu ADM ");
		return "adm/menu";
	}

	@GetMapping(value = { "trilhas", "trails" })
	public String modules(Model model) {
		model.addAttribute("title", " Trilhas ");
		return "course/trilhas";
	}

	@GetMapping("frontend")
	public String moduleFront(Model model) {
		model.addAttribute("title", " Front-End ");
		return "course/frontend";
	}

	@GetMapping("backend")
	public String moduleBck(Model model) {
		model.addAttribute("title", " Back-End ");
		return "course/backend";
	}

	@GetMapping("fullstack")
	public String moduleFullstacl(Model model) {
		model.addAttribute("title", " Full-Stack ");
		return "course/fullstack";
	}

}