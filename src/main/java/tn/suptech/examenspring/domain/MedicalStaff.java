package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medical_staff")
public class MedicalStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "cin_number")
    private Long cinNumber;


    @Column(name = "bank")
    private String bank;

    @Column(name = "rib")
    private Long rib;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private MedicalPosition position;

    @OneToMany(mappedBy = "medicalStaff")
    private List<HistoriqueMedical> historiqueMedicals;

    public MedicalStaff() {
    }

    public MedicalStaff(Long id, String firstName, String lastName, String sexe, Long cinNumber, String bank, Long rib, String phoneNumber, String email, MedicalPosition position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexe = sexe;
        this.cinNumber = cinNumber;
        this.bank = bank;
        this.rib = rib;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
    }

    public MedicalStaff(String firstName, String lastName, String sexe, Long cinNumber, String bank, Long rib, String phoneNumber, String email, MedicalPosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexe = sexe;
        this.cinNumber = cinNumber;
        this.bank = bank;
        this.rib = rib;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Long getRib() {
        return rib;
    }

    public void setRib(Long rib) {
        this.rib = rib;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public MedicalPosition getPosition() {
        return position;
    }

    public void setPosition(MedicalPosition position) {
        this.position = position;
    }

    public List<HistoriqueMedical> getHistoriqueMedicals() {
        return historiqueMedicals;
    }

    public void setHistoriqueMedicals(List<HistoriqueMedical> historiqueMedicals) {
        this.historiqueMedicals = historiqueMedicals;
    }

    public Long getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(Long cinNumber) {
        this.cinNumber = cinNumber;
    }

    @Override
    public String toString() {
        return "MedicalStaff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cinNumber=" + cinNumber +
                ", bank='" + bank + '\'' +
                ", rib=" + rib +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +
                ", historiqueMedicals=" + historiqueMedicals +
                '}';
    }
}
