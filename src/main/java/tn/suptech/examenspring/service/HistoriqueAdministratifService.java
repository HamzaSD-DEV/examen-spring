package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.HistoriqueAdministratif;
import tn.suptech.examenspring.repository.HistoriqueAdministratifRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueAdministratifService {

    @Autowired
    private HistoriqueAdministratifRepository historiqueAdministratifRepository;

    public HistoriqueAdministratif addHistoriqueAdministratif(HistoriqueAdministratif historiqueAdministratif) {
        return historiqueAdministratifRepository.save(historiqueAdministratif);
    }

    public List<HistoriqueAdministratif> getAllHistoriqueAdministratifs() {
        return historiqueAdministratifRepository.findAll();
    }

    public HistoriqueAdministratif getHistoriqueAdministratifById(Long historiqueAdministratifId) throws Exception {
        Optional<HistoriqueAdministratif> historiqueAdministratif = historiqueAdministratifRepository.findById(historiqueAdministratifId);
        if (historiqueAdministratif.isPresent()) {
            return historiqueAdministratif.get();
        } else {
            throw new Exception("Historique administratif not found with id " + historiqueAdministratifId);
        }
    }

    public HistoriqueAdministratif updateHistoriqueAdministratif(Long historiqueAdministratifId, HistoriqueAdministratif historiqueAdministratifDetails) throws Exception {
        Optional<HistoriqueAdministratif> historiqueAdministratif = historiqueAdministratifRepository.findById(historiqueAdministratifId);
        if (historiqueAdministratif.isPresent()) {
            HistoriqueAdministratif existingHistoriqueAdministratif = historiqueAdministratif.get();
            existingHistoriqueAdministratif.setAdministrativeStaff(historiqueAdministratifDetails.getAdministrativeStaff());
            existingHistoriqueAdministratif.setDateJour(historiqueAdministratifDetails.getDateJour());
            existingHistoriqueAdministratif.setJourRepo(historiqueAdministratifDetails.getJourRepo());
            existingHistoriqueAdministratif.setRepoMaladie(historiqueAdministratifDetails.getRepoMaladie());
            existingHistoriqueAdministratif.setHeuresTravail(historiqueAdministratifDetails.getHeuresTravail());
            existingHistoriqueAdministratif.setHeuresSupp(historiqueAdministratifDetails.getHeuresSupp());
            return historiqueAdministratifRepository.save(existingHistoriqueAdministratif);
        } else {
            throw new Exception("Historique administratif not found with id " + historiqueAdministratifId);
        }
    }

    public boolean deleteHistoriqueAdministratif(Long historiqueAdministratifId) {
        try {
            historiqueAdministratifRepository.deleteById(historiqueAdministratifId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete historique administratif with id " + historiqueAdministratifId + " because it is associated with other entities.");
        }

    }
}
