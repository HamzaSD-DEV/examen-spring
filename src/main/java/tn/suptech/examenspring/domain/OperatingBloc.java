package tn.suptech.examenspring.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "blocs_operatoires")
public class OperatingBloc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "bloc_description")
    private String description;

    @OneToMany(mappedBy = "operatingBloc", cascade = CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy = "operatingBloc", cascade = CascadeType.ALL)
    private List<Equipment> equipment;


    // constructeurs, getters et setters

    public OperatingBloc() {
    }

    public OperatingBloc(String nom) {
        this.nom = nom;
    }

    public OperatingBloc(String nom, List<Room> rooms, List<Equipment> equipment) {
        this.nom = nom;
        this.rooms = rooms;
        this.equipment = equipment;
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

    public List<Room> getSalles() {
        return rooms;
    }

    public void setSallesOperations(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addSalle(Room room) {
        rooms.add(room);
        room.setBlocOperatoire(this);
    }

    public void removeSalle(Room room) {
        rooms.remove(room);
        room.setBlocOperatoire(null);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "OperatingBloc{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", rooms=" + rooms +
                ", equipment=" + equipment +
                '}';
    }
}






