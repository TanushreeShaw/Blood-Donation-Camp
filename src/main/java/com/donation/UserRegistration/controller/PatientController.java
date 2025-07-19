package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.endpoint.PatientControllerEndpoint;
import com.donation.UserRegistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PatientController implements PatientControllerEndpoint {

    @Autowired
    private PatientService patientService;

    @Override
    public String getAllPatients(Model model) {
        model.addAttribute("Patient", patientService.findAllPatients());
        return "PatientList";
    }

}
