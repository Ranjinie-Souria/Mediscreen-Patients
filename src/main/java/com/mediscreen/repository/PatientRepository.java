package com.mediscreen.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mediscreen.model.Patient;

@Repository
public class PatientRepository implements IPatientRepository{

	@Override
	public Patient findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		
	}

}
