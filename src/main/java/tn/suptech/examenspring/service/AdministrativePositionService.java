package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.AdministrativePosition;
import tn.suptech.examenspring.repository.AdministrativePositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativePositionService {

    @Autowired
    private AdministrativePositionRepository administrativePositionRepository;

    public AdministrativePosition addAdministrativePosition(AdministrativePosition administrativePosition) {
        return administrativePositionRepository.save(administrativePosition);
    }

    public List<AdministrativePosition> getAllAdministrativePositions() {
        return administrativePositionRepository.findAll();
    }

    public AdministrativePosition getAdministrativePositionById(Long administrativePositionId) throws Exception {
        Optional<AdministrativePosition> administrativePosition = administrativePositionRepository.findById(administrativePositionId);
        if (administrativePosition.isPresent()) {
            return administrativePosition.get();
        } else {
            throw new Exception("Administrative position not found with id " + administrativePositionId);
        }
    }

    public AdministrativePosition getAdministrativePositionByPositionName(String positionName) throws Exception {
        Optional<AdministrativePosition> administrativePosition = administrativePositionRepository.findByPositionName(positionName);
        if (administrativePosition.isPresent()) {
            return administrativePosition.get();
        } else {
            throw new Exception("Administrative position not found with name " + positionName);
        }
    }

    public AdministrativePosition updateAdministrativePosition(Long positionId, AdministrativePosition positionDetails) throws Exception {
        Optional<AdministrativePosition> position = administrativePositionRepository.findById(positionId);
        if (position.isPresent()) {
            AdministrativePosition existingPosition = position.get();
            existingPosition.setPositionName(positionDetails.getPositionName());
            existingPosition.setHourlyWage(positionDetails.getHourlyWage());
            existingPosition.setOvertimeHourlyWage(positionDetails.getOvertimeHourlyWage());
            existingPosition.setPaidSickDays(positionDetails.getPaidSickDays());
            existingPosition.setPaidVacationDays(positionDetails.getPaidVacationDays());
            return administrativePositionRepository.save(existingPosition);
        } else {
            throw new Exception("Administrative position not found with id " + positionId);
        }
    }


    public boolean deleteAdministrativePosition(Long administrativePositionId) {
        try {
            administrativePositionRepository.deleteById(administrativePositionId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete administrative position with id " + administrativePositionId + " because it is associated with other entities.");
        }
    }
}
