package com.devhome.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.devhome.models.User;
import com.devhome.services.UserService;

@Controller
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String list(Model model) {
		List<User> user = userService.getAllUser();
		model.addAttribute("user", user);
		model.addAttribute("title", " Lista de usuários ・ devHOME™ ");
		return "user/list";
	}

	@GetMapping(value = { "novo", "new" })
	public String showFormForAdd(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("title", " Cadastro de usuário ・ devHOME™ ");
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
		model.addAttribute("title", " Editar usuário ・ devHOME™ ");
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
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
		// Lógica para buscar a imagem do banco de dados com base no ID do usuário
		User user = userService.getById(id);

		// Verificação se a imagem existe
		if (user == null || user.getImgBytes() == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(user.getImgBytes());
	}

	@PostMapping("/img/{id}")
	public String handleImageUpload(@PathVariable Long id,
			@RequestParam(name = "img", required = false) MultipartFile img) {

		if (img != null && !img.isEmpty()) {
			try {
				User user = userService.getById(id);
				user.setImgBytes(img.getBytes());
				userService.update(id, user);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/usuario";
	}

}