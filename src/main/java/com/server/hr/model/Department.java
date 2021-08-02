package com.server.hr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
	private Collection<Employee> employee;

	public Department() {
		super();
	}

	public Department(Long id, String nom/* , Employee employee */) {
		super();
		this.id = id;
		this.nom = nom;
		this.employee = new ArrayList<Employee>();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", nom=" + nom + ", employee=" + employee + "]";
	}

}
