package com.healthcare.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hospital_tbl")
public class Hospital implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6366524364998085948L;
	@Id
	@Column(name = "hospital_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;




	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	private List<Patient> patient=new ArrayList<>();
	
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
	
	
	public List<Patient> getPatient() {
		return patient;
	}
	
	
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	

	


}
