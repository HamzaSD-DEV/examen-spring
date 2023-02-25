/*Voici quelques exemples de postes administratifs que le personnel peut occuper dans un hôpital à Tunis :

Directeur de l'hôpital
Directeur des services administratifs
Directeur des ressources humaines
Chef de service du département administratif
Responsable des finances
Responsable de la facturation et du codage
Responsable des achats et des approvisionnements
Responsable des relations publiques et de la communication
Responsable de la qualité et de la sécurité des soins
Agent de gestion administrative
Secrétaire administratif
Assistant administratif.

 */

package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historique_administratif")
public class HistoriqueAdministratif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "administrative_staff_id")
    private AdministrativeStaff administrativeStaff;

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


    public HistoriqueAdministratif() {
    }

    public HistoriqueAdministratif(AdministrativeStaff administrativeStaff, LocalDate dateJour, Boolean conge, Boolean repoMaladie, Integer heuresTravail, Integer heuresSupp) {
        this.administrativeStaff = administrativeStaff;
        this.dateJour = dateJour;
        this.jourRepo = conge;
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

    public AdministrativeStaff getAdministrativeStaff() {
        return administrativeStaff;
    }

    public void setAdministrativeStaff(AdministrativeStaff administrativeStaff) {
        this.administrativeStaff = administrativeStaff;
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
        return "HistoriqueAdministratif{" +
                "id=" + id +
                ", administrativeStaff=" + administrativeStaff +
                ", date=" + dateJour +
                ", jourRepo=" + jourRepo +
                ", repoMaladie=" + repoMaladie +
                ", heuresTravail=" + heuresTravail +
                ", heuresSupp=" + heuresSupp +
                '}';
    }
}
