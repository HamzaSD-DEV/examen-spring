package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private OperatingBloc operatingBloc;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private OperationChirurgical operationChirurgical;

    public Equipment() {
    }

    public Equipment(Long id, String name, String description, String serialNumber, Double price, Fournisseur fournisseur, OperatingBloc operatingBloc) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.price = price;
        this.fournisseur = fournisseur;
        this.operatingBloc = operatingBloc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public OperatingBloc getBlocOperatoire() {
        return operatingBloc;
    }

    public void setBlocOperatoire(OperatingBloc operatingBloc) {
        this.operatingBloc = operatingBloc;
    }

    public OperationChirurgical getOperationChirurgical() {
        return operationChirurgical;
    }

    public void setOperationChirurgical(OperationChirurgical operationChirurgical) {
        this.operationChirurgical = operationChirurgical;
    }

    public OperatingBloc getOperatingBloc() {
        return operatingBloc;
    }

    public void setOperatingBloc(OperatingBloc operatingBloc) {
        this.operatingBloc = operatingBloc;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", fournisseur=" + fournisseur +
                ", operatingBloc=" + operatingBloc +
                ", operationChirurgical=" + operationChirurgical +
                '}';
    }
}


