package com.donation.UserRegistration.service;

import com.donation.UserRegistration.dto.Patient;

import java.util.List;

/**
 * Service interface for managing patients.
 * This interface defines methods for CRUD operations on Patient entities.
 * Implementations of this interface will provide the actual business logic.
 *
 */
public interface PatientService {

    List<Patient> findAllPatients();

    void savePatient(Patient patient);

    Patient findPatientById(Long id);

    void deletePatient(Long id);

}