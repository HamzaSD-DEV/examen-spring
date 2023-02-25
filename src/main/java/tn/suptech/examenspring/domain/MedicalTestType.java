package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Medical_test_type")
public class MedicalTestType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom_test")
    private String nomTest;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Double prix;

    @OneToMany(mappedBy = "medicalTestType", cascade = CascadeType.ALL)
    private List<MedicalTest> medicalTests;

    // Constructeurs

    public MedicalTestType() {
    }

    public MedicalTestType(String nomTest, String description, double prix) {
        this.nomTest = nomTest;
        this.description = description;
        this.prix = prix;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomTest() {
        return nomTest;
    }

    public void setNomTest(String nomTest) {
        this.nomTest = nomTest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    // ToString

    @Override
    public String toString() {
        return "MedicalTestTypeRepository{" +
                "id=" + id +
                ", nomTest='" + nomTest + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
