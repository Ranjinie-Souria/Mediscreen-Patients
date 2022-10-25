package com.mediscreen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mediscreen.model.Patient;
import com.mediscreen.service.PatientService;


@RestController
public class PatientController {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	/**
	 * Shows all patients
	 * @return A page with a list of the patients
	 */
    @RequestMapping("/patients")
    public ModelAndView home()
    {
    	logger.info("Showing all Patients");
    	ModelAndView mav = new ModelAndView();
        mav.addObject("patients", patientService.getPatients());
        mav.setViewName("patients/list");
        return mav;
    }

	/**
	 * Shows the form to add a new patient
	 * @param patient A patient object
	 * @return The form page
	 */
    @GetMapping("/patients/add")
    public ModelAndView addPatient(Patient patient) {
    	logger.info("Showing add form");
        return new ModelAndView("patients/add");
    }
    
	/**
	 * Create - Adds the new patient
	 * @param patient The new patient
	 * @param result BindingResult object
	 * @return The page with a list of all patients
	 */
    @PostMapping("/patients/validate")
    public ModelAndView validate(Patient patient, BindingResult result) {
		ModelAndView modelAndView =  new ModelAndView("redirect:/patients/");
		modelAndView.addObject("patients", patientService.getPatients());
		patientService.savePatient(patient);
		logger.info("Added patient : "+ patient.getFirstName()+" "+patient.getFamilyName());
        return modelAndView;
    }


}
