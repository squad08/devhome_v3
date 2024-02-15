package com.devhome.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String authority;

	@ManyToMany(mappedBy = "role")
	private List<User> user = new ArrayList<>();

	public Role() {

	}

	public Role(Long id, String authority, List<User> user) {
		this.id = id;
		this.authority = authority;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String value) {
		this.authority = value;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> value) {
		this.user = value;
	}

}