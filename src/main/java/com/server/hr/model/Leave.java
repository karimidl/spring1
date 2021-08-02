package com.server.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "conje")
public class Leave implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;

	@Column(name = "type_conje")
	private String typeConje;

	@JsonFormat(pattern = "MM/dd/yyyy")
	@Column(name = "start_time")
	@Temporal(TemporalType.DATE)
	private Date date_debut;

	@JsonFormat(pattern = "MM/dd/yyyy")
	@Column(name = "end_time")
	@Temporal(TemporalType.DATE)
	private Date date_fin;

	@Column(name = "duree_conje")
	private Long dureeConge;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Leave() {

	}

	public Leave(Long id, String typeConje, Date date_debut, Date date_fin, Long dureeConge, Employee employee) {
		super();
		this.id = id;
		this.typeConje = typeConje;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.dureeConge = dureeConge;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeConje() {
		return typeConje;
	}

	public void setTypeConje(String typeConje) {
		this.typeConje = typeConje;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Long getDureeConge() {
		return dureeConge;
	}

	public void setDureeConge(Long dureeConge) {
		this.dureeConge = dureeConge;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Conje [id=" + id + ", TypeConje=" + typeConje + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", dureeConge=" + dureeConge  + "]";
	}

}