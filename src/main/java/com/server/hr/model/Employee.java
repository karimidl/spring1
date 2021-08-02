package com.server.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String matricule;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	private String cin;
	private String email;
	private String tele;
	private String diplome;
	private String specialite;
	@Temporal(TemporalType.DATE)
	private Date hire_date;
	private String poste_budgetaire;
	private String service_affectation;
	private String localite;
	private String photo;
	private Boolean isArchived = false;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee", orphanRemoval = true)
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Set<Leave> leaves = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {
	}

	public Employee(Long id, String matricule, String nom, String prenom, Date date_naissance, String cin, String email,
			String tele, String diplome, String specialite, Date hire_date, String poste_budgetaire,
			String service_affectation, String localite, String photo, Department department) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.cin = cin;
		this.email = email;
		this.tele = tele;
		this.diplome = diplome;
		this.specialite = specialite;
		this.hire_date = hire_date;
		this.poste_budgetaire = poste_budgetaire;
		this.service_affectation = service_affectation;
		this.localite = localite;
		this.photo = photo;
		this.leaves = new HashSet<>();
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getPoste_budgetaire() {
		return poste_budgetaire;
	}

	public void setPoste_budgetaire(String poste_budgetaire) {
		this.poste_budgetaire = poste_budgetaire;
	}

	public String getService_affectation() {
		return service_affectation;
	}

	public void setService_affectation(String service_affectation) {
		this.service_affectation = service_affectation;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves.clear();
		if (leaves != null) {
			this.leaves.addAll(leaves);
		}
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom
				+ ", date_naissance=" + date_naissance + ", cin=" + cin + ", email=" + email + ", tele=" + tele
				+ ", diplome=" + diplome + ", specialite=" + specialite + ", hire_date=" + hire_date
				+ ", poste_budgetaire=" + poste_budgetaire + ", service_affectation=" + service_affectation
				+ ", localite=" + localite + ", photo=" + photo + ", leaves=" + leaves + ", department=" + department
				+ "]";
	}

	public Boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}

}