package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Medication;
import tn.suptech.examenspring.repository.MedicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    public Medication addMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    public Medication getMedicationById(Long medicationId) throws Exception {
        Optional<Medication> medication = medicationRepository.findById(medicationId);
        if (medication.isPresent()) {
            return medication.get();
        } else {
            throw new Exception("Medication not found with id " + medicationId);
        }
    }

    public Medication updateMedication(Long medicationId, Medication medicationDetails) throws Exception {
        Optional<Medication> medication = medicationRepository.findById(medicationId);
        if (medication.isPresent()) {
            Medication existingMedication = medication.get();
            existingMedication.setNom(medicationDetails.getNom());
            existingMedication.setDescription(medicationDetails.getDescription());
            existingMedication.setQuantite(medicationDetails.getQuantite());
            existingMedication.setPrix(medicationDetails.getPrix());
            existingMedication.setPatientHistory(medicationDetails.getPatientHistory());
            return medicationRepository.save(existingMedication);
        } else {
            throw new Exception("Medication not found with id " + medicationId);
        }
    }

    public boolean deleteMedication(Long medicationId) throws Exception {
        Optional<Medication> medication = medicationRepository.findById(medicationId);
        if (medication.isPresent()) {
            medicationRepository.deleteById(medicationId);
            return true;
        } else {
            throw new Exception("Medication not found with id " + medicationId);
        }
    }
}
