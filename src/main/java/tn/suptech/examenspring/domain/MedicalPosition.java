/* Voici quelques exemples de positions ou de titres possibles pour le personnel médical :

Médecin
Infirmier/infirmière
Pharmacien/pharmacienne
Chirurgien/chirurgienne
Dentiste
Kinésithérapeute
Sage-femme
Technicien/technicienne de laboratoire
Radiologue
Anesthésiste
Orthophoniste
Psychologue clinicien/clinicienne
Diététicien/diététicienne
Ergothérapeute
Audiologiste
Optométriste
 */


package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medical_position")
public class MedicalPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "hourly_wage")
    private Double hourlyWage;

    @Column(name = "overtime_hourly_wage")
    private Double overtimeHourlyWage;

    @Column(name = "paid_sick_days")
    private Integer paidSickDays;

    @Column(name = "paid_vacation_days")
    private Integer paidVacationDays;

    @OneToMany(mappedBy = "position")
    private List<MedicalStaff> staff;

    @OneToMany(mappedBy = "medicalPosition")
    private List<PrimeMedical> primes;

    // Constructeurs, getters, setters et méthodes de convenance


    public MedicalPosition() {
    }

    public MedicalPosition(String positionName, Double hourlyWage, Double overtimeHourlyWage, Integer paidSickDays, Integer paidVacationDays, List<MedicalStaff> staff, List<PrimeMedical> primes) {
        this.positionName = positionName;
        this.hourlyWage = hourlyWage;
        this.overtimeHourlyWage = overtimeHourlyWage;
        this.paidSickDays = paidSickDays;
        this.paidVacationDays = paidVacationDays;
        this.staff = staff;
        this.primes = primes;
    }

    public MedicalPosition(Long id, String positionName, Double hourlyWage, Double overtimeHourlyWage, Integer paidSickDays, Integer paidVacationDays, List<MedicalStaff> staff, List<PrimeMedical> primes) {
        this.id = id;
        this.positionName = positionName;
        this.hourlyWage = hourlyWage;
        this.overtimeHourlyWage = overtimeHourlyWage;
        this.paidSickDays = paidSickDays;
        this.paidVacationDays = paidVacationDays;
        this.staff = staff;
        this.primes = primes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public Double getOvertimeHourlyWage() {
        return overtimeHourlyWage;
    }

    public void setOvertimeHourlyWage(Double overtimeHourlyWage) {
        this.overtimeHourlyWage = overtimeHourlyWage;
    }

    public Integer getPaidSickDays() {
        return paidSickDays;
    }

    public void setPaidSickDays(Integer paidSickDays) {
        this.paidSickDays = paidSickDays;
    }

    public Integer getPaidVacationDays() {
        return paidVacationDays;
    }

    public void setPaidVacationDays(Integer paidVacationDays) {
        this.paidVacationDays = paidVacationDays;
    }

    public List<MedicalStaff> getStaff() {
        return staff;
    }

    public void setStaff(List<MedicalStaff> staff) {
        this.staff = staff;
    }

    public List<PrimeMedical> getPrimes() {
        return primes;
    }

    public void setPrimes(List<PrimeMedical> primes) {
        this.primes = primes;
    }

    @Override
    public String toString() {
        return "MedicalPosition{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", overtimeHourlyWage=" + overtimeHourlyWage +
                ", paidSickDays=" + paidSickDays +
                ", paidVacationDays=" + paidVacationDays +
                ", staff=" + staff +
                ", primes=" + primes +
                '}';
    }
}
