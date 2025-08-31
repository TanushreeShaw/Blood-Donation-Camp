package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.dto.Patient;
import com.donation.UserRegistration.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for PatientController.
 * This class uses JUnit and Mockito to test the functionality of the PatientController.
 * It mocks the PatientService and Model to isolate the controller's behavior.
 *
 */
@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @Mock
    private Model model;

    @InjectMocks
    private PatientController patientController;

    public PatientControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for getAllPatients.
     * This test verifies that the getAllPatients method correctly retrieves all patients
     * and adds them to the model, returning the appropriate view name.
     */
    @Test
    void testGetAllPatients() {
        when(patientService.findAllPatients()).thenReturn(new ArrayList<>());
        String viewName = patientController.getAllPatients(model);
        verify(model).addAttribute(eq("Patient"), anyList());
        assertEquals("PatientList", viewName);
    }

    /**
     * Test method for addPatient.
     * This test verifies that the addPatient method correctly adds a new Patient object
     * to the model and returns the appropriate view name.
     */
    @Test
    void testAddPatient_ShouldAddNewPatientToModelAndReturnView() {

        when(model.addAttribute(eq("Patient"), any(Patient.class))).thenReturn(model);

        String addPatient = patientController.addPatient(model);

        verify(model).addAttribute(eq("Patient"), any(Patient.class));
        assertEquals("AddPatient", addPatient);
    }

    /**
     * Test method for savePatient.
     * This test verifies that the savePatient method correctly calls the PatientService
     * to save a patient and returns the appropriate redirect view name.
     */
    @Test
    void testSavePatient_shouldCallServiceAndRedirect() {

        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFirstName("John");
        patient.setLastName("Doe");

        String savePatient = patientController.savePatient(patient);

        verify(patientService, times(1)).savePatient(patient);
        assertEquals("redirect:/dashboard/patients/list", savePatient);
    }

    /**
     * Test method for savePatient with null patient.
     * This test verifies that the savePatient method handles a null patient gracefully
     * and still returns the appropriate redirect view name.
     */
    @Test
    void testSavePatient_withNullPatient_shouldStillRedirect() {

        String savePatient = patientController.savePatient(null);

        verify(patientService, times(1)).savePatient(null);
        assertEquals("redirect:/dashboard/patients/list", savePatient);
    }

    /**
     * Test method for editPatient.
     * This test verifies that the editPatient method correctly retrieves a patient by ID,
     * adds it to the model, and returns the appropriate view name.
     */
    @Test
    void testEditPatient_shouldAddPatientToModelAndReturnView() {

        Long patientId = 1L;
        Patient patient = new Patient();
        patient.setId(patientId);
        patient.setFirstName("Jane");
        patient.setLastName("Doe");

        when(patientService.findPatientById(patientId)).thenReturn(patient);

        String editedPatient = patientController.editPatient(patientId, model);

        verify(patientService, times(1)).findPatientById(patientId);
        verify(model, times(1)).addAttribute("Patient", patient);
        assertEquals("EditPatient", editedPatient);
    }

    /**
     * Test method for editPatient when patient is not found.
     * This test verifies that the editPatient method handles the case where a patient
     * with the given ID does not exist, adding null to the model and returning the view name.
     */
    @Test
    void testEditPatient_whenPatientNotFound_shouldStillReturnViewWithNull() {

        Long patientId = 99L;

        when(patientService.findPatientById(patientId)).thenReturn(null);

        String viewName = patientController.editPatient(patientId, model);

        verify(patientService, times(1)).findPatientById(patientId);
        verify(model, times(1)).addAttribute("Patient", null);
        assertEquals("EditPatient", viewName);
    }

    /**
     * Test method for updatePatient.
     * This test verifies that the updatePatient method correctly updates an existing patient's details,
     * calls the PatientService to save the updated patient, and returns the appropriate redirect view name.
     */
    @Test
    void testUpdatePatient_whenExistingPatientExists_shouldUpdateAndRedirect() {

        Long patientId = 1L;

        Patient existingPatient = new Patient();
        existingPatient.setId(patientId);

        Patient updatedPatient = new Patient();
        updatedPatient.setFirstName("John");
        updatedPatient.setLastName("Doe");
        updatedPatient.setPhoneNumber("1234567890");
        updatedPatient.setBloodGroup("A+");
        updatedPatient.setDateOfDonation(LocalDate.of(2025, 8, 30));

        when(patientService.findPatientById(patientId)).thenReturn(existingPatient);

        String updatePatient = patientController.updatePatient(patientId, updatedPatient);

        verify(patientService).findPatientById(patientId);
        verify(patientService).savePatient(existingPatient);

        assertEquals("John", existingPatient.getFirstName());
        assertEquals("Doe", existingPatient.getLastName());
        assertEquals("1234567890", existingPatient.getPhoneNumber());
        assertEquals("A+", existingPatient.getBloodGroup());
        assertEquals(LocalDate.of(2025, 8, 30), existingPatient.getDateOfDonation());

        assertEquals("redirect:/dashboard/patients/list", updatePatient);
    }

    /**
     * Test method for updatePatient when patient is not found.
     * This test verifies that the updatePatient method handles the case where a patient
     * with the given ID does not exist, does not attempt to save, and returns the appropriate redirect view name.
     */
    @Test
    void testUpdatePatient_whenPatientNotFound_shouldRedirectWithoutUpdate() {

        Long patientId = 99L;

        when(patientService.findPatientById(patientId)).thenReturn(null);

        Patient patient = new Patient();
        patient.setFirstName("Jane");

        String updatePatient = patientController.updatePatient(patientId, patient);

        verify(patientService).findPatientById(patientId);
        verify(patientService, never()).savePatient(any());

        assertEquals("redirect:/dashboard/patients/list", updatePatient);
    }

    /**
     * Test method for deletePatient.
     * This test verifies that the deletePatient method correctly calls the PatientService
     * to delete a patient by ID and returns the appropriate redirect view name.
     */
    @Test
    void testDeletePatient_shouldCallServiceAndRedirect() {

        Long patientId = 1L;

        String deletedPatient = patientController.deletePatient(patientId);

        verify(patientService, times(1)).deletePatient(patientId);
        assertEquals("redirect:/dashboard/patients/list", deletedPatient);
    }
}