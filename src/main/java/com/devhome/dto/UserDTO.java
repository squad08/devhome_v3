package com.devhome.dto;

import java.time.LocalDate;
import java.util.List;

import com.devhome.models.Role;

public class UserDTO {

	private Long id;
	private String name;
	private LocalDate birth;
	private String cpf;
	private String contact;
	private String email;
	private String password;

	private List<Role> role;

	public UserDTO() {
	}

	public UserDTO(Long id, String name, LocalDate birth, String cpf, String contact, String email, String password,
			List<Role> role) {
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.cpf = cpf;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

}