package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.dto.Patient;
import com.donation.UserRegistration.endpoint.PatientControllerEndpoint;
import com.donation.UserRegistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller class for managing patients.
 * This class handles HTTP requests related to Patient entities and interacts with the services.
 * It implements the PatientControllerEndpoint interface to define the endpoints.
 *
 */
@Controller
public class PatientController implements PatientControllerEndpoint {

    @Autowired
    private PatientService patientService;

    /**
     * Retrieves all patients and adds them to the model.
     *
     * @param model The model to which the list of patients will be added.
     * @return The name of the view to display the list of patients.
     */
    @Override
    public String getAllPatients(Model model) {
        model.addAttribute("Patient", patientService.findAllPatients());
        return "PatientList";
    }

    /**
     * Displays the form to add a new patient.
     *
     * @param model The model to which a new Patient object will be added.
     * @return The name of the view to display the add patient form.
     */
    @Override
    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("Patient", patient);
        return "AddPatient";
    }

    /**
     * Saves a new patient to the database.
     *
     * @param patient The patient object to be saved.
     * @return A redirect to the list of patients after saving.
     */
    @Override
    public String savePatient(@ModelAttribute("Patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/dashboard/patients/list";
    }

    /**
     * Displays the form to edit an existing patient.
     *
     * @param id    The ID of the patient to be edited.
     * @param model The model to which the existing Patient object will be added.
     * @return The name of the view to display the edit patient form.
     */
    @Override
    public String editPatient(Long id, Model model) {
        Patient patient = patientService.findPatientById(id);
        model.addAttribute("Patient", patient);
        return "EditPatient";
    }

    /**
     * Updates an existing patient in the database.
     *
     * @param id      The ID of the patient to be updated.
     * @param patient The patient object containing the updated information.
     * @return A redirect to the list of patients after updating.
     */
    @Override
    public String updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientService.findPatientById(id);
        if(ObjectUtils.isEmpty(existingPatient)) {
            return "redirect:/dashboard/patients/list";
        }
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());
        existingPatient.setBloodGroup(patient.getBloodGroup());
        existingPatient.setDateOfDonation(patient.getDateOfDonation());

        patientService.savePatient(existingPatient);
        return "redirect:/dashboard/patients/list";
    }

    /**
     * Deletes a patient from the database.
     *
     * @param id The ID of the patient to be deleted.
     * @return A redirect to the list of patients after deletion.
     */
    public String deletePatient(Long id) {
        patientService.deletePatient(id);
        return "redirect:/dashboard/patients/list";
    }

}
