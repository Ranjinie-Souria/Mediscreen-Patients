package com.mediscreen.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

//	/**
//	 * Shows the form to add a new patient
//	 * @param patient A patient object
//	 * @return The form page
//	 */
//    @GetMapping("/patients/add")
//    public ModelAndView addPatient(Patient patient) {
//    	logger.info("Showing add form");
//        return new ModelAndView("patients/add");
//    }
    
	/**
	 * Create - Adds the new patient
	 * @param patient The new patient
	 * @return all patients
	 */
    @PostMapping("/patients")
    public List<Patient> validatePatient(@RequestBody Patient patient) {
		patientService.savePatient(patient);
		logger.info("Added patient : "+ patient.getFirstName()+" "+patient.getFamilyName());
        return patientService.getPatients();
    }


}
