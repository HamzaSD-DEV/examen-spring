package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prime_administrative")
public class PrimeAdministrative {

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
    @JoinColumn(name = "administrative_position_id")
    private AdministrativePosition administrativePosition;

    // constructeurs, getters et setters, et méthodes de convenance

    public PrimeAdministrative() {
    }

    public PrimeAdministrative(Long id, String primeName, Double primeValue, LocalDate paymentDate, AdministrativePosition administrativePosition) {
        this.id = id;
        this.primeName = primeName;
        this.primeValue = primeValue;
        this.paymentDate = paymentDate;
        this.administrativePosition = administrativePosition;
    }

    public PrimeAdministrative(String primeName, Double primeValue, LocalDate paymentDate, AdministrativePosition administrativePosition) {
        this.primeName = primeName;
        this.primeValue = primeValue;
        this.paymentDate = paymentDate;
        this.administrativePosition = administrativePosition;
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

    public AdministrativePosition getAdministrativePosition() {
        return administrativePosition;
    }

    public void setAdministrativePosition(AdministrativePosition administrativePosition) {
        this.administrativePosition = administrativePosition;
    }

    @Override
    public String toString() {
        return "PrimeAdministrative{" +
                "id=" + id +
                ", primeName='" + primeName + '\'' +
                ", primeValue=" + primeValue +
                ", paymentDate=" + paymentDate +
                ", administrativePosition=" + administrativePosition +
                '}';
    }
}