package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pharmacies")
public class Pharmacie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "bank")
    private String bank;

    @Column(name = "rib")
    private Long rib;
    @Column(name = "adresse")
    private String adresse;

    public Pharmacie() {
    }

    public Pharmacie(Long id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    @Override
    public String toString() {
        return "Pharmacie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", identifier='" + identifier + '\'' +
                ", bank='" + bank + '\'' +
                ", rib=" + rib +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
