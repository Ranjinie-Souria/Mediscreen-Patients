package com.mediscreen.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientService;


@RestController
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	/**
	 * Shows all patients
	 * @return all patients
	 */
	@GetMapping("/patients")
    public List<Patient> getPatients()
    {
    	return patientService.getPatients();
    }
	
	/**
	 * Shows one patient
	 * @return a patient
	 */
	@GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable int id)
    {
    	return patientService.getPatientById(id).get();
    }
    
	/**
	 * Create - Adds the new patient
	 * @param patient The new patient
	 * @return all patients
	 */
    @PostMapping("/patients")
    public ResponseEntity<Patient> validatePatient(@RequestBody Patient patient) {
		Patient patientAdded = patientService.savePatient(patient);
		if (Objects.isNull(patientAdded)) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/patients/{id}")
				.buildAndExpand(patientAdded.getPatientId())
				.toUri();
		return ResponseEntity.created(location).build();
    }


}
