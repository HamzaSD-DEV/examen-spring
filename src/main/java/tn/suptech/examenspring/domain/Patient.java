package tn.suptech.examenspring.domain;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cin_number")
    private Long cinNumber;

    @Column(name = "social_id")
    private Long socialId;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;


    public Patient() {
    }

    public Patient(Long id, Long cinNumber, Long socialId, String firstName, String lastName, LocalDate birthDate, String sexe, String address, String phoneNumber, String email) {
        this.id = id;
        this.cinNumber = cinNumber;
        this.socialId = socialId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sexe = sexe;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Patient(Long cinNumber, Long socialId, String firstName, String lastName, LocalDate birthDate, String sexe, String address, String phoneNumber, String email) {
        this.cinNumber = cinNumber;
        this.socialId = socialId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sexe = sexe;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(Long cinNumber) {
        this.cinNumber = cinNumber;
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

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "uid=" + id +
                ", cinNumber=" + cinNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
