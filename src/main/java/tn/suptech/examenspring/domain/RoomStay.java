package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "room_stays")
public class RoomStay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "patienthistory_id")
    private PatientHistory patientHistory;
    // constructeurs, getters et setters, et méthodes de convenance

    public RoomStay() {
    }

    public RoomStay(Patient patient, Room room, LocalDate startDate, LocalDate endDate) {
        this.patient = patient;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RoomStay(Long id, Patient patient, Room room, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.patient = patient;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    @Override
    public String toString() {
        return "RoomStay{" +
                "id=" + id +
                ", patient=" + patient +
                ", room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", patientHistory=" + patientHistory +
                '}';
    }

}

