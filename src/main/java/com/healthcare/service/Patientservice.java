package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Hospital;
import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepository;

@Service
public class Patientservice {

	@Autowired
	PatientRepository patientRepository;

	/*
	 * public Patient save(Patient patient) { return
	 * patientRepository.save(patient); }
	 * 
	 * public List<Patient> getAllPatients() { List<Patient> patient = new
	 * ArrayList<>(); patientRepository.findAll().forEach(patient::add); return
	 * patient; // return patientRepository.findAll(); }
	 * 
	 * public Patient findByPatientId(Long pid) { return
	 * patientRepository.getOne(pid); }
	 * 
	 * public void delte(long pid) { patientRepository.deleteById(pid);
	 * 
	 * }
	 */
	 public List<Patient> getAllPatients() { 
		 List<Patient> patient = new ArrayList<>();
			 patientRepository.findAll().forEach(patient::add); 
			 return patient; 
	 }

	// find patients by hospital id
	public List<Patient> getAllPatients(Long id) {
		List<Patient> patient = new ArrayList<>();
		patientRepository.findByHospitalId(id).forEach(patient::add);
		return patient;
		// return patientRepository.findAll();
	}

	public Patient findByPatientId(Long id) {
		return patientRepository.findById(id).map(patient->{
			return patient;
		}).orElseThrow(()->new RuntimeException("ID not foud"));
	}
	public List<Patient> findByPatientGender(String gender) {
		return patientRepository.findByGender(gender);
	}

	public Patient save(Long id, Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public void delete(Long pid) {
		patientRepository.deleteById(pid);

	}
}
