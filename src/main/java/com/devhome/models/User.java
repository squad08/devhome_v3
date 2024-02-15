package com.devhome.models;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public byte[] getImgBytes() {
		return imgBytes;
	}

	public void setImgBytes(byte[] imgBytes) {
		this.imgBytes = imgBytes;
	}

	public void setImg(MultipartFile img) throws IOException {
		this.imgBytes = img.getBytes();
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birth=" + birth + ", cpf=" + cpf + ", contact=" + contact
				+ ", email=" + email + ", password=" + password + ", imgBytes=" + Arrays.toString(imgBytes) + ", role="
				+ role + "]";
	}

}