package com.donation.UserRegistration.service;

import com.donation.UserRegistration.dto.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatients();

    void savePatient(Patient patient);

    Patient findPatientById(Long id);

    void deletePatient(Long id);

}