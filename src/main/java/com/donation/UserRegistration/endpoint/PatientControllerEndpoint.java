package com.donation.UserRegistration.endpoint;

import com.donation.UserRegistration.dto.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/patients")
public interface PatientControllerEndpoint {

    @PostMapping(value = "/list", produces = "application/json")
    ResponseEntity<List<Patient>> getAllPatients();

}