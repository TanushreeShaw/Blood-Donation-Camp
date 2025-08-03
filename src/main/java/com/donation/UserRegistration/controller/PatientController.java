package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.dto.Patient;
import com.donation.UserRegistration.endpoint.PatientControllerEndpoint;
import com.donation.UserRegistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("Patient", patient);
        return "AddPatient";
    }

    public String savePatient(@ModelAttribute("Patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/dashboard/patients/list";
    }

}
