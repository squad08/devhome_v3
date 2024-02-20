package com.devhome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

	@GetMapping(value = { "/", "inicio", "home" })
	public String index(Model model) {
		model.addAttribute("title", " Início ・ devHOME™ ・ devHOME™ ");
		return "index";
	}

	@GetMapping(value = { "sobre", "about" })
	public String about(Model model) {
		model.addAttribute("title", " Sobre ・ devHOME™ ");
		return "default/about";
	}

	@GetMapping(value = { "servico", "service" })
	public String services(Model model) {
		model.addAttribute("title", " Serviços ・ devHOME™ ");
		return "default/service";
	}

	@GetMapping(value = { "contato", "contact" })
	public String contact(Model model) {
		model.addAttribute("title", " Contato ・ devHOME™ ");
		return "default/contact";
	}

	@GetMapping(value = { "perguntas-frequentes", "faq"})
	public String faq(Model model) {
		model.addAttribute("title", " FAQ ・ devHOME™ ");
		return "default/faq";
	}

	@GetMapping(value = { "entrar", "login" })
	public String login(Model model) {
		model.addAttribute("title", " Entrar ・ devHOME™ ");
		return "user/login";
	}

	@GetMapping(value = { "painel", "dashboard" })
	public String adm(Model model) {
		model.addAttribute("title", " Painel ADM ・ devHOME™ ");
		return "adm/dashboard";
	}

	@GetMapping("menu")
	public String menu(Model model) {
		model.addAttribute("title", " Menu ADM ・ devHOME™ ");
		return "adm/menu";
	}

	@GetMapping(value = { "trilhas", "trails" })
	public String modules(Model model) {
		model.addAttribute("title", " Trilhas ・ devHOME™ ");
		return "course/trilhas";
	}

	@GetMapping("frontend")
	public String moduleFront(Model model) {
		model.addAttribute("title", " Front-End ・ devHOME™ ");
		return "course/frontend";
	}

	@GetMapping("backend")
	public String moduleBck(Model model) {
		model.addAttribute("title", " Back-End ・ devHOME™ ");
		return "course/backend";
	}

	@GetMapping("fullstack")
	public String moduleFullstacl(Model model) {
		model.addAttribute("title", " Full-Stack ・ devHOME™ ");
		return "course/fullstack";
	}

}