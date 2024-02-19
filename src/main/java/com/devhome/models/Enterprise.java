package com.devhome.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String cnpj;

	@Column(columnDefinition = "TEXT")
	private String sector;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = ISO.DATE)
	private Date foundation;
	
	@Column(nullable = false)
	private String contact;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "enterprise")
	private List<Vacancy> vacancy;

	public Enterprise() {

	}

	public Enterprise(Long id, String name, String cnpj, String sector, Date foundation, String contact,
			String address, String email, List<Vacancy> vacancy) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.sector = sector;
		this.foundation = foundation;
		this.contact = contact;
		this.address = address;
		this.email = email;
		this.vacancy = vacancy;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getFoundation() {
		return foundation;
	}

	public void setFoundation(Date foundation) {
		this.foundation = foundation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Vacancy> getVacancy() {
		return vacancy;
	}

	public void setVacancy(List<Vacancy> vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", sector=" + sector + ", foundation="
				+ foundation + ", contact=" + contact + ", address=" + address + ", email=" + email + ", vacancy="
				+ vacancy + "]";
	}

}