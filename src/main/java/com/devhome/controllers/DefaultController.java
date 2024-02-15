package com.devhome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping(value = { "/", "inicio", "home" })
	public String index(Model model) {
		model.addAttribute("title", " Início ・ DevHOME™ ");
		return "index";
	}

	@GetMapping(value = { "sobre", "about" })
	public String about(Model model) {
		model.addAttribute("title", " Sobre ・ DevHOME™ ");
		return "default/about";
	}

	@GetMapping(value = { "servico", "service" })
	public String services(Model model) {
		model.addAttribute("title", " Serviços ・ DevHOME™ ");
		return "default/services";
	}

	@GetMapping(value = { "contato", "contact" })
	public String contact(Model model) {
		model.addAttribute("title", " Contato ・ DevHOME™ ");
		return "default/contact";
	}

//	@GetMapping(value = { "perguntas-frequentes", "faq"})
//	public String contact(Model model) {
//		model.addAttribute("title", " FAQ ・ DevHOME™ ");
//		return "default/faq";
//	}

	@GetMapping(value = { "entrar", "login" })
	public String login(Model model) {
		model.addAttribute("title", " Entrar ・ DevHOME™ ");
		return "user/login";
	}

	@GetMapping(value = { "painel", "dashboard" })
	public String adm(Model model) {
		model.addAttribute("title", " Painel ADM ・ DevHOME™ ");
		return "adm/dashboard";
	}

	@GetMapping("menu")
	public String menu(Model model) {
		model.addAttribute("title", " Menu ADM ・ DevHOME™ ");
		return "adm/menu";
	}

	@GetMapping("trilhas")
	public String modules(Model model) {
		model.addAttribute("title", " Trilhas ・ DevHOME™ ");
		return "course/trilhas";
	}

	@GetMapping("frontend")
	public String moduleFront(Model model) {
		model.addAttribute("title", " Front-End ・ DevHOME™ ");
		return "course/frontend";
	}

	@GetMapping("backend")
	public String moduleBck(Model model) {
		model.addAttribute("title", " Back-End ・ DevHOME™ ");
		return "course/backend";
	}

	@GetMapping("fullstack")
	public String moduleFullstacl(Model model) {
		model.addAttribute("title", " Full-Stack ・ DevHOME™");
		return "course/fullstack";
	}

}