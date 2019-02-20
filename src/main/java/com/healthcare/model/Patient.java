package com.healthcare.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;

	@NotNull
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "dateofbirth")

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	@NotNull
	@Column(name = "gender")
	private String gender;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "patient_examination", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
			@JoinColumn(name = "examination_id") })
	private List<Examination> examinations;

	public Patient() {
		super();
	}

	public Patient(Long pid, String name, Date dateofbirth, String gender, List<Examination> examinations) {
		super();
		this.pid = pid;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.examinations = examinations;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

}
