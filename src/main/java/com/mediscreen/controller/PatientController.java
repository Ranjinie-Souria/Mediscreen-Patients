package com.mediscreen.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/patients")
    public List<Patient> getPatients()
    {
    	return patientService.getPatients();
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
	 * @param result BindingResult object
	 * @return all patients
	 */
    @PostMapping("/patients/validate")
    public List<Patient> validatePatient(Patient patient, BindingResult result) {
		patientService.savePatient(patient);
		logger.info("Added patient : "+ patient.getFirstName()+" "+patient.getFamilyName());
        return patientService.getPatients();
    }


}
