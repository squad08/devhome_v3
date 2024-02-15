package com.devhome.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devhome.models.Enterprise;
import com.devhome.models.Vacancy;
import com.devhome.repositories.EnterpriseRepository;
import com.devhome.repositories.VacancyRepository;
import com.devhome.services.VacancyService;

@Service
public class VacancyServiceImpl implements VacancyService {

	@Autowired
	private VacancyRepository vacancyRepository;

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Override
	public List<Vacancy> getAllVaga() {
		return vacancyRepository.findAll();

	}

	@Override
	@Transactional(readOnly = true)
	public Vacancy getById(Long id) {
		return vacancyRepository.findById(id).orElse(null);

	}

	@Override
	public Vacancy create(Vacancy vacancy) {
		Enterprise enterprise = enterpriseRepository.findById(vacancy.getEnterprise().getId()).orElse(null);

		if (enterprise != null) {
			vacancy.setEnterprise(enterprise);
			return vacancyRepository.save(vacancy);

		} else {
			throw new RuntimeException("Empresa com o ID " + vacancy.getEnterprise().getId() + ", não encontrada.");

		}

	}

	@Override
	public Vacancy update(Long id, Vacancy update) {
		Vacancy up = vacancyRepository.findById(id).orElse(null);
		if (up != null) {
			up.setName(update.getName());
			up.setDescription(update.getDescription());
			up.setCandidacy(update.getCandidacy());
			up.setSector(update.getSector());

			Enterprise enterprise = enterpriseRepository.findById(update.getEnterprise().getId()).orElse(null);

			if (enterprise != null) {
				up.setEnterprise(enterprise);

			} else {
				throw new RuntimeException("Empresa com o ID " + update.getEnterprise().getId() + ", não encontrada.");

			}

			return vacancyRepository.save(up);

		} else {
			throw new RuntimeException("Vaga com o ID " + id + ", não encontrada.");

		}
	}

	@Override
	public void delete(Long id) {
		vacancyRepository.deleteById(id);
	}

}