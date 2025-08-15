package com.donation.UserRegistration.endpoint;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
public interface PatientControllerEndpoint {

    @GetMapping(value = "/patients/list", produces = MediaType.APPLICATION_JSON_VALUE)
    String getAllPatients(Model model);

    @GetMapping(value = "/patients/new", produces = MediaType.APPLICATION_JSON_VALUE)
    String addPatient(Model model);

    @PostMapping(value = "/patients/save", produces = MediaType.APPLICATION_JSON_VALUE)
    String savePatient(@ModelAttribute("Patient") Patient patient);

    @GetMapping(value = "/patients/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    String editPatient(@PathVariable("id") Long id, Model model);

    @PostMapping(value = "/patients/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    String updatePatient(@PathVariable("id") Long id, @ModelAttribute("Patient") Patient patient);

    @GetMapping(value = "/patients/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    String deletePatient(@PathVariable("id") Long id);

}
