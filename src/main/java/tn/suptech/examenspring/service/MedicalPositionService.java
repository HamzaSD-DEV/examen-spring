package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.MedicalPosition;
import tn.suptech.examenspring.repository.MedicalPositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalPositionService {
    @Autowired
    private MedicalPositionRepository medicalPositionRepository;

    public MedicalPosition addMedicalPosition(MedicalPosition medicalPosition) {
        return medicalPositionRepository.save(medicalPosition);
    }

    public List<MedicalPosition> getAllMedicalPositions() {
        return medicalPositionRepository.findAll();
    }

    public MedicalPosition getMedicalPositionById(Long medicalPositionId) throws Exception {
        Optional<MedicalPosition> medicalPosition = medicalPositionRepository.findById(medicalPositionId);
        if (medicalPosition.isPresent()) {
            return medicalPosition.get();
        } else {
            throw new Exception("Medical position not found with id " + medicalPositionId);
        }
    }

    public MedicalPosition updateMedicalPosition(Long medicalPositionId, MedicalPosition medicalPositionDetails) throws Exception {
        Optional<MedicalPosition> medicalPosition = medicalPositionRepository.findById(medicalPositionId);
        if (medicalPosition.isPresent()) {
            MedicalPosition existingMedicalPosition = medicalPosition.get();
            existingMedicalPosition.setPositionName(medicalPositionDetails.getPositionName());
            existingMedicalPosition.setHourlyWage(medicalPositionDetails.getHourlyWage());
            existingMedicalPosition.setOvertimeHourlyWage(medicalPositionDetails.getOvertimeHourlyWage());
            existingMedicalPosition.setPaidSickDays(medicalPositionDetails.getPaidSickDays());
            existingMedicalPosition.setPaidVacationDays(medicalPositionDetails.getPaidVacationDays());
            return medicalPositionRepository.save(existingMedicalPosition);
        } else {
            throw new Exception("Medical position not found with id " + medicalPositionId);
        }
    }

    public boolean deleteMedicalPosition(Long medicalPositionId) throws Exception {
        Optional<MedicalPosition> medicalPosition = medicalPositionRepository.findById(medicalPositionId);
        if (medicalPosition.isPresent()) {
            medicalPositionRepository.deleteById(medicalPositionId);
            return true;
        } else {
            throw new Exception("Medical position not found with id " + medicalPositionId);
        }
    }

}