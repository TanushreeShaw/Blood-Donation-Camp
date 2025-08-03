package com.donation.UserRegistration.dto;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.Objects;

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

    @Column(name = "PHN_NO")
    private String phoneNumber;

    @Column(name = "BLOOD_GRP")
    private String BloodGroup;

    @Column(name = "DATE_OF_DONATION")
    private LocalDate dateOfDonation;

    public Patient(Long id, LocalDate dateOfDonation, String bloodGroup, String lastName, String phoneNumber, String firstName) {
        this.id = id;
        this.dateOfDonation = dateOfDonation;
        BloodGroup = bloodGroup;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
    }

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
