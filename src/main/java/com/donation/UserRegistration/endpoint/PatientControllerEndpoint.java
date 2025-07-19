package com.donation.UserRegistration.endpoint;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashboard")
public interface PatientControllerEndpoint {

    @GetMapping(value = "/patients/list", produces = "application/json")
    String getAllPatients(Model model);

}
