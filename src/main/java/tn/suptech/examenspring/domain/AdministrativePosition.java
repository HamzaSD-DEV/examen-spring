package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "administrative_position")
public class AdministrativePosition {

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

    @OneToMany(mappedBy = "admistrativePosition")
    private List<AdministrativeStaff> staffList;

    @OneToMany(mappedBy = "administrativePosition")
    private List<PrimeAdministrative> primes;


    // constructeurs, getters et setters, et méthodes de convenance

    public AdministrativePosition() {
    }

    public AdministrativePosition(String positionName, Double hourlyWage, Double overtimeHourlyWage, Integer paidSickDays, Integer paidVacationDays) {
        this.positionName = positionName;
        this.hourlyWage = hourlyWage;
        this.overtimeHourlyWage = overtimeHourlyWage;
        this.paidSickDays = paidSickDays;
        this.paidVacationDays = paidVacationDays;
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

    public List<AdministrativeStaff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<AdministrativeStaff> staffList) {
        this.staffList = staffList;
    }

    public List<PrimeAdministrative> getPrimes() {
        return primes;
    }

    public void setPrimes(List<PrimeAdministrative> primes) {
        this.primes = primes;
    }

    @Override
    public String toString() {
        return "AdministrativePosition{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", overtimeHourlyWage=" + overtimeHourlyWage +
                ", paidSickDays=" + paidSickDays +
                ", paidVacationDays=" + paidVacationDays +
                ", staffList=" + staffList +
                ", primes=" + primes +
                '}';
    }
}

