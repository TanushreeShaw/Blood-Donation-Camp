package com.donation.UserRegistration.dao;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientDao extends JpaRepository<Patient, Long> {

    /*List<Patient> findAll();

    //Optional<Patient> findById(Long id);

    Patient save(Patient patient);

    //void deleteById(Long id);*/
}
