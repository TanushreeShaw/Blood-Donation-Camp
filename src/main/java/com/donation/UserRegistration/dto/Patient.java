package com.donation.UserRegistration.dto;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity class representing a Patient.
 * This class is mapped to the PATIENT_DB table in the database.
 * It includes fields for patient details such as first name, last name, phone number, blood group, and date of donation.
 * The class provides constructors, getters, setters, and overrides for equals and hashCode methods.
 * It uses JPA annotations for ORM mapping.
 *
 */
@Entity
@Table(name = "PATIENT_DB")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHN_NO", nullable = false)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Column(name = "BLOOD_GRP")
    private String BloodGroup;

    @Column(name = "DATE_OF_DONATION")
    private LocalDate dateOfDonation;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(phoneNumber, patient.phoneNumber) && Objects.equals(BloodGroup, patient.BloodGroup) && Objects.equals(dateOfDonation, patient.dateOfDonation);
    }

    public Patient() {
        // Default constructor
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, BloodGroup, dateOfDonation);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public LocalDate getDateOfDonation() {
        return dateOfDonation;
    }

    public void setDateOfDonation(LocalDate dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }

}
