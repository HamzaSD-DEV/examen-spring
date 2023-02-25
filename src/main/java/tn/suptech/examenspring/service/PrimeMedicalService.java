package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.PrimeMedical;
import tn.suptech.examenspring.repository.PrimeMedicalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrimeMedicalService {

    @Autowired
    private PrimeMedicalRepository primeMedicalRepository;

    public PrimeMedical addPrimeMedical(PrimeMedical primeMedical) {
        return primeMedicalRepository.save(primeMedical);
    }

    public List<PrimeMedical> getAllPrimeMedical() {
        return primeMedicalRepository.findAll();
    }

    public PrimeMedical getPrimeMedicalById(Long primeMedicalId) throws Exception {
        Optional<PrimeMedical> primeMedical = primeMedicalRepository.findById(primeMedicalId);
        if (primeMedical.isPresent()) {
            return primeMedical.get();
        } else {
            throw new Exception("PrimeMedical not found with id " + primeMedicalId);
        }
    }

    public PrimeMedical updatePrimeMedical(Long primeMedicalId, PrimeMedical primeMedicalDetails) throws Exception {
        Optional<PrimeMedical> primeMedical = primeMedicalRepository.findById(primeMedicalId);
        if (primeMedical.isPresent()) {
            PrimeMedical existingPrimeMedical = primeMedical.get();
            existingPrimeMedical.setPrimeName(primeMedicalDetails.getPrimeName());
            existingPrimeMedical.setPrimeValue(primeMedicalDetails.getPrimeValue());
            existingPrimeMedical.setPaymentDate(primeMedicalDetails.getPaymentDate());
            existingPrimeMedical.setMedicalPosition(primeMedicalDetails.getMedicalPosition());
            return primeMedicalRepository.save(existingPrimeMedical);
        } else {
            throw new Exception("PrimeMedical not found with id " + primeMedicalId);
        }
    }

    public boolean deletePrimeMedical(Long primeMedicalId) throws Exception {
        Optional<PrimeMedical> primeMedical = primeMedicalRepository.findById(primeMedicalId);
        if (primeMedical.isPresent()) {
            primeMedicalRepository.deleteById(primeMedicalId);
            return true;
        } else {
            throw new Exception("PrimeMedical not found with id " + primeMedicalId);
        }
    }
}
