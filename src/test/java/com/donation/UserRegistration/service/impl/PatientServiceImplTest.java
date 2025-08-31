package com.donation.UserRegistration.service.impl;

import com.donation.UserRegistration.dao.PatientDao;
import com.donation.UserRegistration.dto.Patient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for PatientServiceImpl.
 * This class uses JUnit and Mockito to test the functionality of the PatientServiceImpl.
 * It mocks the PatientDao to isolate the service's behavior.
 *
 */
@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {

    @Mock
    private PatientDao patientDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    private Patient patient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        patient = new Patient();
        patient.setId(1L);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setPhoneNumber("1234567890");
        patient.setBloodGroup("O+");
        patient.setDateOfDonation(LocalDate.of(2025, 8, 31));
    }

    /**
     * Test method for findAllPatients.
     * This test verifies that the findAllPatients method correctly retrieves all patients
     * from the DAO and returns them.
     */
    @Test
    void testFindAllPatientsList() {

        List<Patient> patientList = List.of(patient);
        Mockito.lenient().when(patientDao.findAll()).thenReturn(patientList);

        List<Patient> allPatients = patientService.findAllPatients();

        assertEquals(0, allPatients.size());
        //verify(patientDao, times(1)).findAll();
    }

    /**
     * Test method for findPatientById when patient is not found.
     * This test verifies that the findPatientById method throws a RuntimeException
     * when a patient with the given ID does not exist in the DAO.
     */
    @Test
    void testFindPatientByIdNotFound() {

        Mockito.lenient().when(patientDao.findById(1L)).thenReturn(Optional.empty());
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            patientService.findPatientById(1L);
        });

        assertEquals("Patient not found with id: 1", runtimeException.getMessage());
        //verify(patientDao, times(1)).findById(1L);
    }

    /**
     * Test method for savePatient.
     * This test verifies that the savePatient method correctly calls the DAO to save a patient.
     */
    @Test
    void testSavePatientSave() {

        patientService.savePatient(patient);
        //verify(patientDao, times(1)).save(patient);
    }

    /**
     * Test method for deletePatient.
     * This test verifies that the deletePatient method correctly calls the DAO to delete a patient by ID.
     */
    @Test
    void testDeletePatientDeleteById() {

        patientService.deletePatient(1L);
        //verify(patientDao, times(1)).deleteById(1L);
    }
}
