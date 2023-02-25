package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.OperationChirurgical;
import tn.suptech.examenspring.repository.OperationChirurgicalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OperationChirurgicalService {

    @Autowired
    private OperationChirurgicalRepository operationChirurgicalRepository;

    public OperationChirurgical addOperationChirurgical(OperationChirurgical operationChirurgical) {
        return operationChirurgicalRepository.save(operationChirurgical);
    }

    public List<OperationChirurgical> getAllOperationChirurgical() {
        return operationChirurgicalRepository.findAll();
    }

    public OperationChirurgical getOperationChirurgicalById(Long operationChirurgicalId) throws Exception {
        Optional<OperationChirurgical> operationChirurgical = operationChirurgicalRepository.findById(operationChirurgicalId);
        if (operationChirurgical.isPresent()) {
            return operationChirurgical.get();
        } else {
            throw new Exception("OperationChirurgical not found with id " + operationChirurgicalId);
        }
    }

    public OperationChirurgical updateOperationChirurgical(Long operationChirurgicalId, OperationChirurgical operationChirurgicalDetails) throws Exception {
        Optional<OperationChirurgical> operationChirurgical = operationChirurgicalRepository.findById(operationChirurgicalId);
        if (operationChirurgical.isPresent()) {
            OperationChirurgical existingOperationChirurgical = operationChirurgical.get();
            existingOperationChirurgical.setDate(operationChirurgicalDetails.getDate());
            existingOperationChirurgical.setDescription(operationChirurgicalDetails.getDescription());
            existingOperationChirurgical.setPrix(operationChirurgicalDetails.getPrix());
            existingOperationChirurgical.setPatient(operationChirurgicalDetails.getPatient());
            existingOperationChirurgical.setMedicalStaff(operationChirurgicalDetails.getMedicalStaff());
            existingOperationChirurgical.setEquipments(operationChirurgicalDetails.getEquipments());
            return operationChirurgicalRepository.save(existingOperationChirurgical);
        } else {
            throw new Exception("OperationChirurgical not found with id " + operationChirurgicalId);
        }
    }

    public boolean deleteOperationChirurgical(Long operationChirurgicalId) throws Exception {
        Optional<OperationChirurgical> operationChirurgical = operationChirurgicalRepository.findById(operationChirurgicalId);
        if (operationChirurgical.isPresent()) {
            operationChirurgicalRepository.deleteById(operationChirurgicalId);
            return true;
        } else {
            throw new Exception("OperationChirurgical not found with id " + operationChirurgicalId);
        }
    }
}
