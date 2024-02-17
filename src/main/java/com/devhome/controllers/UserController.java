package com.devhome.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.devhome.models.User;
import com.devhome.services.UserService;

@Controller
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String list(Model model) {
		List<User> user = userService.getAllUser();
		model.addAttribute("user", user);
		model.addAttribute("title", " Lista de usuários ");
		return "user/list";
	}

	@GetMapping(value = { "novo", "new" })
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", " Cadastro de usuário ");
		return "user/cadastre"; // REDIRECIONAR PARA A PAGINA DE PERFIL OU MENU DO USUÁRIO
	}

	@PostMapping(value = { "novo", "new" })
	public String create(@ModelAttribute @Validated User user, BindingResult result) {
		userService.create(user);
		return "redirect:/usuario";
	}

	@GetMapping(value = { "editar/{id}", "edit/{id}" })
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", " Editar usuário ");
		return "user/edit";
	}

	@PostMapping(value = { "editar/{id}", "edit/{id}" })
	public String update(@PathVariable Long id, @ModelAttribute User user) {
		userService.update(id, user);
		return "redirect:/usuario";
	}

	@GetMapping(value = { "deletar/{id}", "delete/{id}" })
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/usuario";
	}

	@GetMapping(value = "/img/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] img(@PathVariable Long id) {
		User user = this.userService.getById(id);
		return user.getImgBytes();
	}

	@PostMapping({ "/img", "/{id}/editar" })
	public ModelAndView img(@ModelAttribute User user, @RequestParam MultipartFile img) {
		try {
			user.setImg(img);
			User userImg = userService.update(null, user);
			ModelAndView page = new ModelAndView("redirect:/usuario");
			return page;

		} catch (IOException e) {
			ModelAndView errorPage = new ModelAndView("error");
			errorPage.addObject("error", "Erro ao processar a imagem.");
			return errorPage;
		}
	}

//	@GetMapping(value = "/img/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
//	@ResponseBody
//	public byte[] img2(@PathVariable("id") Long id) {
//		User user = this.userService.getById(id);
//		return user.getImgBytes();
//	}
//	
//	@PostMapping({ "/img", "/{id}/editar" })
//	public ModelAndView salvarPoste(@ModelAttribute User user, @RequestParam("imagem") MultipartFile imagem) {
//		try {
//			user.setImg(imagem);
//			User imagemSalve = userService.create(id);
//			ModelAndView page = new ModelAndView("redirect:/usuario");
//			return page;
//		} catch (IOException e) {
//			ModelAndView errorPage = new ModelAndView("error");
//			errorPage.addObject("error", "Erro ao processar a imagem.");
//			return errorPage;
//		}
//	}

}