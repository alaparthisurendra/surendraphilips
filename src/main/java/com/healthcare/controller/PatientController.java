package com.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Patient;
import com.healthcare.service.Patientservice;

@RestController
@RequestMapping("/philips")
public class PatientController {

	@Autowired
	Patientservice patientService;

	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> allPatients = patientService.getAllPatients();
		if (allPatients == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allPatients);
	}

	@GetMapping("/patients/{pid}")
	public ResponseEntity<Optional<Patient>> getPatientById(@PathVariable(value = "pid") long pid) {
		Optional<Patient> patientById = patientService.getPatientById(pid);
		if (patientById == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(patientById);
	}

	@PostMapping("/patients")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient addPatient = patientService.addPatient(patient);
		return ResponseEntity.ok().body(addPatient);
	}

	@PutMapping("/patients/{pid}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "pid") long pid, Patient patient) {
		Patient updatePatient = patientService.updatePatient(pid, patient);
		return ResponseEntity.ok().body(updatePatient);
	}

	@DeleteMapping("/patients/{pid}")
	public void deletePatient(@PathVariable(value = "pid") Long pid) {
		patientService.Delete(pid);
	}
}
