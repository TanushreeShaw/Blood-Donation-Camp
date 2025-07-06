package com.donation.UserRegistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    public List<Patient> findAllPatients() {
        return patientDao.findAll();
    }

    public Patient findPatientById(Long id) {
        return patientDao.findById(id).orElse(null);
    }

    public void savePatient(Patient patient) {
        return patientDao.save(patient);
    }

    public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }

}