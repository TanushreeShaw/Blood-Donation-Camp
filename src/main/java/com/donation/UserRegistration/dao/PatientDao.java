package com.donation.UserRegistration.dao;

import com.donation.UserRegistration.dto.Patient;

import java.util.List;

public interface PatientDao {

    List<Patient> findAll();

    Patient findById(Long id);

    void save(Patient patient);

    void deleteById(Long id);
}