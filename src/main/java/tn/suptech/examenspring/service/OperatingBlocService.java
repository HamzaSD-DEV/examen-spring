package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.OperatingBloc;
import tn.suptech.examenspring.repository.OperatingBlocRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OperatingBlocService {

    @Autowired
    private OperatingBlocRepository operatingBlocRepository;

    public OperatingBloc addOperatingBloc(OperatingBloc operatingBloc) {
        return operatingBlocRepository.save(operatingBloc);
    }

    public List<OperatingBloc> getAllOperatingBlocs() {
        return operatingBlocRepository.findAll();
    }

    public OperatingBloc getOperatingBlocById(Long operatingBlocId) throws Exception {
        Optional<OperatingBloc> operatingBloc = operatingBlocRepository.findById(operatingBlocId);
        if (operatingBloc.isPresent()) {
            return operatingBloc.get();
        } else {
            throw new Exception("Operating bloc not found with id " + operatingBlocId);
        }
    }

    public OperatingBloc updateOperatingBloc(Long operatingBlocId, OperatingBloc operatingBlocDetails) throws Exception {
        Optional<OperatingBloc> operatingBloc = operatingBlocRepository.findById(operatingBlocId);
        if (operatingBloc.isPresent()) {
            OperatingBloc existingOperatingBloc = operatingBloc.get();
            existingOperatingBloc.setNom(operatingBlocDetails.getNom());
            existingOperatingBloc.setDescription(operatingBlocDetails.getDescription());
            return operatingBlocRepository.save(existingOperatingBloc);
        } else {
            throw new Exception("Operating bloc not found with id " + operatingBlocId);
        }
    }

    public boolean deleteOperatingBloc(Long operatingBlocId) {
        try {
            operatingBlocRepository.deleteById(operatingBlocId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete operating bloc with id " + operatingBlocId + " because it is associated with other entities.");
        }

    }
}
