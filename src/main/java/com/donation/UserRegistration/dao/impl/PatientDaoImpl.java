package com.donation.UserRegistration.dao.impl;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.dto.Patient;

import java.util.List;

public class PatientDaoImpl implements PatientDao {
    @Override
    public List<Patient> findAll() {
        return List.of();
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }

    @Override
    public void save(Patient patient) {

    }

    @Override
    public void deleteById(Long id) {

    }
}