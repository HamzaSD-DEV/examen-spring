package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.PrimeAdministrative;
import tn.suptech.examenspring.repository.PrimeAdministrativeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrimeAdministrativeService {

    @Autowired
    private PrimeAdministrativeRepository primeAdministrativeRepository;

    public PrimeAdministrative save(PrimeAdministrative primeAdministrative) {
        return primeAdministrativeRepository.save(primeAdministrative);
    }

    public List<PrimeAdministrative> findAll() {
        return primeAdministrativeRepository.findAll();
    }

    public PrimeAdministrative findById(Long primeAdministrativeId) throws ResourceNotFoundException {
        Optional<PrimeAdministrative> primeAdministrative = primeAdministrativeRepository.findById(primeAdministrativeId);
        if (primeAdministrative.isPresent()) {
            return primeAdministrative.get();
        } else {
            throw new ResourceNotFoundException("PrimeAdministrative not found with id " + primeAdministrativeId);
        }
    }

    public PrimeAdministrative update(Long primeAdministrativeId, PrimeAdministrative primeAdministrativeDetails) throws ResourceNotFoundException {
        Optional<PrimeAdministrative> primeAdministrative = primeAdministrativeRepository.findById(primeAdministrativeId);
        if (primeAdministrative.isPresent()) {
            PrimeAdministrative existingPrimeAdministrative = primeAdministrative.get();
            existingPrimeAdministrative.setPrimeName(primeAdministrativeDetails.getPrimeName());
            existingPrimeAdministrative.setPrimeValue(primeAdministrativeDetails.getPrimeValue());
            existingPrimeAdministrative.setPaymentDate(primeAdministrativeDetails.getPaymentDate());
            existingPrimeAdministrative.setAdministrativePosition(primeAdministrativeDetails.getAdministrativePosition());
            return primeAdministrativeRepository.save(existingPrimeAdministrative);
        } else {
            throw new ResourceNotFoundException("PrimeAdministrative not found with id " + primeAdministrativeId);
        }
    }

    public void deleteById(Long primeAdministrativeId) throws ResourceNotFoundException {
        Optional<PrimeAdministrative> primeAdministrative = primeAdministrativeRepository.findById(primeAdministrativeId);
        if (primeAdministrative.isPresent()) {
            primeAdministrativeRepository.deleteById(primeAdministrativeId);
        } else {
            throw new ResourceNotFoundException("PrimeAdministrative not found with id " + primeAdministrativeId);
        }
    }

}
