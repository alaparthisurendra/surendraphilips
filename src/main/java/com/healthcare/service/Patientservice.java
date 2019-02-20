package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepository;

@Service
public class Patientservice {

	@Autowired
	PatientRepository patientRepository;

	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();
		patientRepository.findAll().forEach(patients::add);

		/*
		 * patients.stream().filter(p->p.getPid()>5000);
		 * 
		 * Collections.sort(patients,(a,b)->{ return a.getName().compareTo(b.getName());
		 * });
		 */

		return patients;

	}

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public void Delete(Long pid) {
		patientRepository.deleteById(pid);
	}

	public Patient updatePatient(Long pid, Patient patient) {
		patient.setPid(pid);
		return patientRepository.save(patient);
	}
}
