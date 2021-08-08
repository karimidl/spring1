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

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_time")
	@Temporal(TemporalType.DATE)
	private Date date_debut;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_time")
	@Temporal(TemporalType.DATE)
	private Date date_fin;

	@Column(name = "duree_conje")
	private Long dureeConge;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	
	@JsonBackReference(value="ref_leave")
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="leave_type_id")
	private LeaveType leaveType;
	
    private int restDays;
	public Leave() {

	}
	public Leave(Long id, String typeConje, Date date_debut, Date date_fin, Long dureeConge, Employee employee,
			LeaveType leaveType, int restDays) {
		super();
		this.id = id;
		this.typeConje = typeConje;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.dureeConge = dureeConge;
		this.employee = employee;
		this.leaveType = leaveType;
		this.restDays = restDays;
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
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public int getRestDays() {
		return restDays;
	}
	public void setRestDays(int restDays) {
		this.restDays = restDays;
	}
	@Override
	public String toString() {
		return "Leave [id=" + id + ", typeConje=" + typeConje + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", dureeConge=" + dureeConge + ", employee=" + employee + ", leaveType=" + leaveType + ", restDays="
				+ restDays + "]";
	}
    
}