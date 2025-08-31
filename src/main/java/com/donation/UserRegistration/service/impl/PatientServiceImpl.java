package com.donation.UserRegistration.service.impl;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.stereotype.Service;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.service.PatientService;

import java.util.List;

/**
 * Service implementation for managing patients.
 * This class implements the PatientService interface and provides
 * methods to perform CRUD operations on Patient entities.
 */
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    /**
     * Retrieves all patients from the database.
     *
     * @return A list of all patients.
     */
    public List<Patient> findAllPatients() {
        return patientDao.findAll();
    }

    /**
     * Finds a patient by their ID.
     *
     * @param id The ID of the patient to find.
     * @return The patient with the specified ID.
     * @throws RuntimeException if no patient is found with the given ID.
     */
    public Patient findPatientById(Long id) {
        return patientDao.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    /**
     * Saves a patient to the database.
     *
     * @param patient The patient to save.
     */
    public void savePatient(Patient patient) {
        patientDao.save(patient);
    }

    /**
     * Deletes a patient by their ID.
     *
     * @param id The ID of the patient to delete.
     */
    public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }

}