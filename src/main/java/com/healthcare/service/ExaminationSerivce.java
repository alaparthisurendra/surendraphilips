package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Examination;
import com.healthcare.model.Patient;
import com.healthcare.repository.ExaminationRepository;

@Service
public class ExaminationSerivce {
	

	@Autowired
	ExaminationRepository examinationRepository;

	public Examination save(Long eid,Examination examination) {
		return examinationRepository.save(examination);
	}
	
	public Examination save(Examination examination)
	{
		return examinationRepository.save(examination);
	}
	public List<Examination> getAllExaminations()
	{
		List<Examination> examination=new ArrayList<>();
		examinationRepository.findAll().forEach(examination::add);
		return examination;
		
	}

	public List<Examination> getAllExaminations(Long id) {
		List<Examination> examination=new ArrayList<>();
		examinationRepository.findByPatientId(id).forEach(examination::add);
		return examination;
		//return examinationRepository.findAll();
	}

	public Examination findByExaminationId(Long id) {
		return examinationRepository.findById(id).map(examination->{
			return examination;
		}).orElseThrow(()-> new RuntimeException("id not found"));
	}

	public void delete(long eid) {
		examinationRepository.deleteById(eid);
	}
	

	/*public void deleteAll() {
		examinationRepository.deleteAll();
	}*/
}
