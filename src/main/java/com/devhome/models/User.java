package com.devhome.models;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false, length = 80)
	private String name;

	@Column(nullable = true, name = "birth")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birth;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(nullable = true, length = 15)
	private String contact;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Lob
	@Column(name = "img", columnDefinition = "LONGBLOB")
	private byte[] imgBytes;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> role = new ArrayList<>();

	public User() {

	}

	public User(Long id, String name, LocalDate birth, String cpf, String contact, String email, String password,
			byte[] imgBytes, List<Role> role) {
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.cpf = cpf;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.imgBytes = imgBytes;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate value) {
		this.birth = value;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String value) {
		this.cpf = value;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String value) {
		this.contact = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public byte[] getImgBytes() {
		return imgBytes;
	}

	public void setImgBytes(byte[] value) {
		this.imgBytes = value;
	}

	public void setImg(MultipartFile img) throws IOException {
		this.imgBytes = img.getBytes();
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> value) {
		this.role = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imgBytes);
		result = prime * result + Objects.hash(birth, contact, cpf, email, id, name, password, role);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(contact, other.contact)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Arrays.equals(imgBytes, other.imgBytes) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birth=" + birth + ", cpf=" + cpf + ", contact=" + contact
				+ ", email=" + email + ", password=" + password + ", imgBytes=" + Arrays.toString(imgBytes) + ", role="
				+ role + "]";
	}

}