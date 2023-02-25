package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "administrative_staff")
public class AdministrativeStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cin_number")
    private Long cinNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "bank")
    private String bank;

    @Column(name = "rib")
    private Long rib;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private AdministrativePosition admistrativePosition;

    @OneToMany(mappedBy = "administrativeStaff")
    private List<HistoriqueAdministratif> historiqueAdministratifs;

    public AdministrativeStaff() {
    }

    public AdministrativeStaff(Long id, Long cinNumber, String firstName, String lastName, String sexe, LocalDate birthDate, String address, String phoneNumber, String email, String bank, Long rib, AdministrativePosition admistrativePosition) {
        this.id = id;
        this.cinNumber = cinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexe = sexe;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bank = bank;
        this.rib = rib;
        this.admistrativePosition = admistrativePosition;
    }

    public AdministrativeStaff(Long cinNumber, String firstName, String lastName, String sexe, LocalDate birthDate, String address, String phoneNumber, String email, String bank, Long rib, AdministrativePosition admistrativePosition) {
        this.cinNumber = cinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexe = sexe;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bank = bank;
        this.rib = rib;
        this.admistrativePosition = admistrativePosition;
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

    public AdministrativePosition getAdmistrativePosition() {
        return admistrativePosition;
    }

    public void setAdmistrativePosition(AdministrativePosition admistrativePosition) {
        this.admistrativePosition = admistrativePosition;
    }

    public List<HistoriqueAdministratif> getHistoriqueAdministratifs() {
        return historiqueAdministratifs;
    }

    public void setHistoriqueAdministratifs(List<HistoriqueAdministratif> historiqueAdministratifs) {
        this.historiqueAdministratifs = historiqueAdministratifs;
    }

    public Long getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(Long cinNumber) {
        this.cinNumber = cinNumber;
    }

    @Override
    public String toString() {
        return "AdministrativeStaff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", bank='" + bank + '\'' +
                ", rib=" + rib +
                ", admistrativePosition=" + admistrativePosition +
                ", historiqueAdministratifs=" + historiqueAdministratifs +
                '}';
    }
}
