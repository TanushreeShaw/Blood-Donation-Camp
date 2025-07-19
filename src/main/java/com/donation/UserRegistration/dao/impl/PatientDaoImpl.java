package com.donation.UserRegistration.dao.impl;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.dto.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class PatientDaoImpl implements PatientDao {
    @Override
    public List<Patient> findAll() {
        return List.of();
    }

    /*@Override
    public Optional<Patient> findById(Long id) {
        return null;
    }

    @Override
    public Object save(Patient patient) {

        return null;
    }

    @Override
    public void deleteById(Long id) {

    }*/
}
