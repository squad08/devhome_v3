package com.devhome.services;

import java.util.List;

import com.devhome.models.Vacancy;

public interface VacancyService {

	List<Vacancy> getAllVaga();

	Vacancy getById(Long id);

	Vacancy create(Vacancy create);

	Vacancy update(Long id, Vacancy update);

	void delete(Long id);

}