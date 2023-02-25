package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "quantite")
    private Long quantite;

    @Column(name = "prix")
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "patienthistory_id")
    private PatientHistory patientHistory;

    public Medication() {
    }

    public Medication(String nom, String description, Long quantite, Double prix) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Medication(Long id, String nom, String description, Long quantite, Double prix) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }


    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
