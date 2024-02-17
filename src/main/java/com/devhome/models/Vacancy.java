package com.devhome.models;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime candidacy = LocalDateTime.now();

	public enum Sector {
		Frontend, Backend, Fullstack
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sector sector;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	public Vacancy() {

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCandidacy() {
		return candidacy;
	}

	public void setCandidacy(LocalDateTime candidacy) {
		this.candidacy = candidacy;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Override
	public int hashCode() {
		return Objects.hash(candidacy, description, enterprise, id, name, sector);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacancy other = (Vacancy) obj;
		return Objects.equals(candidacy, other.candidacy) && Objects.equals(description, other.description)
				&& Objects.equals(enterprise, other.enterprise) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && sector == other.sector;
	}

	@Override
	public String toString() {
		return "Vacancy [id=" + id + ", name=" + name + ", description=" + description + ", candidacy=" + candidacy
				+ ", sector=" + sector + ", enterprise=" + enterprise + "]";
	}

}