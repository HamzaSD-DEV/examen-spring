package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.HistoriqueMedical;
import tn.suptech.examenspring.repository.HistoriqueMedicalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueMedicalService {

    @Autowired
    private HistoriqueMedicalRepository historiqueMedicalRepository;

    public HistoriqueMedical addHistoriqueMedical(HistoriqueMedical historiqueMedical) {
        return historiqueMedicalRepository.save(historiqueMedical);
    }

    public List<HistoriqueMedical> getAllHistoriqueMedicals() {
        return historiqueMedicalRepository.findAll();
    }

    public HistoriqueMedical getHistoriqueMedicalById(Long historiqueMedicalId) throws Exception {
        Optional<HistoriqueMedical> historiqueMedical = historiqueMedicalRepository.findById(historiqueMedicalId);
        if (historiqueMedical.isPresent()) {
            return historiqueMedical.get();
        } else {
            throw new Exception("Historique medical not found with id " + historiqueMedicalId);
        }
    }

    public HistoriqueMedical updateHistoriqueMedical(Long historiqueMedicalId, HistoriqueMedical historiqueMedicalDetails) throws Exception {
        Optional<HistoriqueMedical> historiqueMedical = historiqueMedicalRepository.findById(historiqueMedicalId);
        if (historiqueMedical.isPresent()) {
            HistoriqueMedical existingHistoriqueMedical = historiqueMedical.get();
            existingHistoriqueMedical.setMedicalStaff(historiqueMedicalDetails.getMedicalStaff());
            existingHistoriqueMedical.setDateJour(historiqueMedicalDetails.getDateJour());
            existingHistoriqueMedical.setJourRepo(historiqueMedicalDetails.getJourRepo());
            existingHistoriqueMedical.setRepoMaladie(historiqueMedicalDetails.getRepoMaladie());
            existingHistoriqueMedical.setHeuresTravail(historiqueMedicalDetails.getHeuresTravail());
            existingHistoriqueMedical.setHeuresSupp(historiqueMedicalDetails.getHeuresSupp());
            return historiqueMedicalRepository.save(existingHistoriqueMedical);
        } else {
            throw new Exception("Historique medical not found with id " + historiqueMedicalId);
        }
    }

    public boolean deleteHistoriqueMedical(Long historiqueMedicalId) {
        try {
            historiqueMedicalRepository.deleteById(historiqueMedicalId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete historique medical with id " + historiqueMedicalId + " because it is associated with other entities.");
        }

    }
}
