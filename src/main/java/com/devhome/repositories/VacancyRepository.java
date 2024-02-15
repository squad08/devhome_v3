package com.devhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhome.models.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

}