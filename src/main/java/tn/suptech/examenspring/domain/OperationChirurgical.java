package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "operations")
public class OperationChirurgical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private MedicalStaff medicalStaff;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Double prix;

    @OneToMany(mappedBy = "operationChirurgical", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    @ManyToOne
    @JoinColumn(name = "patienthistory_id")
    private PatientHistory patientHistory;

    public OperationChirurgical() {
    }

    public OperationChirurgical(Long id, Patient patient, MedicalStaff medicalStaff, LocalDate date, String description, Double prix, List<Equipment> equipments) {
        this.id = id;
        this.patient = patient;
        this.medicalStaff = medicalStaff;
        this.date = date;
        this.description = description;
        this.prix = prix;
        this.equipments = equipments;
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

    public MedicalStaff getDoctor() {
        return medicalStaff;
    }

    public void setDoctor(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }
}
