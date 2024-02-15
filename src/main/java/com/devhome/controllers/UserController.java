package com.devhome.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "user/list";
	}

	@GetMapping("novo")
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/cadastre"; // REDIRECIONAR PARA A PAGINA DE PERFIL OU MENU DO USUÁRIO
	}

	@PostMapping("novo")
	public String create(@ModelAttribute @Validated User user, BindingResult result) {
		userService.create(user);
		return "redirect:/usuario";
	}

	@GetMapping("editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}

	@PostMapping("editar/{id}")
	public String update(@PathVariable Long id, @ModelAttribute User user) {
		userService.update(id, user);
		return "redirect:/usuario";
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/usuario";
	}

	@GetMapping(value = "/img/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] img(@PathVariable("id") Long id) {
		User user = this.userService.getById(id);
		return user.getImgBytes();
	}

}