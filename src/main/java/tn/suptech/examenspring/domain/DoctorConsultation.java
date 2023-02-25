package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "doctor_consultations")
public class DoctorConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private MedicalStaff medicalStaff;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "consultation_date")
    private LocalDate consultationDate;

    @Column(name = "observations")
    private String observations;

    @ManyToOne
    @JoinColumn(name = "patienthistory_id")
    private PatientHistory patientHistory;

    // constructeurs, getters et setters, et méthodes de convenance

    public DoctorConsultation() {
    }

    public DoctorConsultation(MedicalStaff medicalStaff, Patient patient, LocalDate consultationDate, String observations) {
        this.medicalStaff = medicalStaff;
        this.patient = patient;
        this.consultationDate = consultationDate;
        this.observations = observations;
    }

    public DoctorConsultation(MedicalStaff medicalStaff, Patient patient, LocalDate consultationDate, String observations, PatientHistory patientHistory) {
        this.medicalStaff = medicalStaff;
        this.patient = patient;
        this.consultationDate = consultationDate;
        this.observations = observations;
        this.patientHistory = patientHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalStaff getDoctor() {
        return medicalStaff;
    }

    public void setDoctor(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    @Override
    public String toString() {
        return "DoctorConsultation{" +
                "id=" + id +
                ", medicalStaff=" + medicalStaff +
                ", patient=" + patient +
                ", consultationDate=" + consultationDate +
                ", observations='" + observations + '\'' +
                ", patientHistory=" + patientHistory +
                '}';
    }
}

