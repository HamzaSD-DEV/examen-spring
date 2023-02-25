package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Pharmacie;
import tn.suptech.examenspring.repository.PharmacieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacieService {
    @Autowired
    private PharmacieRepository pharmacieRepository;

    public Pharmacie addPharmacie(Pharmacie pharmacie) {
        return pharmacieRepository.save(pharmacie);
    }

    public List<Pharmacie> getAllPharmacies() {
        return pharmacieRepository.findAll();
    }

    public Pharmacie getPharmacieById(Long pharmacieId) throws ResourceNotFoundException {
        Optional<Pharmacie> pharmacie = pharmacieRepository.findById(pharmacieId);
        if (pharmacie.isPresent()) {
            return pharmacie.get();
        } else {
            throw new ResourceNotFoundException("Pharmacie not found with id " + pharmacieId);
        }
    }

    public Pharmacie updatePharmacie(Long pharmacieId, Pharmacie pharmacieDetails) throws ResourceNotFoundException {
        Optional<Pharmacie> pharmacie = pharmacieRepository.findById(pharmacieId);
        if (pharmacie.isPresent()) {
            Pharmacie existingPharmacie = pharmacie.get();
            existingPharmacie.setNom(pharmacieDetails.getNom());
            existingPharmacie.setIdentifier(pharmacieDetails.getIdentifier());
            existingPharmacie.setBank(pharmacieDetails.getBank());
            existingPharmacie.setRib(pharmacieDetails.getRib());
            existingPharmacie.setAdresse(pharmacieDetails.getAdresse());
            return pharmacieRepository.save(existingPharmacie);
        } else {
            throw new ResourceNotFoundException("Pharmacie not found with id " + pharmacieId);
        }
    }

    public boolean deletePharmacie(Long pharmacieId) throws ResourceNotFoundException {
        Optional<Pharmacie> pharmacie = pharmacieRepository.findById(pharmacieId);
        if (pharmacie.isPresent()) {
            pharmacieRepository.deleteById(pharmacieId);
            return true;
        } else {
            throw new ResourceNotFoundException("Pharmacie not found with id " + pharmacieId);
        }
    }

}