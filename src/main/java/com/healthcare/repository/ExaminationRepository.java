package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Examination;
import com.healthcare.model.Patient;
@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long>{
	  public List<Examination> findByPatientId(Long id);

}
