package com.devhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhome.models.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

}