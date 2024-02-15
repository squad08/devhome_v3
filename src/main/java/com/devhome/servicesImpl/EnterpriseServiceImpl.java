package com.devhome.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devhome.models.Enterprise;
import com.devhome.repositories.EnterpriseRepository;
import com.devhome.services.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Override
	public List<Enterprise> getAllEnterprise() {
		return enterpriseRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Enterprise getById(Long id) {
		return enterpriseRepository.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public Enterprise create(Enterprise enterprise) {
		return enterpriseRepository.save(enterprise);

	}

	@Override
	public Enterprise update(Long id, Enterprise update) {
		Enterprise up = enterpriseRepository.findById(id).orElse(null);

		if (up != null) {
			up.setName(update.getName());
			up.setSector(update.getSector());
			up.setCnpj(update.getCnpj());
			up.setFoundation(update.getFoundation());
			up.setContact(update.getContact());
			up.setEmail(update.getEmail());
			up.setAddress(update.getAddress());
			return enterpriseRepository.save(up);

		} else {
			throw new RuntimeException("Empresa com o ID" + id + ", não encontrada.");

		}

	}

	@Override
	public void delete(Long id) {
		enterpriseRepository.deleteById(id);

	}

}