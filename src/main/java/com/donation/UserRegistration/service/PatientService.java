package com.donation.UserRegistration.service;

public class PatientService {

    List<Patient> findAllPatients();

    Patient findPatientById(Long id);

    void savePatient(Patient patient);

    void deletePatient(Long id);

}