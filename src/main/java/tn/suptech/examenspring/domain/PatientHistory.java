package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient_history")
public class PatientHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(mappedBy = "patientHistory")
    private List<MedicalTest> medicalTests;

    @OneToMany(mappedBy = "patientHistory")
    private List<DoctorConsultation> doctorConsultations;

    @OneToMany(mappedBy = "patientHistory")
    private List<OperationChirurgical> operationChirurgicals;

    @OneToMany(mappedBy = "patientHistory")
    private List<RoomStay> roomStays;

    @OneToMany(mappedBy = "patientHistory")
    private List<Medication> medications;

// constructeurs, getters et setters, et méthodes de convenance

    public PatientHistory() {
    }

    public PatientHistory(Long id, Patient patient, LocalDate date, List<MedicalTest> medicalTests, List<DoctorConsultation> doctorConsultations, List<OperationChirurgical> operationChirurgicals, List<RoomStay> roomStays, List<Medication> medications) {
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.medicalTests = medicalTests;
        this.doctorConsultations = doctorConsultations;
        this.operationChirurgicals = operationChirurgicals;
        this.roomStays = roomStays;
        this.medications = medications;
    }

    public PatientHistory(Patient patient, LocalDate date) {
        this.patient = patient;
        this.date = date;
    }

    public PatientHistory(Patient patient, LocalDate date, List<MedicalTest> medicalTests, List<DoctorConsultation> doctorConsultations, List<OperationChirurgical> operationChirurgicals, List<RoomStay> roomStays, List<Medication> medications) {
        this.patient = patient;
        this.date = date;
        this.medicalTests = medicalTests;
        this.doctorConsultations = doctorConsultations;
        this.operationChirurgicals = operationChirurgicals;
        this.roomStays = roomStays;
        this.medications = medications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<MedicalTest> getMedicalTests() {
        return medicalTests;
    }

    public void setMedicalTests(List<MedicalTest> medicalTests) {
        this.medicalTests = medicalTests;
    }

    public List<DoctorConsultation> getDoctorConsultations() {
        return doctorConsultations;
    }

    public void setDoctorConsultations(List<DoctorConsultation> doctorConsultations) {
        this.doctorConsultations = doctorConsultations;
    }

    public List<OperationChirurgical> getOperationChirurgicals() {
        return operationChirurgicals;
    }

    public void setOperationChirurgicals(List<OperationChirurgical> operationChirurgicals) {
        this.operationChirurgicals = operationChirurgicals;
    }

    public List<RoomStay> getRoomStays() {
        return roomStays;
    }

    public void setRoomStays(List<RoomStay> roomStays) {
        this.roomStays = roomStays;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "PatientHistory{" +
                "id=" + id +
                ", patient=" + patient +
                ", date=" + date +
                ", medicalTests=" + medicalTests +
                ", doctorConsultations=" + doctorConsultations +
                ", operationChirurgicals=" + operationChirurgicals +
                ", roomStays=" + roomStays +
                ", medications=" + medications +
                '}';
    }
}

