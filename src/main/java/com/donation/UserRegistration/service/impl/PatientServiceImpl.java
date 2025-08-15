package com.donation.UserRegistration.service.impl;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.stereotype.Service;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public List<Patient> findAllPatients() {
        return patientDao.findAll();
    }

    public Patient findPatientById(Long id) {
        return patientDao.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public void savePatient(Patient patient) {
        patientDao.save(patient);
    }

    public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }

}