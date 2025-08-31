package com.donation.UserRegistration.endpoint;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface defining the endpoints for PatientController.
 * This interface declares the methods for handling HTTP requests related to Patient entities.
 * Implementing classes will provide the actual logic for these endpoints.
 *
 */
@RequestMapping("/dashboard")
public interface PatientControllerEndpoint {

    @GetMapping(value = "/patients/list")
    String getAllPatients(Model model);

    @GetMapping(value = "/patients/new")
    String addPatient(Model model);

    @PostMapping(value = "/patients/save")
    String savePatient(@ModelAttribute("Patient") Patient patient);

    @GetMapping(value = "/patients/update/{id}")
    String editPatient(@PathVariable("id") Long id, Model model);

    @PostMapping(value = "/patients/update/{id}")
    String updatePatient(@PathVariable("id") Long id, @ModelAttribute("Patient") Patient patient);

    @GetMapping(value = "/patients/delete/{id}")
    String deletePatient(@PathVariable("id") Long id);

}
