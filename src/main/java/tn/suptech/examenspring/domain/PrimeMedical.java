package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prime_medical")
public class PrimeMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "prime_name")
    private String primeName;

    @Column(name = "prime_value")
    private Double primeValue;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "medical_position_id")
    private MedicalPosition medicalPosition;

    // constructeurs, getters et setters, et méthodes de convenance


    public PrimeMedical() {
    }

    public PrimeMedical(Long id, String primeName, Double primeValue, LocalDate paymentDate, MedicalPosition medicalPosition) {
        this.id = id;
        this.primeName = primeName;
        this.primeValue = primeValue;
        this.paymentDate = paymentDate;
        this.medicalPosition = medicalPosition;
    }

    public PrimeMedical(String primeName, Double primeValue, LocalDate paymentDate, MedicalPosition medicalPosition) {
        this.primeName = primeName;
        this.primeValue = primeValue;
        this.paymentDate = paymentDate;
        this.medicalPosition = medicalPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeName() {
        return primeName;
    }

    public void setPrimeName(String primeName) {
        this.primeName = primeName;
    }

    public Double getPrimeValue() {
        return primeValue;
    }

    public void setPrimeValue(Double primeValue) {
        this.primeValue = primeValue;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public MedicalPosition getMedicalPosition() {
        return medicalPosition;
    }

    public void setMedicalPosition(MedicalPosition medicalPosition) {
        this.medicalPosition = medicalPosition;
    }

    @Override
    public String toString() {
        return "PrimeMedical{" +
                "id=" + id +
                ", primeName='" + primeName + '\'' +
                ", primeValue=" + primeValue +
                ", paymentDate=" + paymentDate +
                ", medicalPosition=" + medicalPosition +
                '}';
    }
}