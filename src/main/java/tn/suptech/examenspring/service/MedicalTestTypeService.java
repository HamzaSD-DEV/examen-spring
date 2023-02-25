package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.MedicalTestType;
import tn.suptech.examenspring.repository.MedicalTestTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalTestTypeService {

    @Autowired
    private MedicalTestTypeRepository medicalTestTypeRepository;

    public MedicalTestType addMedicalTestType(MedicalTestType medicalTestType) {
        return medicalTestTypeRepository.save(medicalTestType);
    }

    public List<MedicalTestType> getAllMedicalTestTypes() {
        return medicalTestTypeRepository.findAll();
    }

    public MedicalTestType getMedicalTestTypeById(Long medicalTestTypeId) throws Exception {
        Optional<MedicalTestType> medicalTestType = medicalTestTypeRepository.findById(medicalTestTypeId);
        if (medicalTestType.isPresent()) {
            return medicalTestType.get();
        } else {
            throw new Exception("Medical test type not found with id " + medicalTestTypeId);
        }
    }

    public MedicalTestType updateMedicalTestType(Long medicalTestTypeId, MedicalTestType medicalTestTypeDetails) throws Exception {
        Optional<MedicalTestType> medicalTestType = medicalTestTypeRepository.findById(medicalTestTypeId);
        if (medicalTestType.isPresent()) {
            MedicalTestType existingMedicalTestType = medicalTestType.get();
            existingMedicalTestType.setNomTest(medicalTestTypeDetails.getNomTest());
            existingMedicalTestType.setDescription(medicalTestTypeDetails.getDescription());
            existingMedicalTestType.setPrix(medicalTestTypeDetails.getPrix());
            return medicalTestTypeRepository.save(existingMedicalTestType);
        } else {
            throw new Exception("Medical test type not found with id " + medicalTestTypeId);
        }
    }

    public boolean deleteMedicalTestType(Long medicalTestTypeId) {
        try {
            medicalTestTypeRepository.deleteById(medicalTestTypeId);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Cannot delete medical test type with id " + medicalTestTypeId + " because it is associated with other entities.");
        }

    }
}
