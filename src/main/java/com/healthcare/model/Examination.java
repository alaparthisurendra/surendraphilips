package com.healthcare.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "examination_tbl")
public class Examination {
	
	@Id
	@Column(name = "examination_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column
	@Temporal(TemporalType.DATE)
	private Date examDate;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "height")
	private Integer height;

	//@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	//@JsonBackReference
	//@JoinColumn(name="patient_fk_id")
	
	 @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	 @JsonIgnore
	private Patient patient;
	

	public Examination() {
		super();
	}


	public Examination(Long id, Date examDate, String name, String description, Double weight, Integer height,
			Patient patient) {
		super();
		this.id = id;
		this.examDate = examDate;
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.height = height;
		this.patient = patient;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getExamDate() {
		return examDate;
	}


	public void setExamDate(Date examDate) {
		this.examDate = examDate;
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


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	

}
