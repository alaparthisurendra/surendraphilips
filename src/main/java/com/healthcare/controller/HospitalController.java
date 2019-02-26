package com.healthcare.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;

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

import com.healthcare.model.Hospital;
import com.healthcare.model.Patient;
import com.healthcare.service.Hospitalservice;

@RestController
@RequestMapping("/philips")
public class HospitalController {

	@Autowired
	Hospitalservice hospitalService;


	@GetMapping("/hospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals() {
		//System.out.println("hello surendra alaparthi");
		List<Hospital> allHospitals = hospitalService.getAllHospitals();
		if (allHospitals == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allHospitals);

	}

	/* get hospital by id */
	@GetMapping("/hospitals/{id}")
	/* @GetMapping("/id/{id}") */
	public ResponseEntity<Hospital> getHospitalById(@PathVariable(value = "id") Long id) {
		Hospital hs = hospitalService.findById(id);
		if (hs == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(hs);
	}

	@PutMapping("/hospitals/{hid}")
	public ResponseEntity<Hospital> updateHospital(@PathVariable(value = "hid") Long hid,
			@Valid @RequestBody Hospital hospDetails) {
		Hospital hs = hospitalService.findById(hid);
		if (hs == null) {
			return ResponseEntity.notFound().build();
		}
		hs.setName(hospDetails.getName());
		hs.setId(hospDetails.getId());
		hs.setDescription(hospDetails.getDescription());
		hs.setPatient(hospDetails.getPatient());

		// save the value
		// Hospital updateHospital = hospitalservice.save(hs);
		Hospital updateHospital = hospitalService.update(hid, hs);

		return ResponseEntity.ok().body(updateHospital);
	}


	@PostMapping("/hospitals")
	@Consumes("application/json")
	public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
		Hospital addHospital = new Hospital();
		addHospital.setId(hospital.getId());
		addHospital.setName(hospital.getName());
		addHospital.setDescription(hospital.getDescription());
		for(Patient ref:hospital.getPatient()) {
			ref.setHospital(addHospital);
		}
		addHospital.setPatient(hospital.getPatient());
		Hospital addHosp = hospitalService.save(hospital);
		return ResponseEntity.ok().body(addHosp);

	}

	@DeleteMapping("/hospitals/{id}")
	public ResponseEntity<Hospital> deleteHospital(@PathVariable(value = "id") Long id) {
		hospitalService.delete(id);
		return ResponseEntity.ok().build();

	}

}
