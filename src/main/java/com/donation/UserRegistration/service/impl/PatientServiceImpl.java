package com.donation.UserRegistration.service.impl;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public List<Patient> findAllPatients() {
        return patientDao.findAll();
    }

    /*public Optional<Patient> findPatientById(Long id) {
        return patientDao.findById(id);
    }*/

    public Patient savePatient(Patient patient) {
        return patientDao.save(patient);
    }

    /*public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }*/

}