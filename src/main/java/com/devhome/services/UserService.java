package com.devhome.services;

import java.util.List;
import com.devhome.models.User;

public interface UserService {

	List<User> getAllUser();

	User getById(Long id);

	User create(User create);

	User update(Long id, User update);

	void delete(Long id);

}