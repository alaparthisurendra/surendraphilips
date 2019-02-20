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

import com.healthcare.model.Examination;
import com.healthcare.service.ExaminationSerivce;

@RestController
@RequestMapping("/philips")
public class ExaminationController {

	@Autowired
	ExaminationSerivce examinationService;

	@GetMapping("/examinations")
	public ResponseEntity<List<Examination>> getAllExaminations()
	{
		List<Examination> allExaminations = examinationService.getAllExaminations();
		if(allExaminations==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allExaminations);
	}
	
	@GetMapping("/examinations/{eid}")
	public ResponseEntity<Optional<Examination>> getExaminationById(@PathVariable(value="eid") long eid)
	{
		Optional<Examination> getExaminationById = examinationService.GetExaminationById(eid);
		if(getExaminationById==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(getExaminationById);
	}
	
	@PostMapping("/examinations")
    public ResponseEntity<Examination> addExamination(@RequestBody Examination examination)
    {
    	Examination addExamination = examinationService.addExamination(examination);
    	return ResponseEntity.ok().body(addExamination);
    }
	
	@DeleteMapping("/examinations/{eid}")
	public void DeleteExamination(@PathVariable(value="eid") long eid)
	{
		examinationService.delete(eid);
	}
	
	@PutMapping("/examinations/{eid}")
	public ResponseEntity<Examination> updateExamination(@PathVariable(value="eid") long eid, Examination examination){
		Examination updateExamination = examinationService.updateExamination(eid, examination);
		return ResponseEntity.ok().body(updateExamination);
	}
}