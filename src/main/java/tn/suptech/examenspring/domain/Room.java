package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "salles")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @Column(name = "prix_jour")
    private Double prixJour;

    @Column(name = "capacite_roum")
    private Long capaciteRoum;

    @Column(name = "load_roum")
    private Long loadRoum;

    @Column(name = "saturation_roum")
    private Boolean saturationRoum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloc_id")
    private OperatingBloc operatingBloc;

    public Room() {
    }

    public Room(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }

    public Room(String nom, String type, OperatingBloc operatingBloc) {
        this.nom = nom;
        this.type = type;
        this.operatingBloc = operatingBloc;
    }

    public Room(Long id, String nom, String type, Double prixJour, Long capaciteRoum, Long loadRoum, Boolean saturationRoum, OperatingBloc operatingBloc) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.prixJour = prixJour;
        this.capaciteRoum = capaciteRoum;
        this.loadRoum = loadRoum;
        this.saturationRoum = saturationRoum;
        this.operatingBloc = operatingBloc;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OperatingBloc getBlocOperatoire() {
        return operatingBloc;
    }

    public void setBlocOperatoire(OperatingBloc operatingBloc) {
        this.operatingBloc = operatingBloc;
    }

    public Double getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(Double prixJour) {
        this.prixJour = prixJour;
    }

    public Long getCapaciteRoum() {
        return capaciteRoum;
    }

    public void setCapaciteRoum(Long capaciteRoum) {
        this.capaciteRoum = capaciteRoum;
    }

    public Long getLoadRoum() {
        return loadRoum;
    }

    public void setLoadRoum(Long loadRoum) {
        this.loadRoum = loadRoum;
    }

    public Boolean isSaturationRoum() {
        return saturationRoum;
    }

    public Boolean getSaturationRoum() {
        return saturationRoum;
    }

    public void setSaturationRoum(Boolean saturationRoum) {
        this.saturationRoum = saturationRoum;
    }

    public OperatingBloc getOperatingBloc() {
        return operatingBloc;
    }

    public void setOperatingBloc(OperatingBloc operatingBloc) {
        this.operatingBloc = operatingBloc;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", prixJour=" + prixJour +
                ", capaciteRoum=" + capaciteRoum +
                ", loadRoum=" + loadRoum +
                ", saturationRoum=" + saturationRoum +
                ", operatingBloc=" + operatingBloc +
                '}';
    }
}

