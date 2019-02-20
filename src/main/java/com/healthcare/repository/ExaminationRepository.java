package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Examination;
@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long>{
	

}
