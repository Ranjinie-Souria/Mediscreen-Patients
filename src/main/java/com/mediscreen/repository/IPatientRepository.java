package com.mediscreen.repository;

import java.util.List;

import com.mediscreen.model.Patient;

public interface IPatientRepository{

	/**
	 * @param name - the name of the Patient to find
	 * @return the Patient
	 */
	public Patient findByName(String name);	

	/**
	 * @return all the Patients
	 */
	public List<Patient> findAll();

	/**
	 * @param name - the name of the Patient to delete
	 */
	public void deleteByName(String name);

	/**
	 * @param person - the Patient to save
	 */
	public void save(Patient patient);

	
}
