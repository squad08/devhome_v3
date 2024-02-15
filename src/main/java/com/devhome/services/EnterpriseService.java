package com.devhome.services;

import java.util.List;

import com.devhome.models.Enterprise;

public interface EnterpriseService {

	List<Enterprise> getAllEnterprise();

	Enterprise getById(Long id);

	Enterprise create(Enterprise create);

	Enterprise update(Long id, Enterprise update);

	void delete(Long id);

}