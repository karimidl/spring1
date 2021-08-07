package com.server.hr.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Table(name = "LeaveType")
@Entity
public class LeaveType implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(unique=true)
	private String nom;
	private int nbrJour;
	
	
	@JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "leave", orphanRemoval = true)
	private Leave leave;

	public LeaveType() {
		super();
	}

	public LeaveType(Long id, String nom, int nbrJour, Leave leave) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbrJour = nbrJour;
		this.leave = leave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbrJour() {
		return nbrJour;
	}

	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	
	
	

}
