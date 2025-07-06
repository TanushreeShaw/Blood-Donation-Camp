package com.donation.UserRegistration.controller;

import com.donation.UserRegistration.dto.Patient;
import com.donation.UserRegistration.endpoint.PatientControllerEndpoint;
import com.donation.UserRegistration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController implements PatientControllerEndpoint {

    @Autowired
    private PatientService patientService;

    @Override
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.findAllPatients());
    }

}