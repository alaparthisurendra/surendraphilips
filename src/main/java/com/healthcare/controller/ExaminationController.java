package com.healthcare.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.healthcare.model.Examination;
import com.healthcare.model.Hospital;
import com.healthcare.model.Patient;
import com.healthcare.service.ExaminationSerivce;
import com.healthcare.service.Patientservice;

@RestController
/* @RequestMapping("/philips") */
@RequestMapping("/philips")
public class ExaminationController {

	@Autowired
	ExaminationSerivce examinationService;
	
	@Autowired
	Patientservice Patientservice;
/*
	@GetMapping("/examinations")
	public ResponseEntity<List<Examination>> getAllExaminations() {
		List<Examination> allExaminations = examinationService.getAllExaminations();
		if (allExaminations == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allExaminations);

	}

	@GetMapping("/examinations/{id}")
	public ResponseEntity<Examination> getExaminationById(@PathVariable(value = "id") final Long id) {
		Examination exa = examinationService.findByExaminationId(id);
		if (exa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(exa);

	}*/

	@GetMapping("/patients/{id}/examinations")
	public ResponseEntity<List<Examination>> getAllExaminations(@PathVariable(value="id") long id) {
		List<Examination> allexaminations = examinationService.getAllExaminations(id);
		if (allexaminations == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allexaminations);
	}

	@GetMapping("/patients/{id}/examinations/{id}")
	public ResponseEntity<Examination> getExaminationByIds(@PathVariable(value = "id") final Long id) {
		Examination exam = examinationService.findByExaminationId(id);
		if (exam == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(exam);

	}

	@PostMapping("/patients/{patientId}/examinations/")
	public ResponseEntity<Examination> addExamination(@RequestBody Examination examination, @PathVariable("patientId") Long patientId) {
		Examination addexam = new Examination();

		addexam.setId(examination.getId());
		addexam.setName(examination.getName());
		addexam.setExamDate(examination.getExamDate());
		addexam.setHeight(examination.getHeight());
		addexam.setWeight(examination.getWeight());
		addexam.setPatient(examination.getPatient());
		addexam.setDescription(examination.getDescription());
		
		Patient byPatientId = Patientservice.findByPatientId(patientId);
		examination.setPatient(byPatientId);
		
		

		Examination examination1 = examinationService.save(examination);
		return ResponseEntity.ok().body(examination1);

	}

	@PutMapping("/patients/{patientId}/examinations/{eid}/")
	public ResponseEntity<Examination> updateExamination(@PathVariable(value="patientId") Long patientId, @PathVariable(value="eid") Long eid,
			@Valid @RequestBody Examination examDetails) {
		Examination exam = examinationService.findByExaminationId(eid);
		if (exam == null) {
			return ResponseEntity.notFound().build();
		}
		exam.setId(examDetails.getId());
		exam.setName(examDetails.getName());
		exam.setExamDate(examDetails.getExamDate());
		exam.setWeight(examDetails.getWeight());
		exam.setDescription(examDetails.getDescription());
		//exam.setPatient(examDetails.getPatient());
		exam.setHeight(examDetails.getHeight());
		
		Patient patient=new Patient();
		patient.setId(patientId);
		exam.setPatient(patient);
		Examination examination = examinationService.save(eid, exam);
		//Examination examination=examinationService.save(exam);

		return ResponseEntity.ok().body(examination);
	}
	
	
	@DeleteMapping("/patients/{patientId}/examinations/{eid}/")
	public ResponseEntity<Examination> deleteExamination(@PathVariable(value = "eid") Long eid) {
		examinationService.delete(eid);
		
		return ResponseEntity.ok().build();

	}
}