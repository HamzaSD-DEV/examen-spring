package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Equipment;
import tn.suptech.examenspring.repository.EquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long equipmentId) throws Exception {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        if (equipment.isPresent()) {
            return equipment.get();
        } else {
            throw new Exception("Equipment not found with id " + equipmentId);
        }
    }

    public List<Equipment> getEquipmentByName(String name) {
        return equipmentRepository.findByName(name);
    }

    public List<Equipment> getEquipmentBySerialNumber(String serialNumber) {
        return equipmentRepository.findBySerialNumber(serialNumber);
    }

    public List<Equipment> getEquipmentByFournisseur(String fournisseur) {
        return equipmentRepository.findByFournisseur(fournisseur);
    }

    public Equipment updateEquipment(Long equipmentId, Equipment equipmentDetails) throws Exception {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        if (equipment.isPresent()) {
            Equipment existingEquipment = equipment.get();
            existingEquipment.setName(equipmentDetails.getName());
            existingEquipment.setDescription(equipmentDetails.getDescription());
            existingEquipment.setSerialNumber(equipmentDetails.getSerialNumber());
            existingEquipment.setPrice(equipmentDetails.getPrice());
            existingEquipment.setFournisseur(equipmentDetails.getFournisseur());
            existingEquipment.setOperatingBloc(equipmentDetails.getOperatingBloc());
            existingEquipment.setOperationChirurgical(equipmentDetails.getOperationChirurgical());
            return equipmentRepository.save(existingEquipment);
        } else {
            throw new Exception("Equipment not found with id " + equipmentId);
        }
    }

    public boolean deleteEquipment(Long equipmentId) throws Exception {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        if (equipment.isPresent()) {
            equipmentRepository.deleteById(equipmentId);
            return true;
        } else {
            throw new Exception("Equipment not found with id " + equipmentId);
        }
    }
}
