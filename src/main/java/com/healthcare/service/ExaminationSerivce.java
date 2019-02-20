package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Examination;
import com.healthcare.repository.ExaminationRepository;

@Service
public class ExaminationSerivce {

	@Autowired
	ExaminationRepository examinationRepository;

	public Examination addExamination(Examination examination) {
		return examinationRepository.save(examination);

	}

	public List<Examination> getAllExaminations() {
		List<Examination> examinations = new ArrayList<>();
		examinationRepository.findAll().forEach(examinations::add);
		return examinations;

	}

	public Optional<Examination> GetExaminationById(Long id) {
		return examinationRepository.findById(id);
	}

	public void delete(long eid) {
		examinationRepository.deleteById(eid);
	}

	public Examination updateExamination(Long eid, Examination examination) {
		examination.setEid(eid);

		return examinationRepository.save(examination);
	}
}
