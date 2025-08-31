package com.donation.UserRegistration.dao;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Data Access Object (DAO) interface for Patient entity.
 * This interface extends JpaRepository to provide CRUD operations for Patients.
 */
public interface PatientDao extends JpaRepository<Patient, Long> {

    // This interface extends JpaRepository to provide CRUD operations for the Patient entity.
    // No additional methods are needed as JpaRepository provides all necessary methods.

}
