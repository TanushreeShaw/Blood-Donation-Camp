package com.donation.UserRegistration.service;

import com.donation.UserRegistration.dto.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatients();

    Patient findPatientById(Long id);

    void savePatient(Patient patient);

    void deletePatient(Long id);

}