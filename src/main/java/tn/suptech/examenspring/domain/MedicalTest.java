package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medical_test")
public class MedicalTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "test_result")
    private String testResult;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "patienthistory_id")
    private PatientHistory patientHistory;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private MedicalStaff medicalStaff;

    @ManyToOne
    @JoinColumn(name = "medical_test_type_id")
    private MedicalTestType medicalTestType;

    @Column(name = "test_date")
    private LocalDate testDate;

    public MedicalTest() {
    }

    public MedicalTest(String testResult, Patient patient, PatientHistory patientHistory, MedicalStaff medicalStaff, MedicalTestType medicalTestType, LocalDate testDate) {
        this.testResult = testResult;
        this.patient = patient;
        this.patientHistory = patientHistory;
        this.medicalStaff = medicalStaff;
        this.medicalTestType = medicalTestType;
        this.testDate = testDate;
    }

    public MedicalTest(Long id, String testResult, Patient patient, PatientHistory patientHistory, MedicalStaff medicalStaff, MedicalTestType medicalTestType, LocalDate testDate) {
        this.id = id;
        this.testResult = testResult;
        this.patient = patient;
        this.patientHistory = patientHistory;
        this.medicalStaff = medicalStaff;
        this.medicalTestType = medicalTestType;
        this.testDate = testDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public MedicalTestType getMedicalTestType() {
        return medicalTestType;
    }

    public void setMedicalTestType(MedicalTestType medicalTestType) {
        this.medicalTestType = medicalTestType;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "MedicalTest{" +
                "id=" + id +
                ", testResult='" + testResult + '\'' +
                ", patient=" + patient +
                ", patientHistory=" + patientHistory +
                ", medicalStaff=" + medicalStaff +
                ", medicalTestType=" + medicalTestType +
                ", testDate=" + testDate +
                '}';
    }
}


