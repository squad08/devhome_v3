package com.devhome.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devhome.models.User;
import com.devhome.repositories.UserRepository;
import com.devhome.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	@Transactional(readOnly = true)
	public User getById(Long id) {
		return userRepository.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public User create(User user) {
		return userRepository.save(user);

	}

	@Override
	public User update(Long id, User update) {
		User up = userRepository.findById(id).orElse(null);

		if (up != null) {
			up.setName(update.getName());
			up.setBirth(update.getBirth());
			up.setCpf(update.getCpf());
			up.setContact(update.getContact());
			up.setEmail(update.getEmail());
			up.setPassword(update.getPassword());
			up.setImgBytes(update.getImgBytes());
			return userRepository.save(update);

		} else {
			throw new RuntimeException("Usuário com ID " + id + ", não encontrado!");

		}

	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);

	}

}