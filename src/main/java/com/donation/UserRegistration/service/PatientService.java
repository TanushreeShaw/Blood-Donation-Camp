package com.donation.UserRegistration.service;

import com.donation.UserRegistration.dto.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAllPatients();

    Optional<Patient> findPatientById(Long id);

    void savePatient(Patient patient);

    void deletePatient(Long id);

}