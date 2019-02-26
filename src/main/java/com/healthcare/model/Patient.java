package com.healthcare.model;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "patient_tbl")
public class Patient {
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	@Column(name = "gender")
	private String gender;

	//@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	
    //@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JsonIgnore
	private Hospital hospital;

	//fetch=FetchType.EAGER, 
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Examination> examination=new ArrayList<>();
	
	

	public Patient() {
		super();
	}

	public Patient(Long id, String name, Date dateofbirth, String gender, Hospital hospital,
			List<Examination> examination) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.hospital = hospital;
		this.examination = examination;
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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Examination> getExamination() {
		return examination;
	}

	public void setExamination(List<Examination> examination) {
		this.examination = examination;
	}

}
