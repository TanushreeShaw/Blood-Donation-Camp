package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.dto.Patient;
import com.donation.UserRegistration.endpoint.PatientControllerEndpoint;
import com.donation.UserRegistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PatientController implements PatientControllerEndpoint {

    @Autowired
    private PatientService patientService;

    @Override
    public String getAllPatients(Model model) {
        model.addAttribute("Patient", patientService.findAllPatients());
        return "PatientList";
    }

    @Override
    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("Patient", patient);
        return "AddPatient";
    }

    @Override
    public String savePatient(@ModelAttribute("Patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/dashboard/patients/list";
    }

    @Override
    public String editPatient(Long id, Model model) {
        Patient patient = patientService.findPatientById(id);
        model.addAttribute("Patient", patient);
        return "EditPatient";
    }

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


    public String deletePatient(Long id) {
        patientService.deletePatient(id);
        return "redirect:/dashboard/patients/list";
    }

}
