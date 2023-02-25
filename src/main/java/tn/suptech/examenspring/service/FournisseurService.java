package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Fournisseur;
import tn.suptech.examenspring.repository.FournisseurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur getFournisseurById(Long fournisseurId) throws Exception {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(fournisseurId);
        if (fournisseur.isPresent()) {
            return fournisseur.get();
        } else {
            throw new Exception("Fournisseur not found with id " + fournisseurId);
        }
    }

    public Fournisseur updateFournisseur(Long fournisseurId, Fournisseur fournisseurDetails) throws Exception {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(fournisseurId);
        if (fournisseur.isPresent()) {
            Fournisseur existingFournisseur = fournisseur.get();
            existingFournisseur.setNom(fournisseurDetails.getNom());
            existingFournisseur.setAdresse(fournisseurDetails.getAdresse());
            existingFournisseur.setTelephone(fournisseurDetails.getTelephone());
            existingFournisseur.setEmail(fournisseurDetails.getEmail());
            existingFournisseur.setIdentifier(fournisseurDetails.getIdentifier());
            existingFournisseur.setBank(fournisseurDetails.getBank());
            existingFournisseur.setRib(fournisseurDetails.getRib());
            return fournisseurRepository.save(existingFournisseur);
        } else {
            throw new Exception("Fournisseur not found with id " + fournisseurId);
        }
    }

    public boolean deleteFournisseur(Long fournisseurId) {
        try {
            fournisseurRepository.deleteById(fournisseurId);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete fournisseur with id " + fournisseurId + " because it is associated with other entities.");
        }

    }

}
