package com.devhome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.devhome.models.Vacancy;
import com.devhome.services.EnterpriseService;
import com.devhome.services.VacancyService;

@Controller
@RequestMapping("/vaga")
public class VacancyController {

	@Autowired
	private VacancyService vacancyService;

	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping
	public String list(Model model) {
		List<Vacancy> vacancy = vacancyService.getAllVaga();
		model.addAttribute("vacancy", vacancy);
		model.addAttribute("title", " Lista de vagas ・ devHOME™ ");
		return "vacancy/list";
	}

	@GetMapping(value = { "novo", "new" })
	public String showFormForAdd(Model model) {
		Vacancy vacancy = new Vacancy();
		List<Enterprise> enterprise = enterpriseService.getAllEnterprise();
		model.addAttribute("vacancy", vacancy);
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("title", " Cadastro de vaga ・ devHOME™ ");
		return "vacancy/cadastre";
	}

	@PostMapping(value = { "novo", "new" })
	public String create(@ModelAttribute @Validated Vacancy vacancy, BindingResult result) {
		vacancyService.create(vacancy);
		return "redirect:/vaga";
	}

	@GetMapping(value = { "editar/{id}", "edit/{id}" })
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Vacancy vacancy = vacancyService.getById(id);
		List<Enterprise> enterprise = enterpriseService.getAllEnterprise();
		model.addAttribute("vacancy", vacancy);
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("title", " Editar vaga ・ devHOME™ ");
		return "vacancy/edit";
	}

	@PostMapping(value = { "editar/{id}", "edit/{id}" })
	public String update(@PathVariable Long id, @ModelAttribute Vacancy vacancy) {
		vacancyService.update(id, vacancy);
		return "redirect:/vaga";
	}

	@GetMapping(value = { "deletar/{id}", "delete/{id}" })
	public String delete(@PathVariable Long id) {
		vacancyService.delete(id);
		return "redirect:/vaga";
	}

	@GetMapping(value = { "oportunidades", "opportunity" })
	public String others(Model model) {
		List<Vacancy> vacancy = vacancyService.getAllVaga();
		model.addAttribute("vacancy", vacancy);
		model.addAttribute("title", " Vagas ・ devHOME™ ");
		return "vacancy/opportunity";
	}
}