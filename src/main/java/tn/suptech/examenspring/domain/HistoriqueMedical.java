package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historique_medical")
public class HistoriqueMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medical_staff_id")
    private MedicalStaff medicalStaff;

    @Column(name = "date_jour")
    private LocalDate dateJour;

    @Column(name = "jour_repo")
    private Boolean jourRepo;

    @Column(name = "repo_maladie")
    private Boolean repoMaladie;

    @Column(name = "heures_travail")
    private Integer heuresTravail;

    @Column(name = "heures_supp")
    private Integer heuresSupp;

    // constructeurs, getters et setters, et méthodes de convenance


    public HistoriqueMedical() {
    }

    public HistoriqueMedical(Long id, MedicalStaff medicalStaff, LocalDate dateJour, Boolean jourRepo, Boolean repoMaladie, Integer heuresTravail, Integer heuresSupp) {
        this.id = id;
        this.medicalStaff = medicalStaff;
        this.dateJour = dateJour;
        this.jourRepo = jourRepo;
        this.repoMaladie = repoMaladie;
        this.heuresTravail = heuresTravail;
        this.heuresSupp = heuresSupp;
    }

    public HistoriqueMedical(MedicalStaff medicalStaff, LocalDate dateJour, Boolean jourRepo, Boolean repoMaladie, Integer heuresTravail, Integer heuresSupp) {
        this.medicalStaff = medicalStaff;
        this.dateJour = dateJour;
        this.jourRepo = jourRepo;
        this.repoMaladie = repoMaladie;
        this.heuresTravail = heuresTravail;
        this.heuresSupp = heuresSupp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalStaff getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(MedicalStaff medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public LocalDate getDateJour() {
        return dateJour;
    }

    public void setDateJour(LocalDate dateJour) {
        this.dateJour = dateJour;
    }

    public Boolean getJourRepo() {
        return jourRepo;
    }

    public void setJourRepo(Boolean jourRepo) {
        this.jourRepo = jourRepo;
    }

    public Boolean getRepoMaladie() {
        return repoMaladie;
    }

    public void setRepoMaladie(Boolean repoMaladie) {
        this.repoMaladie = repoMaladie;
    }

    public Integer getHeuresTravail() {
        return heuresTravail;
    }

    public void setHeuresTravail(Integer heuresTravail) {
        this.heuresTravail = heuresTravail;
    }

    public Integer getHeuresSupp() {
        return heuresSupp;
    }

    public void setHeuresSupp(Integer heuresSupp) {
        this.heuresSupp = heuresSupp;
    }

    @Override
    public String toString() {
        return "HistoriqueMedical{" +
                "id=" + id +
                ", medicalStaff=" + medicalStaff +
                ", dateJour=" + dateJour +
                ", jourRepo=" + jourRepo +
                ", repoMaladie=" + repoMaladie +
                ", heuresTravail=" + heuresTravail +
                ", heuresSupp=" + heuresSupp +
                '}';
    }
}
