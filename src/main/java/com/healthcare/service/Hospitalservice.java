
package com.healthcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Hospital;
import com.healthcare.repository.HospitalRepository;

@Service
public class Hospitalservice {

	@Autowired
	HospitalRepository hospitalRepository;

	// to save an hospital

	public Hospital save(Hospital hospitals) {
		return hospitalRepository.save(hospitals);

	}

	/* search all hospital */
	public List<Hospital> getAllHospitals() {
		List<Hospital> hospital = new ArrayList<>();
		hospitalRepository.findAll().forEach(hospital::add);
		return hospital;
		// return hospitalRepository.findAll();
	}

	/* search by id */
	public Hospital findById(Long hid) {
		return hospitalRepository.getOne(hid);

	}

	/* delete by id */
	public void delete(Long hid) {
		hospitalRepository.deleteById(hid);

	}
	public Hospital update(long hid, Hospital hospital)
	{
		hospital.setId(hid);
		return hospitalRepository.save(hospital);
		
	}

}
