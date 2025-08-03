package com.donation.UserRegistration.endpoint;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
public interface PatientControllerEndpoint {

    @GetMapping(value = "/patients/list", produces = "application/json")
    String getAllPatients(Model model);

    @GetMapping(value = "/patients/new", produces = "application/json")
    String addPatient(Model model);

    @PostMapping(value = "/patients/save", produces = "application/json")
    String savePatient(@ModelAttribute("Patient") Patient patient);
}
