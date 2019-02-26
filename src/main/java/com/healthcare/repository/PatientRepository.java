package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	//public List<Patient> getPatientByHos(Long Pid);
	
	  //we need method take an hospital id and return list of patients
	//hosptalid= hid
	  //public List<Patient> getPatientByHospital(long hid);
	
	//list all patients based on gender
	  //public List<Patient> getPatientByGender(String name);
	
	  public List<Patient> findByGender(String gender);
	  
	  public List<Patient> findByHospitalId(Long id);
	  

}
