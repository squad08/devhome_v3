package com.devhome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devhome.models.Enterprise;
import com.devhome.services.EnterpriseService;

@Controller
@RequestMapping("empresa")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping
	public String list(Model model) {
		List<Enterprise> enterprise = enterpriseService.getAllEnterprise();
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("title", " Lista de empresas ");
		return "enterprise/list";
	}

	@GetMapping(value = { "novo", "new" })
	public String showFormForAdd(Model model) {
		Enterprise enterprise = new Enterprise();
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("title", " Cadastro de empresa ");
		return "enterprise/cadastre";
	}

	@PostMapping(value = { "novo", "new" })
	public String create(@ModelAttribute @Validated Enterprise enterprise, BindingResult result) {
		enterpriseService.create(enterprise);
		return "redirect:/empresa";
	}

	@GetMapping(value = { "editar/{id}", "edit/{id}" })
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Enterprise enterprise = enterpriseService.getById(id);
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("title", " Editar empresa ");
		return "enterprise/edit";
	}

	@PostMapping(value = { "editar/{id}", "edit/{id}" })
	public String update(@PathVariable Long id, @ModelAttribute Enterprise enterprise) {
		enterpriseService.update(id, enterprise);
		return "redirect:/empresa";
	}

	@GetMapping(value = { "deletar/{id}", "delete/{id}" })
	public String delete(@PathVariable Long id, Model model) {
		try {
			enterpriseService.delete(id);

		} catch (DataIntegrityViolationException e) {
			String mensagem = "Não é possível excluir a empresa no momento, pois existem vagas associadas a ela.";
			model.addAttribute("mensagem", mensagem);

		} catch (Exception e) {

		}
		return "redirect:/empresa";
	}

}